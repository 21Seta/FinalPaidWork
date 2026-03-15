package ge.store.veli.Inventory;


import Pages.InventoryPage;
import Pages.LoginPage;
import ge.store.veli.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {

    @Test
    public void searchProduct() {
        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.searchProduct("Bang & Olufsen Beoplay H95 Ferrari Edition Wireless Headphones");

        Assert.assertTrue(driver.getCurrentUrl().contains("bang-olufsen-beoplay-h95-ferrari-edition-over"));

    }

    @Test
    public void validLogOut() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage.login("seturidzegeorge3@gmail.com", "Giviko21");

        inventoryPage.logOut();

        String actualText = inventoryPage.getLoginBtnTextAfterLogOut().trim().toLowerCase();
        Assert.assertTrue(actualText.contains("log") || actualText.contains("შეს"),
                "Logout failed! Actual text: " + actualText);
    }
}