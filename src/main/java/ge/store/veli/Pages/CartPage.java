package ge.store.veli.Pages;

import ge.store.veli.BasePage;
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
    // Check if product is added in cart with product price getText();
    public String checkProductIsAddedInCart(){
        waitForVisibility(productPriceGetText);
        return productPriceGetText.getText();
    }
    // Empty Box image , if its visible product is deleted from cart "Method for assertion"
    public boolean checkIfCartIsEmpty(){
        closePopUpIfVisible();
        waitForVisibility(emptyBoxImg);
        return emptyBoxImg.isDisplayed();
    }
    public void addProductInCart(){
        closePopUpIfVisible();
        waitForVisibility(djiStabilizer);
        click(djiStabilizer);
        click(btnAddToCart);
        click(openCart);
        click(viewBag);
    }
    public void deleteProductFromCart(){
        closePopUpIfVisible();
        click(btnDelete);
        waitForVisibility(btnDeleteImmediately);
        click(btnDeleteImmediately);

    }
}
