package ge.store.veli.Pages;

import ge.store.veli.BasePage;
import ge.store.veli.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage {


    @FindBy(xpath = "//button[contains(@class,'account') and contains(@class,'glass-hover')]")
    WebElement myAccountBtn;

    @FindBy(xpath = "//form[contains(@class, 'SearchForm')]//input")
    WebElement searchField;

    @FindBy(xpath = "//div[contains(text(), 'H95 Ferrari Edition')]")
    WebElement takeProduct;

    @FindBy(xpath = "//div[contains(@class, 'swiper-slide-active')]//a")
    WebElement vouchers;

    @FindBy(xpath = "//button[@class='logout']")
    WebElement logoutBtn;

    @FindBy(xpath = "//button[@class='accept']")
    WebElement confirmBtn;

    @FindBy(xpath = "//button[contains(@class, 'account') and (contains(., 'Log in') or contains(., 'შესვლა'))]")
    WebElement loginBtnAfterLogOut;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public String getLoginBtnTextAfterLogOut() {
        return getText(loginBtnAfterLogOut);
    }

    public void searchProduct(String productName) {
        Utils.logInfo("searching product: " + productName);
        closePopUpIfVisible();
        click(searchField);
        waitForVisibility(searchField);
        clear(searchField);
        sendKeys(searchField, productName , "product name");
        click(takeProduct);
        waitUrlContains("bang-olufsen-beoplay-h95-ferrari-edition-over");

    }


    public void clickVoucher() {
        click(vouchers);
    }

    public void logOut() {
        Utils.logInfo("Starting logout");
        closePopUpIfVisible();
        click(myAccountBtn);
        waitForVisibility(logoutBtn);
        click(logoutBtn);
        waitForVisibility(confirmBtn);
        click(confirmBtn);
    }

}