package ge.store.veli.WishList;


import ge.store.veli.Pages.LoginPage;
import ge.store.veli.Pages.WishListPage;
import ge.store.veli.BaseTest;
import ge.store.veli.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WishListTest extends BaseTest {

    @Test
    public void addProductWishList() {
        LoginPage loginPage = new LoginPage(driver);
        WishListPage wishListPage = new WishListPage(driver);

        loginPage.login("seturidzegeorge3@gmail.com", "Giviko21");

        wishListPage.addProductsWishList();

        //Check if we transited in wishlist page
        Assert.assertTrue(driver.getCurrentUrl().contains("/wishlist/"));

        // check if product really added in wishlist page
        Assert.assertTrue(wishListPage.isDjiStabilizerVisible() , "Product is not added to wish list page");
        Utils.logPass("Product was successfully added to wish list page");
    }


    }



