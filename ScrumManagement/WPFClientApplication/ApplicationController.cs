using WPFClientApplication.Model;
using WPFClientApplication.View;
using System.Windows.Controls;
using EasyWpfLoginNavigateExample.View;
using SharedModelLibrary;

namespace WPFClientApplication
{
    class ApplicationController
    {
        static ApplicationController _instance;
        public static ApplicationController GetInstance()
        {

            if (_instance == null)
                _instance = new ApplicationController();
            return _instance;
        }

        Border _stage;

        private ApplicationController() { }

        public void GoToPage(ApplicationPage page, UserModel CurrentUser = null)
        {
            switch (page)
            {
                case ApplicationPage.NewRegisterWindow:
                    var reg = new RegistrationForm();
                    reg.Show();
                    break;
                case ApplicationPage.NewProjectWindow:
                    var win1 = new CreateProject(CurrentUser);
                    win1.Show();
                    break;
                case ApplicationPage.showAddUsersNewProject:
                    _stage.Child = new addUsersToProject(CurrentUser);
                    break;
                case ApplicationPage.showCreatedProject:
                    _stage.Child = new showCreatedProject();
                    break;
                case ApplicationPage.ShowProjectOverview:
                    _stage.Child = new ProjectOverview();
                    break;
            }
        }


        public void NewAccountWindow(object obj, string user)
        {
            var acc = new UserAccount( user );
            acc.Show();
        }

        public void NewUserInvitesWindow(object obj, int id)
        {
            _stage.Child = new UserInvitesControl(id);
        }

        public void NewMainWindow(object obj, string user)
        {
            var acc = new MainWindow(user);
            acc.Show();
        }

        public void SetStage(Border Stage)
        {
            _stage = Stage;
        }

    }
}
