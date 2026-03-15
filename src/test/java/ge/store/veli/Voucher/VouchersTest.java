package ge.store.veli.Voucher;

import Pages.HomePage;
import Pages.VouchersPage;
import ge.store.veli.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VouchersTest extends BaseTest {

    @Test
    public void addVouchersInCart(){
        VouchersPage vouchersPage = new VouchersPage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.clickVoucher();
        vouchersPage.addVoucherInCart("seturidzegeorge3@gmail.com");

        Assert.assertTrue(vouchersPage.checkViewBag().contains("(1)"),
                "The cart is empty , product not added : " + vouchersPage.checkViewBag());

        vouchersPage.openCartPage();
    }
}