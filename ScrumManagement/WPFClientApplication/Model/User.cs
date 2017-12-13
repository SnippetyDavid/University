
namespace WPFClientApplication.Model
{
    public class User
    {
        public string UserName { get; set; }
        public string Password { get; set; }
        public string Email { get; set; }
        public bool ProjectManager { get; set; }
        public bool ScrumMaster { get; set; }
        public bool Developer { get; set; }
    }
}
