using EasyWpfLoginNavigateExample.ServiceReference1;
using SharedModelLibrary;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Text;
using System.Windows;

namespace EasyWpfLoginNavigateExample.Helpers
{
    class EmailHelper
    {

        public static void emailInvites(List<UserModel> inviteUsers, string projectName, string projectDescription)
        {
            try
            {
                //Sets the client to a Gmail port
                SmtpClient client = new SmtpClient("smtp.gmail.com", 587);
                client.EnableSsl = true;
                client.Timeout = 10000;
                client.DeliveryMethod = SmtpDeliveryMethod.Network;
                client.UseDefaultCredentials = false;
                //Sets client to waterfallltd@gmail.com account
                client.Credentials = new NetworkCredential("waterfallltd@gmail.com", "Waterfall123");
                MailMessage msg = new MailMessage();

                    foreach (UserModel user in inviteUsers)
                    {
                        if (user.IsSelected)
                        {
                            if(user.IsProjectOwnerSelected == true){

                                msg.To.Add(user.Email);
                                msg.From = new MailAddress("waterfallltd@gmail.com");
                                msg.Subject = "Confirmation Email";
                                msg.Body = "Hi" + " " + user.UserName + "," + "\r\r" + " You are now added to a project.\r\r This is the project name:\r\r  "
                                           + projectName + "\r\r This is the project Description:\r\r   " + projectDescription + "\r\r You have been selected as a product owner for this project. Congrats" 
                                           +" \r\r Regards, \r Darryl Stewart \r Waterfall LTD";
                                client.Send(msg);

                            }
                            if (user.IsScrumMasterSelected == true)
                            {

                                msg.To.Add(user.Email);
                                msg.From = new MailAddress("waterfallltd@gmail.com");
                                msg.Subject = "Confirmation Email";
                                msg.Body = "Hi" + " " + user.UserName + "," + "\r\r" + " You are now added to a project.\r\r This is the project name:\r\r  "
                                           + projectName + "\r\r This is the project Description:\r\r   " + projectDescription 
                                           + "\r\r You have been selected as a Scrum master for this project. Congrats" + " \r\r Regards, \r Darryl Stewart \r Waterfall LTD";
                                client.Send(msg);

                            }
                            if (user.IsDeveloperSelected == true)
                            {

                                msg.To.Add(user.Email);
                                msg.From = new MailAddress("waterfallltd@gmail.com");
                                msg.Subject = "Confirmation Email";
                                msg.Body = "Hi" + " " + user.UserName + "," + "\r\r" + " You are now added to a project.\r\r This is the project name:\r\r  "
                                           + projectName + "\r\r This is the project Description:\r\r   " + projectDescription +
                                           "\r\r You have been selected as a developer for this project. Congrats" + " \r\r Regards, \r Darryl Stewart \r Waterfall LTD";
                                client.Send(msg);

                            }
                        }
                    }
            }
            catch (Exception ex)
            {
            }
        }

        public static void registerEmail(string registeringUserName, string registeringPassword, string registeringEmail, string skillSet ) 
        {

            try
            {
                //Sets the client to a Gmail port
                SmtpClient client1 = new SmtpClient("smtp.gmail.com", 587);
                client1.EnableSsl = true;
                client1.Timeout = 10000;
                client1.DeliveryMethod = SmtpDeliveryMethod.Network;
                client1.UseDefaultCredentials = false;
                //Sets client to waterfallltd@gmail.com
                client1.Credentials = new NetworkCredential("waterfallltd@gmail.com", "Waterfall123");
                MailMessage msg = new MailMessage();
                msg.To.Add(registeringEmail);
                msg.From = new MailAddress("waterfallltd@gmail.com");
                msg.Subject = "Confirmation Email";
                msg.Body = "Hi" + " " + registeringUserName + "," + "\r\r" + " You are now a registered member of the Waterfall LTD systems.\r\r This is your username:\r\r  "
                           + registeringUserName + "\r\r This is your Password:\r\r" + " " + registeringPassword + "\r\r This is your skillset:\r\r " + skillSet + 
                           "\r\r Thanks for registering \r\r Regards, \r Darryl Stewart \r Waterfall LTD";
                client1.Send(msg);
                MessageBox.Show("Confirmation Email sent");
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }
    }
}
