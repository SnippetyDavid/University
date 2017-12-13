using EasyWpfLoginNavigateExample.ServiceReference;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTestClientApplication
{
    [TestClass]
    class LoginTest
    {
         [TestMethod]
        public void shouldReturnFalse()
        {

            UserServiceClient client = new UserServiceClient();

            client.InsertUserDetails("user", "pass", "email@testemail.com");
            Boolean result = true;
            Assert.AreEqual(client.checkUserDetails("user", "pass"), result);

        }
    }
}
