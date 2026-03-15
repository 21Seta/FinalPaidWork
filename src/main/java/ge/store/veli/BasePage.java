package ge.store.veli;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.time.Duration;


public class BasePage {
    protected WebDriver driver ;
    protected WebDriverWait wait ;


    public BasePage (WebDriver driver){
        this.driver = driver ;
        this.wait = new WebDriverWait(driver , Duration.ofSeconds(ConfigReader.getLong("wait")));
        PageFactory.initElements(driver , this);
    }
    // getText
    public String getText(WebElement locator){
        waitForVisibility(locator);
        return locator.getText();
    }
    // Click
    public void click (WebElement locator){
        waitForElementToBeClickable(locator);
        locator.click();
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
    //Refresh
    public void refreshPage(){
        driver.navigate().refresh();
    }

    public void sendKeys (WebElement locator , String text){
        waitForVisibility(locator);
        locator.sendKeys(text);
    }
}


