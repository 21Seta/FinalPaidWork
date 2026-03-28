package ge.store.veli.Cart;

import ge.store.veli.Pages.CartPage;
import ge.store.veli.Pages.HomePage;
import ge.store.veli.Pages.VouchersPage;
import ge.store.veli.BaseTest;
import ge.store.veli.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;




public class CartTest extends BaseTest {

    @Test
    public void checkCartPage() {
        HomePage homePage = new HomePage(driver);
        VouchersPage vouchersPage = new VouchersPage(driver);

        homePage.clickVoucher();

        vouchersPage.addVoucherInCart("seturidzegeorge3@gmail.com");

        vouchersPage.openCartPage();

        //Assertion to check if voucher is added in cart Page
        Assert.assertTrue(vouchersPage.ifVoucherIsAddedInCartPage().equals("There is 1 item in your cart" ) ||
                                   vouchersPage.ifVoucherIsAddedInCartPage().equals("შენს კალათაში 1 ნივთია"),
                          "Error voucher is not added in cart page. " + "ActualText is: " +  vouchersPage.ifVoucherIsAddedInCartPage() );
        Utils.logPass("Voucher was successfully added cart page");
    }
    @Test
    public void addProductInCart() {
        CartPage cartPage = new CartPage(driver);

        cartPage.addProductInCart();
        
        // Check product price in cart
        assertString(cartPage.checkProductIsAddedInCart() , "449.00 ₾");
        Utils.logPass("Product was successfully added cart page");
    }
    @Test
    public void deleteProductFromCart() {
        CartPage cartPage = new CartPage(driver);

        // Add product in cart before delete
        cartPage.addProductInCart();

        // Delete product from cart
        cartPage.deleteProductFromCart();

        // If empty cart image is visible , product deletion was successful
        Assert.assertTrue(cartPage.checkIfCartIsEmpty() , "Product is not deleted from cart page");
        Utils.logPass("Product was successfully deleted form cart page");




    }
}