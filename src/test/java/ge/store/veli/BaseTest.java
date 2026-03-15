package ge.store.veli;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverManager;


public class BaseTest {
    protected WebDriver driver ;

    @BeforeMethod
    public void setup(){
       driver = DriverManager.getDriver();
       driver.manage().window().maximize();
       driver.get(ConfigReader.get("base.url"));
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.quit();
    }

    public void assertString(String act , String exp){
        Assert.assertEquals(act , exp , "isn't same");
    }

    }


