using WPFClientApplication.Helpers;
using WPFClientApplication.Model;
using System.Windows.Controls;
using WPFClientApplication;
using WPFClientApplication.ViewModel;
using System.Diagnostics;
using System.Windows;
using EasyWpfLoginNavigateExample.ServiceReference;
using System.Collections.Generic;
using System.Collections;
using SharedModelLibrary;

namespace EasyWpfLoginNavigateExample.ViewModel
{
    class ProjectViewModel : ViewModelBase
    {

        public RelayCommand CreateProjectCommand { get; set; }
        public CreateProjectViewModel NewProject { get; set; }
        public UserModel CurrentUser;

        public ProjectViewModel(Border Stage, UserModel CurrentUser = null)
        {

            CreateProjectCommand = new RelayCommand(createProject);
            NewProject = new CreateProjectViewModel(CurrentUser);
            this.CurrentUser = CurrentUser;
            WPFClientApplication.ApplicationController.GetInstance().SetStage(Stage);

        }

        public void createProject(object obj)
        {
            if (NewProject.createProject())
            {
                showAddUsersToProject();
            }
            else
            {
                MessageBox.Show("Error - Project not created.");
            }
             

        }

        private void showAddUsersToProject()
        {
            ApplicationController.GetInstance().GoToPage(ApplicationPage.showAddUsersNewProject, CurrentUser);
        }
    }
}
