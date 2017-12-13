using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using WPFClientApplication.ViewModel;
using WPFClientApplication.Model;
using EasyWpfLoginNavigateExample.ServiceReference;
using System.Windows;
using WPFClientApplication.Helpers;
using System.Windows.Controls;
using SharedModelLibrary;
using EasyWpfLoginNavigateExample.ViewModel.Project;

namespace WPFClientApplication.ViewModel
{
    public class MainWindowViewModel : ViewModelBase
    {
        public RelayCommand LogoutCommand { get; set; }
        public RelayCommand NewAccountWindowCommand { get; set; }
        public RelayCommand NewUserInvitesWindowCommand { get; set; }
        public RelayCommand CreateProjectCommand { get; set; }
        public RelayCommand OpenProjectCommand { get; set; }

        UserServiceClient client = new UserServiceClient();


        public ProjectOverviewViewModel projectOverview { get; set; }

        // Constructor for the main window, takes the username of the user that logs in
        public MainWindowViewModel(Border stage, string user)
        {
            CurrentUser = client.GetUserDetails(user); 
            LogoutCommand = new RelayCommand(DoLogout);
            NewAccountWindowCommand = new RelayCommand(DoNewAccountWindow);
            NewUserInvitesWindowCommand = new RelayCommand(DoNewInvitesWindow);
            CreateProjectCommand = new RelayCommand(DoNewProjectWindow);
            OpenProjectCommand = new RelayCommand(OpenProjectWindow);

            projectOverview = new ProjectOverviewViewModel();
            WPFClientApplication.ApplicationController.GetInstance().SetStage(stage);

        }

        private UserModel _CurrentUser;
        public UserModel CurrentUser
        {
            get { return _CurrentUser; }
            set
            {
                if (value != _CurrentUser)
                {
                    _CurrentUser = value;
                    RaisePropertyChanged("CurrentUser");
                }
            }
        }
        private void OpenProjectWindow(object obj)
        {
            ApplicationController.GetInstance().GoToPage(Model.ApplicationPage.ShowProjectOverview);
        }
        // Simple method to close the window and log the user out
        private void DoLogout(object obj)
        {
            MessageBox.Show("TODO logout");
        }

        // called by the view account button, opens a new account details window
        private void DoNewAccountWindow(object obj)
        {
            ApplicationController.GetInstance().NewAccountWindow(Model.ApplicationPage.NewAccountWindow, CurrentUser.UserName);
        }
        private void DoNewProjectWindow(object obj)
        {
            ApplicationController.GetInstance().GoToPage(Model.ApplicationPage.NewProjectWindow, CurrentUser);
        }
        private void DoNewInvitesWindow(object obj)
        {
            ApplicationController.GetInstance().NewUserInvitesWindow(Model.ApplicationPage.NewInvitesWindow, CurrentUser.id);
        }
    }
}
