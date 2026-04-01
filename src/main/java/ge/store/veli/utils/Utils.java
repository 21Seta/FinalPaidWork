package ge.store.veli.utils;


import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;


public class Utils {
    /**
     * ამატებს საინფორმაციო მესიჯს Extent report-ში
     *
     * @param message ინფორმაცია რომელიც რეპორტში უნდა გამოჩნდეს
     */
    public static void logInfo(String message) {
        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().info(message);
        }
    }

    /**
     * ამატებს წარმატების მესიჯს extent report-ში
     *
     * @param message წარმატებული ნაბიჯის მოკლე აღწერა
     */
    public static void logPass(String message) {
        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().pass(message);
        }
    }
    /**
     * ამატებს წარმატებლობის მესიჯს და scree
     *
     * @param message წარუმატებლობის მოკლე აღწერა
     * @param driver მიმდინარე WebDriver
     */
    public static void logFailed(String message , WebDriver driver , String testName) {
        if  (ExtentReportManager.getTest() != null) {

            String screenShotName = testName + ".png";
            String directory =  System.getProperty("user.dir") + "/report/screenshots/";
            String fullPath = directory + screenShotName;
            String relativePath = "screenshots/" + screenShotName;

            try {
                File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

                new File(directory).mkdirs();
                FileUtils.copyFile(screenShot, new File(fullPath));

                ExtentReportManager.getTest().fail(message);
                ExtentReportManager.getTest().addScreenCaptureFromPath(relativePath);
            } catch (Exception e) {
                ExtentReportManager.getTest().fail(message);
            }
        }
    }
}
