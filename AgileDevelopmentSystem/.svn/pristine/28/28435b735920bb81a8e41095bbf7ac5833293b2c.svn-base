using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using WPFClientApplication.Helpers;
using EasyWpfLoginNavigateExample.Helpers;
using WPFClientApplication.Model;
using EasyWpfLoginNavigateExample.ServiceReference;
using WPFClientApplication.View;
using System.Diagnostics;
using System.Net.Mail;
using System.Net;
using System.Windows;
using SharedModelLibrary;
using System.Windows.Forms;
//using System.Windows.Forms.PictureBox;
using System.Windows.Media.Imaging;
using EasyWpfLoginNavigateExample.ViewModel;
using System.IO;
using System.Windows.Media;
using System.Windows.Input;
//using System.Drawing;
//using System.Drawing.Imaging;
using System.Windows.Controls;


namespace WPFClientApplication.ViewModel
{
    public class RegistrationViewModel : ViewModelBase
    {
        public RelayCommand RegisterCommand { get; set; }
        public RelayCommand BrowseCommand { get; set; }
        public AuthenticationViewModel AuthVM { get; set; }

        public bool AlreadyRegistered;

        // static variables used to pass between methods
        private static string registeringUserName;
        private static string registeringPassword;
        private static string registeringEmail;
        private static string registeringSkillSet;
        private static byte[] data;

        public RegistrationViewModel()
        {
            AuthVM = new AuthenticationViewModel();
            RegisteringUser = new UserModel { UserName = "username", Password = "password", Email = "email", ProjectManager = false, ScrumMaster = false, Developer = false, SkillSet = "skillSet" };
            RegisterCommand = new RelayCommand(DoRegister);
            BrowseCommand = new RelayCommand(DoBrowse);
            //UpdatePictureCommand = new RelayCommand(OnUpdatePictureCommand, CanUpdatePictureCommand);



        }


        private UserModel _RegisteringUser;
        public UserModel RegisteringUser
        {
            get { return _RegisteringUser; }
            set
            {
                if (value != _RegisteringUser)
                {
                    _RegisteringUser = value;
                    RaisePropertyChanged("RegisteringUser");
                    registeringUserName = this.RegisteringUser.UserName;
                    registeringPassword = this.RegisteringUser.Password;
                    registeringEmail = this.RegisteringUser.Email;
                    registeringSkillSet = this.RegisteringUser.SkillSet;
                }
            }


        }

        private BitmapImage _ProfilePicture;

        public BitmapImage profilePicture
        {
            get { return _ProfilePicture; }
            set
            {
                if (value != _ProfilePicture)
                {
                    _ProfilePicture = value;
                    RaisePropertyChanged("profilePicture");

                }
            }
        }

        private void DoRegister(object obj)
        {
            UserServiceClient client = new UserServiceClient();

            client.RegisterUser(this.RegisteringUser.UserName, this.RegisteringUser.Password, this.RegisteringUser.Email, this.RegisteringUser.ProjectManager, this.RegisteringUser.ScrumMaster, this.RegisteringUser.Developer, this.RegisteringUser.SkillSet, data);
            //Call registerEmail method to send email
            EmailHelper.registerEmail(this.RegisteringUser.UserName, this.RegisteringUser.Password, this.RegisteringUser.Email, this.RegisteringUser.SkillSet);

        }

        private void DoBrowse(object obj)
        {
            try
            {
                //Open File Dialog
                OpenFileDialog dlg = new OpenFileDialog();
                //Give the prefrred file type options
                dlg.Filter = "JPG Files (*.jpg|*.jpg|GIF Files (*.gif)|*.gif|All Files (*.*)|*.*";
                //Set Title of Dialog
                dlg.Title = "Choose Profile Picture";
                if (dlg.ShowDialog() == System.Windows.Forms.DialogResult.OK)
                {
                    FileStream fs = new FileStream(dlg.FileName, FileMode.Open, FileAccess.Read);
                    data = new byte[fs.Length];
                    fs.Read(data, 0, System.Convert.ToInt32(fs.Length));
                    fs.Close();
                }
            }
            catch (Exception ex)
            {
                System.Windows.Forms.MessageBox.Show(ex.Message);
            }
        }

        //  private void SelectedPath(object) { 

        //}

        /*  private void OnUpdatePictureCommand(object obj)
          {
              OpenFileDialog OpenFileDialog = new OpenFileDialog();

              OpenFileDialog.Filter = "JPG Files (*.jpg|*.jpg|GIF Files (*.gif)|*.gif|All Files (*.*)|*.*";
              OpenFileDialog.Title = "Choose Profile Picture";

              if (OpenFileDialog.ShowDialog() == System.Windows.Forms.DialogResult.OK)
              {
                  (listbox.SelectedItem as ContactManager.ViewModel.Contact).Photo = 
                      LoadPhoto(OpenFileDialog.FileName);
                  Stream reader = File.OpenRead(OpenFileDialog.FileName);
                  Image photo = Image.FromStream((Stream)reader);

                  MemoryStream finalStream = new MemoryStream();
                  photo.Save(finalStream, ImageFormat.Png);

                  // translate to image source
                  PngBitmapDecoder decoder = new PngBitmapDecoder(finalStream, BitmapCreateOptions.PreservePixelFormat,BitmapCacheOption.Default);
                  EmployeePicture = decoder.Frames[0]; ;
              }
          }

          private ImageSource _employeePicture;
          public ImageSource EmployeePicture
           {
             get
            {
                  return _employeePicture;
               }
               set
               {
                  _employeePicture = value;
                  RaisePropertyChanged("EmployeePicture");
               }
            }
  */

    }
}

