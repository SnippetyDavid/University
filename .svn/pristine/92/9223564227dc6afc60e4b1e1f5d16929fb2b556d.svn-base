using SharedModelLibrary;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace WCFScrumManagement
{
    [ServiceContract]
    public interface ProjectService
    {
        [OperationContract]
        ProjectModel InsertProjectDetails(ProjectModel project);

        [OperationContract]
        Boolean addUsersToProject(List<UserModel> selectedUsers, int projectId);

        [OperationContract]
        List<UserInvitesModel> getTeamInvites(int userId);

        [OperationContract]
        List<UserInvitesModel> updateTeamInvites(List<UserInvitesModel> Invites, int userId);

        [OperationContract]
        Boolean InsertSprintDetails(NewSprintModel sprint);

        [OperationContract]
        Boolean InsertStoryDetails(NewUserStoriesToProductBacklogModel story);

    }
}
