using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using WPFClientApplication.ViewModel;
using WPFClientApplication.Model;
using EasyWpfLoginNavigateExample.ServiceReference1;
using System.Windows;
using WPFClientApplication.Helpers;
using System.Windows.Controls;
using SharedModelLibrary;
using System.Diagnostics;

namespace WPFClientApplication.ViewModel
{
    class UserInvitesViewModel : ViewModelBase
    {
        static int userId;
        public RelayCommand UpdateInvitesCommand { get; set; }

        public UserInvitesViewModel(int id)
        {
            userId = id;
            UpdateInvitesCommand = new RelayCommand(UpdateInvites);
        }

        private List<UserInvitesModel> _Invites = GetInvites();
        public List<UserInvitesModel> Invites
        {
            get
            {
                return _Invites;
            }

            set
            {
                _Invites = value;
                RaisePropertyChanged("UserInvites");
            }
        }

        private static List<UserInvitesModel> GetInvites()
        {
            ProjectServiceClient client = new ProjectServiceClient();
            IEnumerable<UserInvitesModel> userInvites = client.getTeamInvites(userId);

            return userInvites.ToList();
        }


        private void UpdateInvites(object obj)
        {
            ProjectServiceClient client = new ProjectServiceClient();
            client.updateTeamInvites(Invites.ToArray(), userId);
        }

        private bool _isAccepted;
        public bool IsAccepted
        {
            get { return _isAccepted; }
            set
            {
                if (_isAccepted == value) return;

                _isAccepted = value;

            }
        }

        private bool _isDeclined;
        public bool IsDeclined
        {
            get { return _isDeclined; }
            set
            {
                if (_isDeclined == value) return;

                _isDeclined = value;

            }
        }
    }
}
