package ge.store.veli.utils;

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
     * ამატებს წარუმატებლობის მესიჯს extent report-ში
     *
     * @param message წარუმატებლლობის მოკლე აღწერა
     */
    public static void logFailed(String message) {
        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().fail(message);
        }
    }
}
