using EasyWpfLoginNavigateExample.Helpers;
using EasyWpfLoginNavigateExample.Model;
using EasyWpfLoginNavigateExample.ServiceReference;
using EasyWpfLoginNavigateExample.ServiceReference1;
using SharedModelLibrary;
using System;
using System.Collections.Generic;
using System.Windows;
using WPFClientApplication;
using WPFClientApplication.Model;
using WPFClientApplication.ViewModel;
using UserModel = SharedModelLibrary.UserModel;
using System.Linq;
using WPFClientApplication.Helpers;
using System.Diagnostics;
using EasyWpfLoginNavigateExample.View;

namespace EasyWpfLoginNavigateExample.ViewModel
{
    class CreateProjectViewModel : ViewModelBase
    {
        // static project id used to pass between methods
        private static int project_id;
        // static project name used to pass between methods    
        private static string projectName;
        // static project description used to pass between methods
        private static string projectDescription;
        public RelayCommand SelectUsersForProjectCommand { get; set; }
        public RelayCommand SearchUsersCommand { get; set; }
        private UserModel currentUser;

        //public RelayCommand SearchUserSkillset { get; set; }
        public CreateProjectViewModel(UserModel CurrentUser = null)
        {
            NewProj = new ProjectModel { ProjectName = "", ProjectDescription = "" };
            SelectUsersForProjectCommand = new RelayCommand(selectUsersForProject);
            SearchUsersCommand = new RelayCommand(getUserSearch);
            this.currentUser = CurrentUser;
            //SearchUserSkillset = new RelayCommand(getUserSkillset);

        }

        // create project function
        public Boolean createProject()
        {
            if(NewProj.ProjectName == "" || NewProj.ProjectDescription == "")
            {
                MessageBox.Show("You must enter a project name and description.");
                return false;
            }

            NewProj.currentUserId = currentUser.id;

            ProjectServiceClient client = new ProjectServiceClient();
            NewProj = client.InsertProjectDetails(NewProj);

            // if an id is greater than 0, then it was inserted into the DB successfully
            if (NewProj.id > 0)
            {
                project_id = NewProj.id;
                projectName = NewProj.ProjectName;
                projectDescription = NewProj.ProjectDescription;
                return true;
            }
            return false;
            
        }

        // Get all the users that have been selected for the project
        public void selectUsersForProject(object obj)
        {

            // Two lists, one for emails and one for selected users for project

            List<UserModel> selectedUsers = new List<UserModel>();

            bool usersRolesNotSelected = false;
            String username = "";

            foreach (UserModel user in Users)
            {
                if (user.IsSelected)
                {
                    if (user.IsDeveloperSelected != true && user.IsProjectOwnerSelected != true && user.IsScrumMasterSelected != true)
                    {
                        usersRolesNotSelected = true;
                        username = user.UserName;
                        break;
                    }
                    selectedUsers.Add(user);
                }
            }

            // Check empty list
            if (usersRolesNotSelected)
            {
                MessageBox.Show("You must select a role for user :" + username);
            }
            else if(selectedUsers.Count == 0)
            {
                MessageBox.Show("You must select users to add to the project.");

            }
            else
            {
                this.currentUser.IsProjectManagerSelected = true;
                selectedUsers.Add(this.currentUser);
                ProjectServiceClient client = new ProjectServiceClient();
                Boolean usersAdded = client.addUsersToProject(selectedUsers.ToArray(), project_id);

                if (usersAdded)
                {
                    MessageBox.Show("Project Created Successfully - Invites have been sent.");
                    EmailHelper.emailInvites(selectedUsers, projectName, projectDescription);
                    Application.Current.MainWindow.Close();


                    //Will finish this at a later date.
                    //ApplicationController.GetInstance().GoToPage(ApplicationPage.showCreatedProject);
                }
                else
                {
                    MessageBox.Show("Sorry - Users were not added to the project");
                }
            }
            //Closes window on button press
            var win = Application.Current.Windows.OfType<Window>().SingleOrDefault(x => x.IsActive);
            win.Close();
        }

        public void getUserSearch(object obj)
        {
            this.Users = this.searchUsers();        
        }
        private List<UserModel> searchUsers()
        {
            UserServiceClient client = new UserServiceClient();
            IEnumerable<UserModel> users = client.searchUsers(this.username, this.email, this.skillset);
            this.username = null;
            this.email = null;
            this.skillset = null;
            return users.ToList();
        }

        // static method returns all the users in a user model object
        private static List<UserModel> GetAllUsers()
        {
            UserServiceClient client = new UserServiceClient();
            IEnumerable<UserModel> users = client.getAllUsers();

            return users.ToList();
        }


        #region INotifyChanged Events
        private List<UserModel> _Users = GetAllUsers();

        public List<UserModel> Users
        {
            get
            {
                return _Users;
            }

            set
            {
                _Users = value;
                RaisePropertyChanged("Users");
            }
        }


        private string _Username;
        public string username
        {
            get
            {
                return _Username;
            }

            set
            {
                _Username = value;
                RaisePropertyChanged("username");
            }
        }

        private string _Email;
        public string email
        {
            get
            {
                return _Email;
            }

            set
            {
                _Email = value;
                RaisePropertyChanged("email");
            }
        }

        private string _Skillset;
        public string skillset
        {
            get
            {
                return _Skillset;
            }
            set
            {
                _Skillset = value;
                RaisePropertyChanged("skillset");
            }
        }

        private bool _isSelected;
        public bool IsSelected
        {
            get { return _isSelected; }
            set
            {
                if (_isSelected == value) return;

                _isSelected = value;

            }
        }



        private bool _isScrumMasterSelected;
        public bool IsScrumMasterSelected
        {
            get { return _isScrumMasterSelected; }
            set
            {
                if (_isScrumMasterSelected == value) return;

                _isScrumMasterSelected = value;

            }
        }
        private bool _isProjectOwnerSelected;
        public bool IsProjectOwnerSelected
        {
            get { return _isProjectOwnerSelected; }
            set
            {
                if (_isProjectOwnerSelected == value) return;

                _isProjectOwnerSelected = value;

            }
        }

        private bool _isDeveloperSelected;
        public bool IsDeveloperSelected
        {
            get { return _isDeveloperSelected; }
            set
            {
                if (_isDeveloperSelected == value) return;

                _isDeveloperSelected = value;

            }
        }
        
        private ProjectModel _NewProj;
        public ProjectModel NewProj
        {
            get { return _NewProj; }
            set
            {
                if (value != _NewProj)
                {
                    _NewProj = value;
                    RaisePropertyChanged("NewProj");
                }
            }
        }
        #endregion
    }
}
