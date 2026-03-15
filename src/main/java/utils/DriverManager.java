package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver;

    // Start chrome driver (Open browser)
    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }
    // Quit (quit browser)
    public static void  quit(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
