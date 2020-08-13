using EasyWpfLoginNavigateExample.ServiceReference1;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using WPFClientApplication.Helpers;
using NewSprintModel = SharedModelLibrary.NewSprintModel;

namespace WPFClientApplication.ViewModel
{
    class CreateSprintViewModel : ViewModelBase
    {
        public RelayCommand CreateSprintCommand { get; set; }

        private NewSprintModel _Sprint;
        public NewSprintModel Sprint
        {
            get { return _Sprint; }
            set
            {
                if (value != _Sprint)
                {
                    _Sprint = value;
                    RaisePropertyChanged("Sprint");
                }
            }
        }

        ProjectServiceClient client = new ProjectServiceClient();
        public CreateSprintViewModel(int projectId)
        {
            CreateSprintCommand = new RelayCommand(DoCreateNewSprint);
            Sprint = new NewSprintModel {SprintName="", ProjectId=projectId, StartDate=DateTime.Now, EndDate=DateTime.Now, WorkHours=0 };
        }

        private void DoCreateNewSprint(object obj)
        {
            if ((Sprint.EndDate - Sprint.StartDate).TotalDays < 7 || Sprint.EndDate < Sprint.StartDate)
            {
                MessageBox.Show("Please Enter a valid date range, where the end date is at least 7 days after the start date.");
            }
            else
            {
                bool result = client.InsertSprintDetails(Sprint);
                

                if (result == true)
                {
                    MessageBox.Show("Sprint Successfully created!");
                }
                else
                {
                    MessageBox.Show("Error Creating Sprint");
                }
            }
        }
    }
}
