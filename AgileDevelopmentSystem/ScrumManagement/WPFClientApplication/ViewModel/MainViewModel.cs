﻿using WPFClientApplication.Helpers;
using WPFClientApplication.Model;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using EasyWpfLoginNavigateExample.ServiceReference;

namespace WPFClientApplication.ViewModel
{
    public class MainViewModel : ViewModelBase
    {
        public RelayCommand LoginCommand { get; set; }
        public RelayCommand LogoutCommand { get; set; }
        public RelayCommand RegisterCommand { get; set; }
        public RelayCommand NewControlCommand { get; set; }
        public RelayCommand NewWindowCommand { get; set; }
        public RelayCommand NewAccountWindowCommand { get; set; }
        public RelayCommand NewControl2Command { get; set; }

        public RelayCommand NewProjectCommand { get; set; }

        public AuthenticationViewModel AuthVM { get; set; }

        private FrameworkElement _SubView;
        public FrameworkElement SubView
        {
            get { return _SubView; }
            set
            {
                if (value != _SubView)
                {
                    _SubView = value;
                    RaisePropertyChanged("SubView");
                }
            }
        }

        private double _InputValue;
        public double InputValue
        {
            get { return _InputValue; }
            set
            {
                if (value != _InputValue)
                {
                    _InputValue = value;
                    RaisePropertyChanged("InputValue");
                }
            }
        }

        public List<MyMenuItem> TheMenu { get; set; }

        public MainViewModel(Border Stage)
        {
            AuthVM = new AuthenticationViewModel();

            LoginCommand = new RelayCommand(DoLogin);
            RegisterCommand = new RelayCommand(DoNewRegister);

            LogoutCommand = new RelayCommand(DoLogout, AuthVM.CanDoAuthenticated);
            NewControlCommand = new RelayCommand(DoNewControl, CanDoNewControl);
            NewWindowCommand = new RelayCommand(DoNewWindow, CanDoNewWindow);
            NewAccountWindowCommand = new RelayCommand(DoNewAccountWindow, CanDoNewAccountWindow);
            NewControl2Command = new RelayCommand(DoNewControl2, CanDoNewControl2);

            NewProjectCommand = new RelayCommand(DoNewProjectWindow, CanDoNewControl);

            TheMenu = new List<MyMenuItem>
            {
                new MyMenuItem { Header = "Log off", Command = LogoutCommand },
                new MyMenuItem { Header = "Create Project", Command = NewProjectCommand },
                new MyMenuItem { Header = "View Account", Command = NewAccountWindowCommand },
                new MyMenuItem { Header = "Other stuff", 
                    Children = new List<MyMenuItem>
                    {
                        new MyMenuItem { Header = "Load new control", Command = NewControlCommand },
                        new MyMenuItem { Header = "Load control v2", Command = NewControl2Command },
                        new MyMenuItem { Header = "Open new window", Command = NewWindowCommand },
                    },
                },
            };

            ApplicationController.GetInstance().SetStage(Stage);
        }

        private void DoLogin(object obj)
        {
            AuthVM.Authenticate();
        }

        private bool CanDoLogout(object obj)
        {
            return AuthVM.IsAuthenticated;
        }

        private void DoLogout(object obj)
        {
            AuthVM.LogOff();
        }

        private void DoNewRegister(object obj)
        {
            ApplicationController.GetInstance().GoToPage(Model.ApplicationPage.NewRegisterWindow);
        }

        private bool CanDoNewControl(object obj)
        {
            return AuthVM.IsAuthenticated;
        }

        private void DoNewControl(object obj)
        {
            ApplicationController.GetInstance().GoToPage(Model.ApplicationPage.NewControl1);
        }

        private void DoNewProjectWindow(object obj)
        {
            ApplicationController.GetInstance().GoToPage(Model.ApplicationPage.NewProjectWindow);
        }
        private bool CanDoNewWindow(object obj)
        {
            return AuthVM.IsAuthenticated;
        }

        private void DoNewWindow(object obj)
        {
            ApplicationController.GetInstance().GoToPage(Model.ApplicationPage.NewWindow2);
        }

        private bool CanDoNewAccountWindow(object obj)
        {
            return AuthVM.IsAuthenticated;
        }

        private void DoNewAccountWindow(object obj)
        {
            ApplicationController.GetInstance().NewAccountWindow(Model.ApplicationPage.NewAccountWindow, AuthVM.getCurrentUser());
        }
        private bool CanDoNewControl2(object obj)
        {
            return AuthVM.IsAuthenticated;
        }

        private void DoNewControl2(object obj)
        {
            var element = new Slider { Width = 100 };
            element.SetBinding(Slider.ValueProperty, new Binding("InputValue") { Mode = BindingMode.TwoWay });
            element.SetBinding(Slider.IsEnabledProperty, new Binding("IsAuthenticated") { Source = AuthVM });
            SubView = element;
        }

        public void GetProjects()
        {
            UserServiceClient client = new UserServiceClient();

            //check user details in the database, if they are there it returns true
        //    IsAuthenticated = client.checkUserDetails(this.CurrentUser.UserName, this.CurrentUser.Password);
        }
    }
}
