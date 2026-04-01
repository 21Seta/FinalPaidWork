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

    /**
     * აბრუნებს ხილული ელემენტის ტექსტს
     * @param locator ელემენტი საიდანაც ვიღებთ ტექსტს
     * @return ელემენტის ტექსტი
     */
    public String getText(WebElement locator){
        waitForVisibility(locator);
        return locator.getText();
    }

    /**
     * ამოწმებს ელემენტი ჩანს თუ არა
     * @param locator სამიზნე ელემენტი
     * @return True თუ ელემენტი ჩანს
     */
    public boolean isDisplayed(WebElement locator){
        waitForVisibility(locator);
        boolean isVisible = locator.isDisplayed();
        return isVisible;
    }

    /**
     * ელოდება ელემენტის დაკლიკებადობას და აკლიკებს მას
     * @param locator სამიზნე ელემენტი
     */
    public void click(WebElement locator) {
        waitForElementToBeClickable(locator);

        String text = locator.getText();
        if (text == null || text.isEmpty()) {
            text = locator.getAttribute("textContent");
        }
        if (text == null || text.isEmpty()) {
            text = locator.getAttribute("alt");
        }
        if (text == null || text.isEmpty()) {
            text = locator.getAttribute("title");
        }
        if (text == null || text.isEmpty()) {
            text = "element without visible text";
        }
        locator.click();

        Utils.logInfo("Clicked on element: " + text);
    }

    /**
     * ელოდება სანამ ელემენტი ხილული გახდება
     * @param locator სამიზნე ელემენტი
     */
    public void waitForVisibility(WebElement locator) {
       wait.until(ExpectedConditions.visibilityOf(locator));

    }

    /**
     * ელოდება სანამ ელემენტი დაკლიკებადი გახდება
     * @param locator სამიზნე ელემენტი
     */
    public void waitForElementToBeClickable(WebElement locator){
       wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    /**
     * ელოდება სანამ მიმდინარე URL მითითებულ ტექსტს შეიცავს
     * @param url URL -ის მოსალოდნელი ნაწილი
     */
    public void waitUrlContains(String url){
        wait.until(ExpectedConditions.urlContains(url));

    }

    /**
     * ასუფთავებს input ველს
     * @param locator სამინზე ელემენტი
     */
    public void clear (WebElement locator){
        waitForVisibility(locator);
        locator.clear();

    }

    /**
     * წერს ტექსტს input ველში
     * @param locator სამინზე ელემენტი
     * @param text ველში შესაყვანი ტექსტი
     */
    public void sendKeys (WebElement locator , String text , String fieldName){
        waitForVisibility(locator);
        locator.sendKeys(text);
        Utils.logInfo(fieldName + ": " + text);
    }

    /**
     * ხურავს popup-ს თუ ის გვერდზე გამოჩნდა
     * მეთოდი ჯერ popup iframe-ს ეძებს , შემდეგ გადადის მასში
     * და აკლიკებს დახურვის ღილაკს
     */
    public void closePopUpIfVisible() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement iframe = shortWait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//iframe[@data-test-id='interactive-frame']")));

            driver.switchTo().frame(iframe);

            WebElement closeBtn = driver.findElement(By.id("interactive-close-button"));
            closeBtn.click();

        } catch (Exception e) {

        } finally {
            driver.switchTo().defaultContent();
        }
    }
}








