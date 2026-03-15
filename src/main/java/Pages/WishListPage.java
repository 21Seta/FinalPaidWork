package Pages;

import ge.store.veli.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage extends BasePage {

    @FindBy(xpath = "//img[contains(@src,'DJI-ZM700')]")
    WebElement djiStabilizer;

    @FindBy (xpath = "//div[@class='styled__DetailsNav-sc-1arg8l9-2 XOiWC']//span[@class='styles__FlexCenter-sc-1fbw3zu-7 hYgDch desk']")
    WebElement wishListBtn;

    @FindBy(xpath = "//button[contains(@class,'account') and contains(@class,'glass-hover')]")
    WebElement myAccount;

    @FindBy (xpath = "//a[contains(.,'სურვილები') or contains(.,'Wishlist')]")
    WebElement wishesBtn;

    @FindBy (xpath = "//button[@class='remove']")
    WebElement wishesBtnForRemove ;

    @FindBy(xpath = "//*[normalize-space()='Your private list is empty' or contains(normalize-space(), 'დახურულ სიაში პროდუქტები არ გაქვს')]")
    WebElement wishesListEmpty;


    public WishListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String wishListPageIsEmptyText(){
        waitForVisibility(wishesListEmpty);
        return wishesListEmpty.getText();
    }
    public void AddProductsWishList(){

        waitForVisibility(djiStabilizer);
        click(djiStabilizer);
        click(wishListBtn);
        click(myAccount);
        click(wishesBtn);
        waitUrlContains("/wishlist/");
    }
    public void deleteProductsWishList(){
        waitForVisibility(wishesBtnForRemove);
        click(wishesBtnForRemove);
    }
}
