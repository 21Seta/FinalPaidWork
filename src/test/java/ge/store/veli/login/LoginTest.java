package org.example.login;

import Pages.LoginPage;
import org.example.BaseTest;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

@Test
    public void testValidLogin(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("seturidzegeorge3@gmail.com" , "Giviko21"); // Login




}
}
