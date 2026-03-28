package ge.store.veli.Voucher;

import ge.store.veli.Pages.HomePage;
import ge.store.veli.Pages.VouchersPage;
import ge.store.veli.BaseTest;
import ge.store.veli.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VouchersTest extends BaseTest {

    @Test
    public void addVouchersInCart(){
        VouchersPage vouchersPage = new VouchersPage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.clickVoucher();

        vouchersPage.addVoucherInCart("seturidzegeorge3@gmail.com");

        // Check if Voucher is added cart drop down menu
        Assert.assertTrue(vouchersPage.ifVoucherAddedCartDropDownMenu().contains("(1)"),
        "The cart is empty , product not added : " + vouchersPage.ifVoucherAddedCartDropDownMenu());
        Utils.logPass("Voucher successfully added in cart drop down menu");

        // Transit CartPage and check if voucher added in cart page
        vouchersPage.openCartPage();
    }
}