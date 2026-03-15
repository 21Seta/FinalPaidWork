package Pages;

import ge.store.veli.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VouchersPage extends BasePage {



    @FindBy(xpath = "//a[contains(@class,'product-img-link')]//img[contains(@alt,'500')]")
    WebElement takeVoucher;

    @FindBy(id = "dg-email")
    WebElement voucherEmailField;

    @FindBy(id = "cart-button-z")
    WebElement addToCart;

    @FindBy(xpath = "//span[@class='icon']//span[@class='styles__FlexCenter-sc-1fbw3zu-7 hYgDch'][normalize-space()='1']")
    WebElement openCart;

    @FindBy(id = "cart-button")
    WebElement viewBag;

    @FindBy(xpath = "//a[contains(@class,'cart')]")
    WebElement openCartPage;



    public VouchersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean checkViewBag(){
        return viewBag.isDisplayed();
    }
    public void addVoucherInCart(String email){

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
