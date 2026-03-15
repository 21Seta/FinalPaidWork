package ge.store.veli.Inventory;


import Pages.HomePage;
import Pages.LoginPage;
import ge.store.veli.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test
    public void searchProduct() {
        HomePage homePage = new HomePage(driver);

        homePage.searchProduct("Bang & Olufsen Beoplay H95 Ferrari Edition Wireless Headphones");

        Assert.assertTrue(driver.getCurrentUrl().contains("bang-olufsen-beoplay-h95-ferrari-edition-over"));

    }

    @Test
    public void validLogOut() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("seturidzegeorge3@gmail.com", "Giviko21");

        homePage.logOut();

        String actualText = homePage.getLoginBtnTextAfterLogOut().trim().toLowerCase();
        Assert.assertTrue(actualText.contains("log") || actualText.contains("შეს"),
                "Logout failed! Actual text: " + actualText);
    }
}