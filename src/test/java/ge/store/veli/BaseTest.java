package ge.store.veli;

import ge.store.veli.utils.Utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ge.store.veli.utils.ConfigReader;
import ge.store.veli.utils.DriverManager;

import java.io.File;
import java.io.IOException;


public class BaseTest {
    protected WebDriver driver ;

    @BeforeMethod
    public void setup(){
       driver = DriverManager.getDriver();
       driver.manage().window().maximize();
       driver.get(ConfigReader.get("base.url"));
       Utils.logInfo("URL: " + ConfigReader.get("base.url"));
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.quit();
    }

    public void assertString(String act , String exp){
        Assert.assertEquals(act , exp , "isn't same");
        Utils.logInfo("+ASSERTION+ :  act : " + act + " and exp : " + exp);
    }

    }



