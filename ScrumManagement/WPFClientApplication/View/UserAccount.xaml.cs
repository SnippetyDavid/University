using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using EasyWpfLoginNavigateExample.ServiceReference;
using SharedModelLibrary;

namespace EasyWpfLoginNavigateExample.View
{
    /// <summary>
    /// Interaction logic for UserAccount.xaml
    /// </summary>
    public partial class UserAccount : Window
    {
        UserModel cUser;

        UserServiceClient client = new UserServiceClient();

        public UserAccount( string user)
        {
            cUser = client.GetUserDetails(user);
            //cUser = new UserModel { UserName = user.UserName, Email = user.Email, ProjectManager = user.ProjectManager, ScrumMaster = user.ScrumMaster, Developer = user.Developer };
            InitializeComponent();
            this.DataContext = cUser;
        }
    }
}

