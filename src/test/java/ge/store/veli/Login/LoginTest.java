package ge.store.veli.Login;


import ge.store.veli.Pages.LoginPage;
import ge.store.veli.BaseTest;
import ge.store.veli.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;




public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(ConfigReader.get("ui.user.email"), ConfigReader.get("ui.user.password"));

        Assert.assertTrue(loginPage.getMyAccountBtnText().equals("Ჩემი Ველი") ||
                                   loginPage.getMyAccountBtnText().equals("My Account"),
                "Error: Login failed! Actual button text is: " + loginPage.getMyAccountBtnText());
    }

}

