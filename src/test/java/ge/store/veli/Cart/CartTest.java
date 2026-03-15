package ge.store.veli.Cart;

import Pages.CartPage;
import Pages.HomePage;
import Pages.VouchersPage;
import ge.store.veli.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CartTest extends BaseTest {

    public void checkCartPage() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        VouchersPage vouchersPage = new VouchersPage(driver);


        homePage.clickVoucher();

        vouchersPage.addVoucherInCart("seturidzegeorge3@gmail.com");

        vouchersPage.openCartPage();

        cartPage.checkCartPage();

        Assert.assertTrue(driver.getCurrentUrl().contains("/cart/"));

    }
}