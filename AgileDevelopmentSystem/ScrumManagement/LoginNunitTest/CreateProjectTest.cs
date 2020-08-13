using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LoginNunitTest.ServiceReference2;
using LoginNunitTest.ServiceReference1;
using SharedModelLibrary;

namespace LoginNunitTest
{
    [TestFixture]
    class CreateProjectTest
    {
        //Test to see if a project gets added to the DB
         [Test]
         public void testCreateProject(){

             //Create a new project
             ProjectModel NewProj = new ProjectModel { ProjectName = "TestCase", ProjectDescription = "Boring" };
             ProjectServiceClient client = new ProjectServiceClient();
             NewProj = client.InsertProjectDetails(NewProj);
             String projNameResult = "TestCase";
             String projDescriptionResult = "Boring";
             
             Assert.AreEqual(NewProj.ProjectName, projNameResult);
             Assert.AreEqual(NewProj.ProjectDescription, projDescriptionResult);

         }
        
        //Test to see if users get added to a project
         [Test]
         public void testAddUsersToProject(){

             List<UserModel> selectedUsers = new List<UserModel>();
             UserServiceClient client = new UserServiceClient();
             UserModel NewUser = new UserModel {
                 UserName = "Homer Simpson", 
                 Password = "Springfield123", 
                 Email= "homer@springfieldnucularplant.com", 
                 ProjectManager= true, 
                 ScrumMaster = false, 
                 Developer = true };

             UserModel NewUser1 = new UserModel
             {
                 UserName = "Marge Simpson",
                 Password = "Springfield123",
                 Email = "homer@springfieldnucularplant.com",
                 ProjectManager = true,
                 ScrumMaster = true,
                 Developer = true
             };
             int id = 120;
             ProjectServiceClient projClient = new ProjectServiceClient();
             selectedUsers.Add(NewUser);
             selectedUsers.Add(NewUser1);

             //projClient.addUsersToProject(selectedUsers, id);

         }
    }
}
