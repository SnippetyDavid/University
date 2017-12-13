using LoginNunitTest.ServiceReference2;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LoginNunitTest
{
     [TestFixture]
    class RegisterTest
    {
        //Test that a user is being inserted into the DB. Should return true as this will be a new user
       [Test]
        public void testInsertUserDetails()
        {

            UserServiceClient client = new UserServiceClient();

            //Change the user name of the user everytime this test is run otherwise the test will fail
            Boolean result = client.InsertUserDetails("Lisa Simpson", "Springfield123", "homer@springfieldnucularplant.com");

            Assert.AreEqual(true, result);

        }

        //Test that a user is being inserted into the DB. Should return false as this is already a registered user
       [Test]
        public void testInsertUserDetails1()
        {

            UserServiceClient client = new UserServiceClient();

            Boolean result = client.InsertUserDetails("username", "password", "email@example.com");

            Assert.AreEqual(false, result);

        }
    }
}
