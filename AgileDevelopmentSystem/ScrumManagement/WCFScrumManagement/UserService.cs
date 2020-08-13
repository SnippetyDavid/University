using SharedModelLibrary;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using System.Web;

namespace WCFScrumManagement
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "UserService" in both code and config file together.
    [ServiceContract]
    public interface UserService
    {

        [OperationContract]
        Boolean InsertUserDetails(string username, string password, string email);

        [OperationContract]
        Boolean RegisterUser(string username, string password, string email, bool projectManager, bool scrumMaster, bool developer, string skillSet, byte[] data);

        [OperationContract]
        Boolean checkUserDetails(string username, string password);

        [OperationContract]
        Boolean checkRegisteredUserDetails(string email);

        [OperationContract]
        UserModel GetUserDetails(string username);

        [OperationContract]
        List<UserModel> getAllUsers();

        [OperationContract]
        List<UserModel> searchUsers(string username, string email, string skillSet);

        [OperationContract]
        List<UserModel> ShowTeamMembersByProject(string projectName);

        [OperationContract]
        List<UserModel> searchUserSkillset(string skillset);

        [OperationContract]
        List<UserModel> searchAvailableDevs(bool developer);

        [OperationContract]
        bool addImageToDatabase(byte[] data);
        
    }
}
