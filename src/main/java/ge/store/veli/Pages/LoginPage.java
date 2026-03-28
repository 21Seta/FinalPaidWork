package ge.store.veli.Pages;

import ge.store.veli.BasePage;
import ge.store.veli.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    // Elements
    @FindBy(xpath = "//button[contains(@class, 'account')]" )
    WebElement openLoginField;

    @FindBy(id = "sigin-email")
    WebElement userNameField ;

    @FindBy(id = "signin-password")
    WebElement passwordField;

    @FindBy(xpath = "//button[@class='styled__AuthPrimaryBtn-mh0716-2 dCwCil']")
    WebElement loginBtn;

    @FindBy(xpath = "//button[contains(@class, 'account') and (contains(., 'ჩემი ველი') or contains(., 'My account'))]")
    WebElement checkIsUserLoggedIn;


    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver , this);
    }
    // Returns account button text to verify successfull login
    public String isUserLoggedIn(){
        return getText(checkIsUserLoggedIn);
    }
    // Login
    public void login(String userName, String password) {
        Utils.logInfo("Start login " + userName);
        closePopUpIfVisible();
        click(openLoginField);
        waitForVisibility(userNameField);
        sendKeys(userNameField,userName);
        sendKeys(passwordField,password);
        click(loginBtn);

    }
}
