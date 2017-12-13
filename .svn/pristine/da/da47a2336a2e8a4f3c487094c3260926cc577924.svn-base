using EasyWpfLoginNavigateExample.ServiceReference;
using EasyWpfLoginNavigateExample.ServiceReference1;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using WPFClientApplication;
using WPFClientApplication.Helpers;
using WPFClientApplication.Model;
using WPFClientApplication.ViewModel;
using UserModel = SharedModelLibrary.UserModel;
using ProjectModel = SharedModelLibrary.ProjectModel;


namespace EasyWpfLoginNavigateExample.ViewModel.Project
{
    class ShowTeamMembersViewModel : ViewModelBase
    {
        public RelayCommand ShowTeamMembersByProjectCommand { get; set; }

        public ShowTeamMembersViewModel()
        {

            ProjectSearch = new ProjectModel { ProjectName = "Enter Text" };

            ShowTeamMembersByProjectCommand = new RelayCommand(ShowTeamMembersByProject);
        }

        private ProjectModel _ProjectModel;
        public ProjectModel ProjectSearch
        {
            get { return _ProjectModel; }
            set
            {
                if (value != _ProjectModel)
                {
                    _ProjectModel = value;
                    RaisePropertyChanged("ProjectSearch");
                }
            }
        }

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


        // static method returns all the users in a user model object
        private static List<UserModel> GetAllUsers()
        {
            UserServiceClient client = new UserServiceClient();
            IEnumerable<UserModel> users = client.getAllUsers();

            
            return users.ToList();
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


        public void ShowTeamMembersByProject(object obj)
        {
            this.getTeamMembers();
        }

        private List<UserModel> getTeamMembers()
        {
            UserServiceClient client = new UserServiceClient();

            IEnumerable<UserModel> users = client.ShowTeamMembersByProject(this.ProjectSearch.ProjectName);

            return users.ToList();
        }

    }
}
