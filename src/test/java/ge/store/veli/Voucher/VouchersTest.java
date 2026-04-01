package ge.store.veli.Voucher;

import ge.store.veli.Pages.HomePage;
import ge.store.veli.Pages.VouchersPage;
import ge.store.veli.BaseTest;
import ge.store.veli.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VouchersTest extends BaseTest {

    @Test
    public void addVoucherInCart(){
        VouchersPage vouchersPage = new VouchersPage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.clickVoucher();

        vouchersPage.addVoucherInCart(ConfigReader.get("ui.user.email"));

        Assert.assertTrue(vouchersPage.ifVoucherAddedCartDropDownMenu().contains("(1)"),
        "The cart dropdown is empty , product not added : " + vouchersPage.ifVoucherAddedCartDropDownMenu());

        vouchersPage.openCartPage();
    }
}