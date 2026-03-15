package Pages;

import ge.store.veli.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage {


    @FindBy(xpath = "//button[contains(@class, 'account')]")
    WebElement myAccount;

    @FindBy(xpath = "//form[contains(@class, 'SearchForm')]//input")
    WebElement searchField;

    @FindBy(xpath = "//div[contains(text(), 'H95 Ferrari Edition')]")
    WebElement takeProduct;

    @FindBy(xpath = "//div[contains(@class, 'swiper-slide-active')]//a")
    WebElement vouchers;

    @FindBy(xpath = "//button[contains(text(),'გამოსვლა') or contains(text(),'Log out')]")
    WebElement logoutBtn;

    @FindBy(xpath = "//button[contains(text(), 'დიახ') or contains(text(), 'Confirm')]")
    WebElement confirmBtn;

    @FindBy(xpath = "//button[contains(@class, 'account') and (contains(., 'Log in') or contains(., 'შესვლა'))]")
    WebElement loginBtnAfterLogOut;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    // Method to Check Login Button text For assertion in inventory Page.
    public String getLoginBtnTextAfterLogOut() {
        waitForVisibility(loginBtnAfterLogOut);
        return loginBtnAfterLogOut.getText();
    }

    public void searchProduct(String productName) {

        click(searchField);
        waitForVisibility(searchField);
        searchField.clear();
        searchField.sendKeys(productName);
        click(takeProduct);
        waitUrlContains("bang-olufsen-beoplay-h95-ferrari-edition-over");

    }

    public void clickVoucher() {
        click(vouchers);
    }

    public void logOut() {
        click(myAccount);
        click(logoutBtn);
        waitForVisibility(confirmBtn);
        click(confirmBtn);
    }


}