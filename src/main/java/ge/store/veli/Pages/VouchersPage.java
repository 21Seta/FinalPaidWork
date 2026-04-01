package ge.store.veli.Pages;

import ge.store.veli.BasePage;
import ge.store.veli.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VouchersPage extends BasePage {



    @FindBy(xpath = "(//a[contains(@href, 'VOUCHER-0500')])[1]")
    WebElement voucher;

    @FindBy(id = "dg-email")
    WebElement emailField;

    @FindBy(id = "cart-button-z")
    WebElement addToCartBtn;

    @FindBy(id = "cart-button")
    WebElement openCartBtn;

    @FindBy(xpath = "//a[contains(@class,'cart')]")
    WebElement viewBagBtn;

    @FindBy(xpath = "//a[contains(@class,'cart')]")
    WebElement openCartPage;

    @FindBy(xpath = "//div[contains(@class, 'CartTop')]//h2")
    WebElement IfVoucherIsAddedInCartPage;



    public VouchersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String ifVoucherAddedCartDropDownMenu(){
        return getText(viewBagBtn);
    }

    public String ifVoucherIsAddedInCartPage(){
        return getText(IfVoucherIsAddedInCartPage);
    }
    public void addVoucherInCart(String email){
        Utils.logInfo("Opening vouchers page");
        closePopUpIfVisible();
        waitForElementToBeClickable(voucher);
        click(voucher);
        waitForVisibility(emailField);
        sendKeys(emailField , email , "email");
        click(addToCartBtn);
        waitForVisibility(openCartBtn);
        click(openCartBtn);
    }
    public void openCartPage(){
        Utils.logInfo("Opening cart page ");
        click(openCartPage);
    }
}
