package ge.store.veli.Pages;

import ge.store.veli.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VouchersPage extends BasePage {



    @FindBy(xpath = "(//a[contains(@href, 'VOUCHER-0500')])[1]")
    WebElement takeVoucher;

    @FindBy(id = "dg-email")
    WebElement voucherEmailField;

    @FindBy(id = "cart-button-z")
    WebElement addToCart;

    @FindBy(id = "cart-button")
    WebElement openCart;

    @FindBy(xpath = "//a[contains(@class,'cart')]")
    WebElement viewBag;

    @FindBy(xpath = "//a[contains(@class,'cart')]")
    WebElement openCartPage;

    @FindBy(xpath = "//div[contains(@class, 'CartTop')]//h2")
    WebElement IfVoucherIsAddedInCartPage;



    public VouchersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    // Check if Voucher added cart drop down menu
    public String ifVoucherAddedCartDropDownMenu(){
        waitForElementToBeClickable(viewBag);
        return viewBag.getText();
    }
    // Check if voucher is added in cart page
    public String  ifVoucherIsAddedInCartPage(){
        waitForElementToBeClickable(IfVoucherIsAddedInCartPage);
        return IfVoucherIsAddedInCartPage.getText();
    }
    public void addVoucherInCart(String email){
        closePopUpIfVisible();
        waitForElementToBeClickable(takeVoucher);
        click(takeVoucher);
        waitForVisibility(voucherEmailField);
        sendKeys(voucherEmailField , email);
        click(addToCart);
        waitForVisibility(openCart);
        click(openCart);
    }
    public void openCartPage(){
        click(openCartPage);
    }
}
