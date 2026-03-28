package ge.store.veli.utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {


        @Override
        public void onTestStart(ITestResult result) {
            System.out.println("Test Started: " + result.getName());
            String testName = result.getMethod().getMethodName();
            ExtentReportManager.createTest(testName);
            ExtentReportManager.getTest().info("Test Started: " + testName);
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            System.out.println("Test Passed: " + result.getName());
            Utils.logPass("Test Passed: " + result.getName());
        }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        WebDriver driver = DriverManager.getDriver();

        String screenshotName = testName + ".png";
        String directory = System.getProperty("user.dir") + "/report/screenshots/";
        String fullPath = directory + screenshotName;

        String relativePath = "screenshots/" + screenshotName;
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            new File(directory).mkdirs();

            FileUtils.copyFile(screenshot, new File(fullPath));

            ExtentReportManager.getTest().fail("Test Failed: " + testName,
                    MediaEntityBuilder.createScreenCaptureFromPath(relativePath).build());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        @Override
        public void onTestSkipped(ITestResult result) {
            ExtentReportManager.getTest().skip("Test Skipped: " + result.getName());
            System.out.println("Test Skipped: " + result.getName());
        }

        @Override
        public void onStart(ITestContext context) {

            System.out.println("Test Suite Started: " + context.getName());
        }

        @Override
        public void onFinish(ITestContext context) {
            System.out.println("Test Suite Finished: " + context.getName());
            ExtentReportManager.flushReports();

        }
}
