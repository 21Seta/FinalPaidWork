package ge.store.veli.Cart;

import ge.store.veli.Pages.CartPage;
import ge.store.veli.Pages.HomePage;
import ge.store.veli.Pages.VouchersPage;
import ge.store.veli.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;




public class CartTest extends BaseTest {

    @Test
    public void checkCartPage() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        VouchersPage vouchersPage = new VouchersPage(driver);

        homePage.clickVoucher();

        vouchersPage.addVoucherInCart("seturidzegeorge3@gmail.com");

        vouchersPage.openCartPage();

        //Assertion to check if voucher is added in cart Page
        Assert.assertTrue(vouchersPage.ifVoucherIsAddedInCartPage().equals("There is 1 item in your cart" ) ||
                                   vouchersPage.ifVoucherIsAddedInCartPage().equals("შენს კალათაში 1 ნივთია"),
                          "Error voucher is not added in cart page. " + "ActualText is: " +  vouchersPage.ifVoucherIsAddedInCartPage() );


    }
    @Test
    public void addProductInCart() {
        CartPage cartPage = new CartPage(driver);

        cartPage.addProductInCart();

        assertString(cartPage.checkProductIsAddedInCart() , "449.00 ₾");
    }
    @Test
    public void deleteProductFromCart() {
        CartPage cartPage = new CartPage(driver);

        cartPage.addProductInCart();

        cartPage.deleteProductFromCart();

        Assert.assertTrue(cartPage.checkIfCartIsEmpty() , "Product is not deleted from cart page");



    }
}