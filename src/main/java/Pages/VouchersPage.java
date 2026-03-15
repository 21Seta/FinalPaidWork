package Pages;

import ge.store.veli.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class='swiper-slide swiper-slide-active']//a[@class='category']")
    WebElement vouchers;

    @FindBy(xpath = "//a[contains(@class,'product-img-link')]//img[contains(@alt,'500')]")
    WebElement takeVoucher;

    @FindBy(xpath = "//div[@class='styles__ContainerBlock-sc-1fbw3zu-4 styled__CategoryWrapper-sc-183mmht-1 fgxCpI cYcolT']//div[1]//div[2]//div[1]//button[1]//*[name()='svg']//*[name()='path' and contains(@d,'M3.95153 1')]")
    WebElement addToCartBtn;

    @FindBy(xpath = "//div[@class='actions']//span[1]")
    WebElement addToCart;

    @FindBy(xpath = "//span[@class='icon']//span[@class='styles__FlexCenter-sc-1fbw3zu-7 hYgDch'][normalize-space()='1']")
    WebElement openCart;


    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addVoucherInCart(String voucher){
        click(vouchers);
        click(takeVoucher);
        click(addToCartBtn);
        click(addToCart);
        waitForElementToBeClickable(openCart);

    }
}
