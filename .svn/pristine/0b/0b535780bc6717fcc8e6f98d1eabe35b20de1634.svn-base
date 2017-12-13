using WPFClientApplication.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Diagnostics;
using EasyWpfLoginNavigateExample.ServiceReference;

namespace WPFClientApplication.ViewModel
{
    public class AuthenticationViewModel : ViewModelBase
    {
        public AuthenticationViewModel()
        {
            CurrentUser = new User { UserName = "username", Password = "password", Email = "email" };
        }

        private bool _IsAuthenticated;
        public bool AlreadyRegistered;

        public bool IsAuthenticated
        {
            get { return _IsAuthenticated; }
            set
            {
                if (value != _IsAuthenticated)
                {
                    _IsAuthenticated = value;
                    RaisePropertyChanged("IsAuthenticated");
                    RaisePropertyChanged("IsNotAuthenticated");
                }
            }
        }

        public bool IsNotAuthenticated
        {
            get
            {
                return !IsAuthenticated;
            }
        }

        public bool CanDoAuthenticated(object ignore)
        {
            return IsAuthenticated;
        }

        private User _CurrentUser;
        public User CurrentUser
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

        public void Authenticate()
        {
            UserServiceClient client = new UserServiceClient();

            bool Authenticated = false;

            //check user details in the database, if they are there it returns true
            IsAuthenticated = client.checkUserDetails(CurrentUser.UserName, CurrentUser.Password);

            if (Authenticated == true)
            {
                MessageBox.Show("Login Successful");
            }
            else
            {
                MessageBox.Show("Login Failed");
            }

        }

        public void LogOff()
        {
            IsAuthenticated = false;
        }

        public string getCurrentUser()
        {
            return CurrentUser.UserName;
        }

        public string getCurrentEmail()
        {
            return CurrentUser.Email;
        }
        public void IsRegisteredUser()
        {
            UserServiceClient client = new UserServiceClient();
            // TODO: checks if registration details are in database 

            string dssd = this.CurrentUser.Email;

            AlreadyRegistered = client.checkRegisteredUserDetails(this.CurrentUser.Email);
            if (AlreadyRegistered == true)
            {
                //popup dialog error that user already exists 
            }
            else
            {
                client.InsertUserDetails(this.CurrentUser.UserName, this.CurrentUser.Password, this.CurrentUser.Email);
            }
        }
		public bool getCurrentPmRole()
        {
            return CurrentUser.ProjectManager;
        }
        public bool getCurrentSmRole()
        {
            return CurrentUser.ScrumMaster;
        }
        public bool getCurrentDevRole()
        {
            return CurrentUser.Developer;
        }    }
}
