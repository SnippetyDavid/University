using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Diagnostics;
using SharedModelLibrary;
using UserModel = SharedModelLibrary.UserModel;

namespace WCFScrumManagement
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Service1" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select Service1.svc or Service1.svc.cs at the Solution Explorer and start debugging.
    public class User : UserService
    {
        // create the sql connection that connects to our hosted db
        SqlConnection con = new SqlConnection("Data Source=jdickinson03.public.cs.qub.ac.uk;Initial Catalog=jdickinson03;User ID=jdickinson03;Password=5rmp7b1x2hzsv42f");

        public Boolean InsertUserDetails(string username, string password, string email)
        {
            // open the sql connection
            con.Open();

            String query = "INSERT INTO Users(username,password,email) VALUES(@username, @password, @email)";

            SqlCommand cmd = new SqlCommand(query, con);
            cmd.Parameters.AddWithValue("@username", username);
            cmd.Parameters.AddWithValue("@password", password);
            cmd.Parameters.AddWithValue("@email", email);
            // execute the insert statement and store the result
            int result = cmd.ExecuteNonQuery();

            // close the sql connection
            con.Close();

            // check to see if the user was succesfully added and return a boolean value based on the result
            if (result == 1)
            {
                return true;
            }
            else
            {
                return false;
            }

        }

        public Boolean RegisterUser(string username, string password, string email, bool projectManager, bool scrumMaster, bool developer, string skillSet, byte[] data)
        {
            // open the sql connection
            con.Open();


            String query = "INSERT INTO Users(username,password,email,projectManager,scrumMaster,developer,skillSet, profile_image) VALUES(@username, @password, @email,@projectManager,@scrumMaster,@developer,@skillSet, @data)";

            SqlCommand cmd = new SqlCommand(query, con);
            cmd.Parameters.AddWithValue("@username", username);
            cmd.Parameters.AddWithValue("@password", password);
            cmd.Parameters.AddWithValue("@email", email);
            cmd.Parameters.AddWithValue("@data", data);

            int pm = 0;
            if (@projectManager == true)
            {
                pm = 1;
            }

            int sm = 0;
            if (scrumMaster == true)
            {
                sm = 1;
            }

            int dev = 0;
            if (developer == true)
            {

                dev = 1;
            }



            cmd.Parameters.AddWithValue("@projectManager", pm);
            cmd.Parameters.AddWithValue("@scrumMaster", sm);
            cmd.Parameters.AddWithValue("@developer", dev);
            cmd.Parameters.AddWithValue("@skillSet", skillSet);

            // execute the insert statement and store the result
            int result = cmd.ExecuteNonQuery();

            // close the sql connection
            con.Close();

            // check to see if the user was succesfully added and return a boolean value based on the result
            if (result == 1)
            {
                return true;
            }
            else
            {
                return false;
            }

        }

        //Method to be used by the client to retrieve a user object with details of the current user
        public UserModel GetUserDetails(string username)
        {
            UserModel userModel = new UserModel();

            try
            {
            con.Open();
            //define and execute the query to get the user's details
            String query = "SELECT * FROM users WHERE username = @username;";
            SqlCommand cmd = new SqlCommand(query, con);
            cmd.Parameters.AddWithValue("@username", username);
            SqlDataReader reader = cmd.ExecuteReader();

            if (reader.Read())
            {
                userModel.id = (int)reader["id"];
                userModel.UserName = (string)reader["username"];
                userModel.Password = (string)reader["password"];
                userModel.Email = (string)reader["email"];
                int pm = (int)reader["projectManager"];
                int sm = (int)reader["scrumMaster"];
                int dev = (int)reader["developer"];
                userModel.ProjectManager = Convert.ToBoolean(pm);
                userModel.ScrumMaster = Convert.ToBoolean(sm);
                userModel.Developer = Convert.ToBoolean(dev);
            }
            Debug.WriteLine(userModel.UserName);
                return userModel;

            }
            catch (SqlException ex)
            {
                Debug.WriteLine("There was a an SqlException: " + ex.ToString());
            }
            catch (Exception ex)
            {
                Debug.WriteLine("There was an Exception: " + ex.ToString());
            }

            return userModel;
        }

        public Boolean checkUserDetails(string username, string password)
        {
            // try and catch any exceptions thrown
            try
            {
                // open the sql connection
                con.Open();

                // Query string and execute the query
                String query = "SELECT * FROM users WHERE username = @username AND password = @password;";
                SqlCommand cmd = new SqlCommand(query, con);
                cmd.Parameters.AddWithValue("@username", username);
                cmd.Parameters.AddWithValue("@password", password);
                SqlDataReader reader = cmd.ExecuteReader();

                // close the sql connection
                

                if (reader.Read())
                {
                    con.Close();
                    return true;
                }

            }
            catch (SqlException ex)
            {
                Debug.WriteLine("There was a an SqlException: " + ex.ToString());
                return false;
            }
            catch (Exception ex)
            {
                Debug.WriteLine("There was an Exception: " + ex.ToString());
                return false;
            }
            con.Close();

            return false;

        }

        public Boolean checkRegisteredUserDetails(string email)
        {
            // open the sql connection
            con.Open();

            // Query string and execute the query
            String query = "SELECT * FROM users WHERE email = 'asdasd';";
            SqlCommand cmd = new SqlCommand(query, con);
            //cmd.Parameters.AddWithValue("@email", email);
            SqlDataReader reader = cmd.ExecuteReader();

            // Reader returns true if the email is in the database
            if (reader.HasRows)
            {
                // close the sql connection
                con.Close();
                return true;
            }
            else
            {
                // close the sql connection
                con.Close();
                return false;
            }

        }

        public List<UserModel> getAllUsers()
        {
            // open the sql connection
            con.Open();

            List<UserModel> users = new List<UserModel>();

            // Query string and execute the query
            String query = "SELECT * FROM users;";
            SqlCommand cmd = new SqlCommand(query, con);
            SqlDataReader reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                int pm = (int)reader["projectManager"];
                int sm = (int)reader["scrumMaster"];
                int dev = (int)reader["developer"];

                users.Add(
                        
                    new UserModel
                    {
                        id = (int)reader["id"],
                        UserName = (string)reader["username"],
                        Password = (string)reader["password"],
                        Email = (string)reader["email"],
                        ProjectManager = Convert.ToBoolean(pm),
                        ScrumMaster = Convert.ToBoolean(sm),
                        Developer = Convert.ToBoolean(dev)
                    }
                    );
            }
            con.Close();

            return users;
        }

        public List<UserModel> searchUsers(String username = null, String email = null, string skillset = null)
        {
            con.Open();
            List<UserModel> users = new List<UserModel>();
            String query = "SELECT * FROM users WHERE ";
            String join = "";


            if (username != null || !string.IsNullOrWhiteSpace(username))
            {
                query += "username LIKE '" + username + "%'";
                join = " and ";
            }

            if (email != null || !string.IsNullOrWhiteSpace(email))
            {
                query += join + "email LIKE '" + email + "%'";
                join = " and ";
            }

            if (skillset != null || !string.IsNullOrWhiteSpace(skillset))
            {
                query += join + "skillset LIKE '%" + skillset + "%'";
            }

            //if query is not null then run it
            if (query != "SELECT * FROM users WHERE ")
            {
                // Query string and execute the query
                SqlCommand cmd = new SqlCommand(query, con);
                SqlDataReader reader = cmd.ExecuteReader();
            
                while (reader.Read())
                {
                    int pm = (int)reader["projectManager"];
                    int sm = (int)reader["scrumMaster"];
                    int dev = (int)reader["developer"];
                    users.Add(

                        new UserModel
                        {
                            id = (int)reader["id"],
                            UserName = (string)reader["username"],
                            Password = (string)reader["password"],
                            Email = (string)reader["email"],
                            ProjectManager = Convert.ToBoolean(pm),
                            ScrumMaster = Convert.ToBoolean(sm),
                            Developer = Convert.ToBoolean(dev)
                        }
                        );
                }
                con.Close();
            }


            return users;
        }

        public List<UserModel> ShowTeamMembersByProject(String projectName)
        {
            con.Open();
            List<UserModel> users = new List<UserModel>();

            // Query string and execute the query
            String query = "SELECT * FROM users INNER JOIN projectTeam ON users.id = projectTeam.user_id INNER JOIN project ON projectTeam.project_id = project.id WHERE project.projectName = @projectName;";
            SqlCommand cmd = new SqlCommand(query, con);
            cmd.Parameters.AddWithValue("@projectName", projectName);
            SqlDataReader reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                users.Add(

                    new UserModel
                    {
                        id = (int)reader["id"],
                        UserName = (string)reader["username"],
                        Password = (string)reader["password"],
                        Email = (string)reader["email"]
                    }
                    );
            }
            con.Close();

            return users;
        }

        public List<UserModel> searchUserSkillset(string skillset)
        {
            con.Open();
            List<UserModel> users = new List<UserModel>();

            // Query string and execute the query
            String query = "SELECT * FROM users WHERE skillset LIKE '%" + skillset + "%';";
            SqlCommand cmd = new SqlCommand(query, con);
            SqlDataReader reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                users.Add(

                    new UserModel
                    {
                        id = (int)reader["id"],
                        UserName = (string)reader["username"],
                        Password = (string)reader["password"],
                        Email = (string)reader["email"],
                        SkillSet = (string)reader["skillset"]
                    }
                    );
            }
            con.Close();

            return users;
        }

        public List<UserModel> searchAvailableDevs(bool developer)
        {
            con.Open();
            List<UserModel> users = new List<UserModel>();

            // Query string and execute the query
            String query = "SELECT * FROM users WHERE developer = 1";
            SqlCommand cmd = new SqlCommand(query, con);
            SqlDataReader reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                int pm = (int)reader["projectManager"];
                int sm = (int)reader["scrumMaster"];
                int dev = (int)reader["developer"];
                users.Add(

                    new UserModel
                    {
                        id = (int)reader["id"],
                        UserName = (string)reader["username"],
                        Password = (string)reader["password"],
                        Email = (string)reader["email"],
                        SkillSet = (string)reader["skillset"],
                        ProjectManager = Convert.ToBoolean(pm),
                        ScrumMaster = Convert.ToBoolean(sm),
                        Developer = Convert.ToBoolean(dev)
                    }
                    );
            }
            con.Close();

            return users;
        }

        public bool addImageToDatabase(byte[] data)
        {
            con.Open();

            String query = "UPDATE Users set profile_image) VALUES(@data)";

            SqlCommand cmd = new SqlCommand(query, con);
            cmd.Parameters.AddWithValue("@data", data);


            // execute the insert statement and store the result
            int result = cmd.ExecuteNonQuery();

            // close the sql connection
            con.Close();

            // check to see if the user was succesfully added and return a boolean value based on the result
            if (result == 1)
            {
                return true;
            }
            else
            {
                return false;
            }

        }
    }
}
