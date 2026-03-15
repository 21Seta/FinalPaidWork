package ge.store.veli.WishList;

import Pages.LoginPage;
import Pages.WishListPage;
import ge.store.veli.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;



public class WishListTest extends BaseTest {

    @Test
    public void addProductWishList() {
        LoginPage loginPage = new LoginPage(driver);
        WishListPage wishListPage = new WishListPage(driver);

        loginPage.login("seturidzegeorge3@gmail.com" , "Giviko21");

        wishListPage.AddProductsWishList();


        Assert.assertTrue(driver.getCurrentUrl().contains("/wishlist/"));

    }
    @Test
    public void deleteProductWishList() {
        LoginPage loginPage = new LoginPage(driver);
        WishListPage wishListPage = new WishListPage(driver);
        loginPage.login("seturidzegeorge3@gmail.com" , "Giviko21");
        wishListPage.AddProductsWishList();
        wishListPage.deleteProductsWishList();

        //Check
        String actualText = wishListPage.wishListPageIsEmptyText().trim().toLowerCase();

        Assert.assertTrue(actualText.contains("empty") || actualText.contains("არ გაქვს"),
                "Logout failed! Actual text: " + actualText);
    }
}