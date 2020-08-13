﻿using System;
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

namespace WPFClientApplication.ViewModel
{
    public class LoginViewModel : ViewModelBase
    {
        public RelayCommand LoginCommand { get; set; }
        public RelayCommand RegisterCommand { get; set; }

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

        // Method to authenticate the user opening a new main window if successful
        public void Authenticate()
        {
            UserServiceClient client = new UserServiceClient();

            bool IsAuthenticated;

            //check user details in the database, if they are there it returns true
            IsAuthenticated = client.checkUserDetails(CurrentUser.UserName, CurrentUser.Password);

            if (IsAuthenticated == true)
            {
                ApplicationController.GetInstance().NewMainWindow(Model.ApplicationPage.NewMainWindow, CurrentUser.UserName);
            }
            else
            {
                MessageBox.Show("Login Failed");
            }
        }

        // Constructor creates a new user object thats stores the information input in the text boxes
        public LoginViewModel(Border Stage)
        {
            LoginCommand = new RelayCommand(DoLogin);
            RegisterCommand = new RelayCommand(DoNewRegister);

            CurrentUser = new UserModel { UserName = "username", Password = "password" };

            ApplicationController.GetInstance().SetStage(Stage);
        }

        // Simple Method called by the login button to run the authenticate method
        private void DoLogin(object obj)
        {
            Authenticate();
        }

        // Method called by the register button, opens a new registration window
        private void DoNewRegister(object obj)
        {
            ApplicationController.GetInstance().GoToPage(Model.ApplicationPage.NewRegisterWindow);
        }

         

        
    }
}