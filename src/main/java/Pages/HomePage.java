package Pages;

import ge.store.veli.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class InventoryPage extends BasePage {


    @FindBy(xpath = "//button[contains(@class,'account') and contains(@class,'glass-hover')]")
    WebElement myAccount;

    @FindBy(xpath = "//input[contains(@placeholder,'ეძებ') or contains(@placeholder,'Search')]")
    WebElement searchField;

    @FindBy(xpath = "//button[@class='link']//div[@class='title'][contains(text(),'Bang & Olufsen Beoplay H95 Ferrari Edition Over-Ea')]")
    WebElement takeProduct;

    @FindBy(xpath = "//div[@class='swiper-slide swiper-slide-active']//a[@class='category']")
    WebElement vouchers;

    @FindBy(xpath = "//button[contains(text(),'გამოსვლა') or contains(text(),'Log out')]")
    WebElement logoutBtn;

    @FindBy(xpath = "//button[contains(text(), 'დიახ') or contains(text(), 'Confirm')]")
    WebElement confirmBtn;

    @FindBy(xpath = "//button[contains(@class, 'account') and (contains(., 'Log in') or contains(., 'შესვლა'))]")
    WebElement loginBtnAfterLogOut;

    public InventoryPage(WebDriver driver) {
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