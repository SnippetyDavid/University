using EasyWpfLoginNavigateExample.ServiceReference1;
using EasyWpfLoginNavigateExample.ServiceReference;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using WPFClientApplication.Helpers;
using WPFClientApplication.ViewModel;
using NewUserStoriesToProductBacklogModel = SharedModelLibrary.NewUserStoriesToProductBacklogModel;
using System.Windows;
using SharedModelLibrary;

namespace EasyWpfLoginNavigateExample.ViewModel.Sprints
{
    class AddUserStoriesToProductBacklogViewModel : ViewModelBase
    {
        
        public RelayCommand AddUserStoriesCommand { get; set;}

        private NewUserStoriesToProductBacklogModel _Stories;

        public NewUserStoriesToProductBacklogModel Stories
        {
            get { return _Stories; }
            set
            {
                if (value != _Stories)
                {
                    _Stories = value;
                    RaisePropertyChanged("Stories");
                }
            }
        }

        ProjectServiceClient client = new ProjectServiceClient();
        public AddUserStoriesToProductBacklogViewModel(int projectId)
        {
            AddUserStoriesCommand = new RelayCommand(DoCreateNewStory);
            Stories = new NewUserStoriesToProductBacklogModel { ProjectId = projectId, userStory = "", marketValue = 0, storyPoints=0 };
        }

        private void DoCreateNewStory(object obj)
        {
           
                bool result = client.InsertStoryDetails(Stories);


                if (result == true)
                {
                    MessageBox.Show("Story inserted Successfully!");
                }
                else
                {
                    MessageBox.Show("Error Creating Story");
                }
        }

    }
}
