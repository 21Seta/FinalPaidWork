package ge.store.veli.Cart;

import Pages.InventoryPage;
import Pages.VouchersPage;
import ge.store.veli.BaseTest;
import org.testng.annotations.Test;

public class VouchersTest extends BaseTest {

    @Test
    public void addProductInCart(){
        VouchersPage cartPage = new VouchersPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.clickVoucher();

        cartPage.addVoucherInCart("seturidzegeorge3@gmail.com");
    }
}
