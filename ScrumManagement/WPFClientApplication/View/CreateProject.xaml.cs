using EasyWpfLoginNavigateExample.ViewModel;
using SharedModelLibrary;
using System.Windows;


namespace EasyWpfLoginNavigateExample.View
{
    /// <summary>
    /// Interaction logic for CreateProject.xaml
    /// </summary>
    public partial class CreateProject : Window
    {
        public CreateProject(UserModel CurrentUser)
        {
            InitializeComponent();
            DataContext = new ProjectViewModel(Stage, CurrentUser);

        }
    }
}
