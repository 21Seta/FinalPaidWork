package ge.store.veli.Pages;

import ge.store.veli.BasePage;
import ge.store.veli.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    @FindBy(xpath = "//img[contains(@alt, 'Osmo Mobile 7')]")
    WebElement djiStabilizer;

    @FindBy(id = "cart-button-z")
    WebElement addToCartBtn;

    @FindBy(id = "cart-button")
    WebElement openCartBtn;

    @FindBy(xpath = "//a[contains(@class,'cart')]")
    WebElement viewBagBtn;

    @FindBy(xpath = "//div[@class='total']/span[2]")
    WebElement productPriceGetText;

    @FindBy(xpath = "//div[@class='end']//button[@class='delete']")
    WebElement deleteBtn;

    @FindBy(xpath = "//button[@class='remove']")
    WebElement deleteImmediatelyBtn;

    @FindBy(xpath = "//img[@alt='empty cart']")
    WebElement emptyBoxImg;



    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getAddedProductPrice(){
        return getText(productPriceGetText);
    }

    public boolean checkIfCartIsEmpty(){
        closePopUpIfVisible();
        return isDisplayed(emptyBoxImg);
    }
    public void addProductInCart(){
        Utils.logInfo("Adding product to cart");
        closePopUpIfVisible();
        waitForVisibility(djiStabilizer);
        click(djiStabilizer);
        click(addToCartBtn);
        click(openCartBtn);
        click(viewBagBtn);
    }
    public void deleteProductFromCart(){
        Utils.logInfo("Deleting product from cart");
        closePopUpIfVisible();
        click(deleteBtn);
        waitForVisibility(deleteImmediatelyBtn);
        click(deleteImmediatelyBtn);
    }
}
