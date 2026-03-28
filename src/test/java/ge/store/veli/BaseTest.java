package ge.store.veli;

import ge.store.veli.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ge.store.veli.utils.ConfigReader;
import ge.store.veli.utils.DriverManager;


public class BaseTest {
    protected WebDriver driver ;

    /**
     * ხსნის ბრაუზერს დაგადადის base URL-ზე ყოველი ტესტის წინ
     */
    @BeforeMethod
    public void setup(){
       driver = DriverManager.getDriver();
       driver.manage().window().maximize();
       driver.get(ConfigReader.get("base.url"));
       Utils.logInfo("URL: " + ConfigReader.get("base.url"));
    }

    /**
     * ხურავს ბრაუზერს ყოველი ტესტის შემდგომ
     */
    @AfterMethod
    public void tearDown(){
        DriverManager.quit();
    }

    /**
     * ადარებს actual და expected მნიშვნელობებს
     * @param act ახლანდელი მნიშვნელობა
     * @param exp მოსალოდნელიმნიშვნელობა
     */
    public void assertString(String act , String exp){
        Assert.assertEquals(act , exp , "isn't same");
        Utils.logInfo("+ASSERTION+ :  act is : " + act + " and exp is : " + exp);
        Utils.logPass("Assertion passed successfully");


    }
}

