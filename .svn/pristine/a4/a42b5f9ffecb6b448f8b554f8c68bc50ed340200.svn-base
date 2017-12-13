using LoginNunitTest.ServiceReference2;
using LoginNunitTest.ServiceReference1;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LoginNunitTest
{
    [TestFixture]
    class LoginTest
    {
        //Test to see if user is in the system should return true as this is a valid user
        [Test]
        public void testCheckUserDetails()
        {

            UserServiceClient client = new UserServiceClient();

            Boolean result = client.checkUserDetails("username", "password"); 

            Assert.AreEqual(true, result);

        }

        //Test to see if user is in the system should return false as this isn't a valid user
        [Test]
        public void testCheckUserDetails1()
        {

            UserServiceClient client = new UserServiceClient();

            Boolean result = client.checkUserDetails("Ted", "pass70"); 

            Assert.AreEqual(false, result);

        }
        
    }
}
