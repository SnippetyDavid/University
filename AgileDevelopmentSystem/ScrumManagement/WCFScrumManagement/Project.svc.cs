using SharedModelLibrary;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Diagnostics;

namespace WCFScrumManagement
{

    public class Project : ProjectService
    {

        // create the sql connection that connects to our hosted db
        SqlConnection con = new SqlConnection("Data Source=jdickinson03.public.cs.qub.ac.uk;Initial Catalog=jdickinson03;User ID=jdickinson03;Password=5rmp7b1x2hzsv42f");

        // Inserts the project name and description into the projects table
        public ProjectModel InsertProjectDetails(ProjectModel project)
        {
            // open the sql connection
            con.Open();

            String query = "INSERT INTO Project(projectName,projectDescription, user_id) VALUES(@projectName, @projectDescription, @userid); SELECT SCOPE_IDENTITY();";

            SqlCommand cmd = new SqlCommand(query, con);
            cmd.Parameters.AddWithValue("@userid", project.currentUserId);
            cmd.Parameters.AddWithValue("@projectName", project.ProjectName);
            cmd.Parameters.AddWithValue("@projectDescription", project.ProjectDescription);
            
            // execute the insert statement and store the result
            int id = Convert.ToInt32(cmd.ExecuteScalar());
            // close the sql connection
            con.Close();
            
            project.id = id;

            return project;

        }


        public Boolean addUsersToProject(List<UserModel> selectedUsers, int projectId)
        {
            String query = "";
            String inviteQuery = "";

            foreach (UserModel user in selectedUsers)
            {
                int role_id = 0;
                if (user.IsDeveloperSelected)
                {
                    role_id = 1;
                }
                if (user.IsScrumMasterSelected)
                {
                    role_id = 2;
                }
                if (user.IsProjectManagerSelected)
                {
                    role_id = 3;
                }
                if (user.IsProjectOwnerSelected)
                {
                    role_id = 4;
                }

                query += "INSERT INTO ProjectTeam (project_id, user_id, roles_id, accepted) VALUES (" + projectId + "," + user.id + ","+ role_id +", 0)";
                inviteQuery += "INSERT INTO Invite (project_id, user_id, invited) VALUES (" + projectId + "," + user.id + ", 1)";

            }

            con.Open();

            SqlCommand cmd = new SqlCommand(query, con);
            SqlCommand cmd1 = new SqlCommand(inviteQuery, con);

            int result = cmd.ExecuteNonQuery();
            int result1 = cmd1.ExecuteNonQuery();

            // close the sql connection
            con.Close();

            if (result > 0)
            {
                return true;
            }

            return false;

        }

        // Method to be used by the client to create a new sprint for a project
        public Boolean InsertSprintDetails(NewSprintModel sprint)
        {
            con.Open();

            String query = "INSERT INTO ProjectSprint(project_id, startDate, endDate, daily_work_hours, sprint_name) VALUES(@projectid, @startDate, @endDate, @dailyHours, @sprintName);";

            SqlCommand cmd = new SqlCommand(query, con);
            cmd.Parameters.AddWithValue("@projectid", sprint.ProjectId);
            cmd.Parameters.AddWithValue("@startDate", sprint.StartDate);
            cmd.Parameters.AddWithValue("@endDate", sprint.EndDate);
            cmd.Parameters.AddWithValue("@dailyHours", sprint.WorkHours);
            cmd.Parameters.AddWithValue("@sprintName", sprint.SprintName);
            
            int result = cmd.ExecuteNonQuery();

            con.Close();

            // check to see if the sprint was succesfully added and return a boolean value based on the result
            if (result == 1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        // Method to be used by the client to create a new sprint for a project
        public Boolean InsertStoryDetails(NewUserStoriesToProductBacklogModel story)
        {
            con.Open();

            String query = "INSERT INTO ProjectBacklog(project_id, user_story, market_value, story_points) VALUES(@projectid, @userStory, @marketValue, @storyPoints);";

            SqlCommand cmd = new SqlCommand(query, con);
            cmd.Parameters.AddWithValue("@projectid", story.ProjectId);
            cmd.Parameters.AddWithValue("@userStory", story.userStory);
            cmd.Parameters.AddWithValue("@marketValue", story.marketValue);
            cmd.Parameters.AddWithValue("@storyPoints", story.storyPoints);

            int result = cmd.ExecuteNonQuery();

            con.Close();

            // check to see if the sprint was succesfully added and return a boolean value based on the result
            if (result == 1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        // Method to be used by the client to retrieve team invites for the user provided
        public List<UserInvitesModel> getTeamInvites(int userId)
        {
            con.Open();

            List<UserInvitesModel> invites = new List<UserInvitesModel>();

            String query = "SELECT ProjectTeam.id, Project.projectName, Roles.roleName FROM ProjectTeam, Project, Roles WHERE ProjectTeam.id = Project.id AND ProjectTeam.roles_id = Roles.id AND ProjectTeam.user_id = @userId AND ProjectTeam.accepted = 0;";
            SqlCommand cmd = new SqlCommand(query, con);
            cmd.Parameters.AddWithValue("@userId", userId);
            SqlDataReader reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                invites.Add(

                    new UserInvitesModel
                    {
                        ProjectID = (int)reader["id"],
                        ProjectName = (string)reader["projectName"],
                        ProjectRole = (string)reader["roleName"]
                    }
                    );
            }

            con.Close();

            return invites;
        }

        public List<UserInvitesModel> updateTeamInvites(List<UserInvitesModel> Invites, int userId)
        {

            con.Open();

            List<UserInvitesModel> acceptedInvites = new List<UserInvitesModel>();
            List<UserInvitesModel> declinedInvites = new List<UserInvitesModel>();
            String query = "";

            foreach (UserInvitesModel userInvite in Invites)
            {

                if (userInvite.IsAccepted || userInvite.IsDeclined)
                {
                    query += "UPDATE projectTeam SET accepted = '" + userInvite.IsAccepted + "' , declined = '"
                                + userInvite.IsDeclined + "' WHERE project_id = " + userInvite.ProjectID + " AND user_id = "+ userId +";";
                    

                }

                //Invites.Remove(userInvite);

            }

            Debug.WriteLine(query);
            SqlCommand cmd = new SqlCommand(query, con);                    
            cmd.ExecuteNonQuery();
            
            
            return Invites;

        }

    }
}
