package ge.store.veli.utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();// ThreadLocal for parallel execution

    // Initialize ExtentReports
    public static ExtentReports getExtentReports() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/report/ExtentReport.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setReportName("Automation Test Report");
            sparkReporter.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Environment",ConfigReader.get("Environment"));
            extent.setSystemInfo("Tester", ConfigReader.get("Tester"));
        }
        return extent;
    }

    // Create a test
    public static ExtentTest createTest(String testName) {
        ExtentTest extentTest = getExtentReports().createTest(testName);
        test.set(extentTest);
        return extentTest;
    }

    // Get the current test
    public static ExtentTest getTest() {
        return test.get();
    }

    // Flush reports
    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}

