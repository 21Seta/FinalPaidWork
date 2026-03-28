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
    WebElement btnAddToCart;

    @FindBy(id = "cart-button")
    WebElement openCart;

    @FindBy(xpath = "//a[contains(@class,'cart')]")
    WebElement viewBag;

    @FindBy(xpath = "//div[@class='total']/span[2]")
    WebElement productPriceGetText;

    @FindBy(xpath = "//div[@class='end']//button[@class='delete']")
    WebElement btnDelete;

    @FindBy(xpath = "//button[@class='remove']")
    WebElement btnDeleteImmediately;

    @FindBy(xpath = "//img[@alt='empty cart']")
    WebElement emptyBoxImg;



    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    // Returns added product price from cart page
    public String checkProductIsAddedInCart(){
        return getText(productPriceGetText);
    }
    // Return Empty Box image , if its visible product is deleted
    public boolean checkIfCartIsEmpty(){
        closePopUpIfVisible();
        return isDisplayed(emptyBoxImg);
    }
    public void addProductInCart(){
        Utils.logInfo("Add product in cart page");
        closePopUpIfVisible();
        waitForVisibility(djiStabilizer);
        click(djiStabilizer);
        click(btnAddToCart);
        click(openCart);
        click(viewBag);
    }
    public void deleteProductFromCart(){
        Utils.logInfo("Deleting product from cart page");
        closePopUpIfVisible();
        click(btnDelete);
        waitForVisibility(btnDeleteImmediately);
        click(btnDeleteImmediately);
    }
}
