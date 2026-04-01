package ge.store.veli.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

    /**
     * იქმნება ახალი ტესტი report-ში ტესტის დაწყებისას
     * @param result მიმდინარე ტესტის შედეგი
     */
    @Override
        public void onTestStart(ITestResult result) {
            System.out.println("Test Started: " + result.getName());
            String testName = result.getMethod().getMethodName();
            ExtentReportManager.createTest(testName);
            ExtentReportManager.getTest().info("Test Started: " + testName);
        }

    /**
     * ამატებს წარმატების მესიჯს report-ში ტესტის წარამატებით დასრულებისას
     * @param result მიმდინარე ტესტის შედეგი
     */
        @Override
        public void onTestSuccess(ITestResult result) {
            System.out.println("Test Passed: " + result.getName());
            Utils.logPass("Test Passed: " + result.getName());
        }

    /**
     * ამატებს წარუმატებლობის მესიჯს და იღებს screenshot-ს
     * @param result მიმდინარე ტესტის შედეგი
     */
    @Override
        public void onTestFailure(ITestResult result) {
            String testName = result.getName();
            WebDriver driver = DriverManager.getDriver();
            Utils.logFailed("Test Failed: " + testName , driver , testName);

        }

    /**
     *  ამატებს skip მესიჯს report-ში , თუ ტესტი გამოტოვვებულია
     * @param result მიმდინარე ტესტის შედეგი
     */
        @Override
        public void onTestSkipped(ITestResult result) {
            ExtentReportManager.getTest().skip("Test Skipped: " + result.getName());
            System.out.println("Test Skipped: " + result.getName());
        }

    /**
     * იძახება ტესტბის suite -ის დაწყებისას
     * @param context
     */
        @Override
        public void onStart(ITestContext context) {
            System.out.println("Test Suite Started: " + context.getName());
        }

    /**
     * იძახება suite-ის დასრულებისას და ინახავს საბოლოო report-ს
     * @param context მიმდინარე ტესტის შედეგი
     */
        @Override
        public void onFinish(ITestContext context) {
            System.out.println("Test Suite Finished: " + context.getName());
            ExtentReportManager.flushReports();

        }
}
