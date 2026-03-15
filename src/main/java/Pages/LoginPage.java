package Pages;

import ge.store.veli.BasePage;
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
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    //Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver , this);
    }
    //
    public boolean isUserLoggedIn(){
        waitForVisibility(openLoginField);
        return openLoginField.isDisplayed();
    }
    //Login
    public void login(String userName, String password) {
        openLoginField.click();
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginBtn.click();
    }
}
