package ge.store.veli.Cart;

import ge.store.veli.Pages.CartPage;
import ge.store.veli.Pages.HomePage;
import ge.store.veli.Pages.VouchersPage;
import ge.store.veli.BaseTest;
import ge.store.veli.utils.ConfigReader;
import ge.store.veli.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CartTest extends BaseTest {

    @Test
    public void addVoucherToCartPage() {
        HomePage homePage = new HomePage(driver);
        VouchersPage vouchersPage = new VouchersPage(driver);

        homePage.clickVoucher();

        vouchersPage.addVoucherInCart(ConfigReader.get("ui.user.email"));

        vouchersPage.openCartPage();

        Assert.assertTrue(vouchersPage.ifVoucherIsAddedInCartPage().equals("There is 1 item in your cart" ) ||
                                   vouchersPage.ifVoucherIsAddedInCartPage().equals("შენს კალათაში 1 ნივთია"),
                          "Error voucher is not added in cart page." +  vouchersPage.ifVoucherIsAddedInCartPage() );
        Utils.logPass("Voucher was successfully added cart page");
    }
    @Test
    public void addProductInCart() {
        CartPage cartPage = new CartPage(driver);

        cartPage.addProductInCart();

        assertString(cartPage.getAddedProductPrice() , "449.00 ₾");
    }
    @Test
    public void deleteProductFromCart() {
        CartPage cartPage = new CartPage(driver);

        cartPage.addProductInCart();

        cartPage.deleteProductFromCart();

        Assert.assertTrue(cartPage.checkIfCartIsEmpty() , "Product is not deleted from cart page");
    }
}