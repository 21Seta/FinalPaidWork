package ge.store.veli.Pages;

import ge.store.veli.BasePage;
import ge.store.veli.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {


    @FindBy(xpath = "//button[contains(@class, 'account')]" )
    WebElement openLoginField;

    @FindBy(id = "sigin-email")
    WebElement emailField ;

    @FindBy(id = "signin-password")
    WebElement passwordField;

    @FindBy(xpath = "//button[@class='styled__AuthPrimaryBtn-mh0716-2 dCwCil']")
    WebElement loginBtn;

    @FindBy(xpath = "//button[contains(@class, 'account') and (contains(., 'ჩემი ველი') or contains(., 'My account'))]")
    WebElement checkIfUserLoggedIn;



    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver , this);
    }

    public String getMyAccountBtnText(){
        return getText(checkIfUserLoggedIn);
    }

    public void login(String email, String password) {
        Utils.logInfo("Starting login");
        closePopUpIfVisible();
        click(openLoginField);
        waitForVisibility(emailField);
        sendKeys(emailField,email ,"email");
        sendKeys(passwordField,password , "password");
        click(loginBtn);

    }
}
