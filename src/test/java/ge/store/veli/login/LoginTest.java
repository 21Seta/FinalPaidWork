package ge.store.veli.login;


import ge.store.veli.Pages.LoginPage;
import ge.store.veli.BaseTest;
import ge.store.veli.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;




public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {

        LoginPage loginPage = new LoginPage(driver);


        loginPage.login("seturidzegeorge3@gmail.com", "Giviko21");

        Assert.assertTrue(loginPage.isUserLoggedIn().equals("Ჩემი Ველი") ||
                                   loginPage.isUserLoggedIn().equals("My Account"),
                "Error: Login failed! Actual button text is: " + loginPage.isUserLoggedIn());
        Utils.logPass("User login passed successfully");
    }

}

