package ge.store.veli.Pages;

import ge.store.veli.BasePage;
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
    // Method to check if product image is visible in wishlist page
    public boolean isDjiStabilizerVisible() {
        waitForVisibility(djiStabilizerImageCheck);
        return djiStabilizerImageCheck.isDisplayed();
    }

    public void AddProductsWishList(){
        closePopUpIfVisible();
        waitForVisibility(djiStabilizer);
        click(djiStabilizer);
        click(wishListBtn);
        click(myAccount);
        click(wishesBtn);
        waitUrlContains("/wishlist/");
    }
}
