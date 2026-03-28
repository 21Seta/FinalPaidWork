package ge.store.veli.Pages;

import ge.store.veli.BasePage;
import ge.store.veli.utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class WishListPage extends BasePage {

    @FindBy(xpath = "//img[contains(@alt, 'Osmo Mobile 7')]")
    WebElement djiStabilizer;

    @FindBy (xpath = "//button[contains(@class, 'wishlist')]")
    WebElement wishListBtn;

    @FindBy(xpath = "//button[contains(@class, 'account')]")
    WebElement myAccount;

    @FindBy (xpath = "//a[contains(.,'სურვილები') or contains(.,'Wishlist')]")
    WebElement wishesBtn;

    @FindBy(xpath = "//div[@class='hero']")
    WebElement djiStabilizerImageCheck;


    public WishListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    // Checks if selected product is displayed on wishlist page
    public boolean isDjiStabilizerVisible() {
        return isDisplayed(djiStabilizerImageCheck);
    }

    public void addProductsWishList(){
        Utils.logInfo("Adding products wish list page");
        closePopUpIfVisible();
        waitForVisibility(djiStabilizer);
        click(djiStabilizer);
        click(wishListBtn);
        click(myAccount);
        click(wishesBtn);
        waitUrlContains("/wishlist/");
    }
}
