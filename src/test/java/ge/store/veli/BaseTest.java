package org.example;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverManager;


public class BaseTest {
    protected WebDriver driver ;

    @BeforeMethod
    public void setup(){
       driver = DriverManager.getDriver();
       driver.manage().window().maximize();
       driver.get("https://veli.store/");
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.quit();
    }

}

