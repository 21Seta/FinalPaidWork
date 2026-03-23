package ge.store.veli;


import ge.store.veli.utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ge.store.veli.utils.ConfigReader;

import java.time.Duration;


public class BasePage {
    protected static WebDriver driver ;
    protected WebDriverWait wait ;


    public BasePage (WebDriver driver){
        this.driver = driver ;
        this.wait = new WebDriverWait(driver , Duration.ofSeconds(ConfigReader.getLong("wait")));
        PageFactory.initElements(driver , this);
    }
    // getText
    public String getText(WebElement locator){
        waitForVisibility(locator);
        Utils.logInfo("get text from : " + locator.getText());
        return locator.getText();

    }
    // Click
    public void click(WebElement locator) {
        waitForElementToBeClickable(locator); // 1. ჯერ დავიცადოთ

        // 2. ავიღოთ ტექსტი, სანამ ელემენტი "ცოცხალია"
        String text = locator.getText();
        if (text == null || text.isEmpty()) {
            text = locator.getAttribute("textContent");
        }

        locator.click(); // 3. დავაკლიკოთ

        // 4. გავაგზავნოთ რეპორტში
        Utils.logInfo("Clicked on element: " + text);
    }
    // Wait For Visible
    public void waitForVisibility(WebElement locator) {
       wait.until(ExpectedConditions.visibilityOf(locator));

    }
    //Wait For Element To Be Clickable
    public void waitForElementToBeClickable(WebElement locator){
       wait.until(ExpectedConditions.elementToBeClickable(locator));

    }
    // Wait For Url
    public void waitForUrlToBe(String urlPart){
        wait.until(ExpectedConditions.urlContains(urlPart));

    }
    // Wait Url Contains
    public void waitUrlContains(String url){
        wait.until(ExpectedConditions.urlContains(url));

    }
    // Wait For Element to disappear
    public void waitForElementToDisappear(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));

    }
    //Clear
    public void clear (WebElement locator){
        waitForVisibility(locator);
        locator.clear();

    }
    public void sendKeys (WebElement locator , String text){
        waitForVisibility(locator);
        locator.sendKeys(text);
        Utils.logInfo("send key was: " + text);
    }
    // Method to close Black Friday pop up
    public void closePopUpIfVisible() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement iframe = shortWait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//iframe[@data-test-id='interactive-frame']")));

            driver.switchTo().frame(iframe);

            WebElement closeBtn = driver.findElement(By.id("interactive-close-button"));
            closeBtn.click();

            System.out.println("Pop-up closed successfully.");
        } catch (Exception e) {

        } finally {
            driver.switchTo().defaultContent();
        }
    }
        }








