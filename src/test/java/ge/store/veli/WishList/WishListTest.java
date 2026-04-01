package ge.store.veli.WishList;


import ge.store.veli.Pages.LoginPage;
import ge.store.veli.Pages.WishListPage;
import ge.store.veli.BaseTest;
import ge.store.veli.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WishListTest extends BaseTest {

    @Test
    public void addProductToWishListPage() {
        LoginPage loginPage = new LoginPage(driver);
        WishListPage wishListPage = new WishListPage(driver);

        loginPage.login(ConfigReader.get("ui.user.email"), ConfigReader.get("ui.user.password"));

        wishListPage.addProductsWishList();

        Assert.assertTrue(driver.getCurrentUrl().contains("/wishlist/"));

        Assert.assertTrue(wishListPage.isDjiStabilizerVisibleOnWishList() , "Product is not added to wish list page");
    }


    }



