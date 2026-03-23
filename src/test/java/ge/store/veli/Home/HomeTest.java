package ge.store.veli.Home;


import ge.store.veli.Pages.HomePage;
import ge.store.veli.Pages.LoginPage;
import ge.store.veli.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test
    public void searchProduct() {
        HomePage homePage = new HomePage(driver);

        homePage.searchProduct("Bang & Olufsen Beoplay H95 Ferrari Edition Wireless Headphones");

        Assert.assertTrue(driver.getCurrentUrl().contains("bang-olufsen-beoplay-h95-ferrari-edition-over"),
        "Error : Product is not searched");

    }

    @Test
    public void validLogOut() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("seturidzegeorge3@gmail.com", "Giviko21");

        homePage.logOut();

        Assert.assertTrue(homePage.getLoginBtnTextAfterLogOut().equals("Შესვლა") ||
                                   homePage.getLoginBtnTextAfterLogOut().equals("Log In"),
                "Error: Login failed! Actual text: " + homePage.getLoginBtnTextAfterLogOut());
    }
}