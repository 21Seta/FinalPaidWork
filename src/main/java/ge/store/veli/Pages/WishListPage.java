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
    WebElement addToWishListBtn;

    @FindBy(xpath = "//button[contains(@class, 'account')]")
    WebElement myAccountBtn;

    @FindBy (xpath = "//a[contains(.,'სურვილები') or contains(.,'Wishlist')]")
    WebElement openWishListPage;

    @FindBy(xpath = "//div[@class='hero']")
    WebElement djiStabilizerImageCheck;


    public WishListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isDjiStabilizerVisible() {
        return isDisplayed(djiStabilizerImageCheck);
    }

    public void addProductsWishList(){
        Utils.logInfo("Adding product to wish list");
        closePopUpIfVisible();
        waitForVisibility(djiStabilizer);
        click(djiStabilizer);
        click(addToWishListBtn);
        click(myAccountBtn);
        click(openWishListPage);
        waitUrlContains("/wishlist/");
    }
}
