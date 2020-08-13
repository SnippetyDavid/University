using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using WPFClientApplication;
using WPFClientApplication.Helpers;
using WPFClientApplication.Model;
using WPFClientApplication.ViewModel;
using UserModel = SharedModelLibrary.UserModel;
using ProjectModel = SharedModelLibrary.ProjectModel;
using EasyWpfLoginNavigateExample.ServiceReference;
using EasyWpfLoginNavigateExample.ServiceReference1;
using SharedModelLibrary;


namespace EasyWpfLoginNavigateExample.ViewModel
{
    class SprintTeamViewModel : ViewModelBase
    {
        private static bool developer;
        public RelayCommand ShowAvailableDevelopers { get; set; }

        public SprintTeamViewModel()
        {
            ShowAvailableDevelopers = new RelayCommand(getAvailableDevs);
        }

        public void getAvailableDevs(object obj)
        {
            this.searchAvailableDevs();
        }

        private List<UserModel> searchAvailableDevs()
        {
            UserServiceClient client = new UserServiceClient();
            IEnumerable<UserModel> users = client.searchAvailableDevs(developer);
            return users.ToList();
        }

        private static List<UserModel> GetAllUsers()
        {
            UserServiceClient client = new UserServiceClient();
            IEnumerable<UserModel> users = client.getAllUsers();

            return users.ToList();
        }



    }
}