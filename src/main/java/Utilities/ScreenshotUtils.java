package Utilities;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    private static final Logger logger = LogManager.getLogger(ScreenshotUtils.class);

    public static void captureScreenshot(WebDriver driver, String testName) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir");
            File screenshotDir = new File(currentDir, "screenshots");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }
            File destFile = new File(screenshotDir, testName + "_" + System.currentTimeMillis() + ".png");
            FileUtils.copyFile(scrFile, destFile);
            logger.info("Screenshot captured: {}", destFile.getAbsolutePath());
        } catch (IOException e) {
            logger.error("Failed to capture screenshot: {}", e.getMessage());
        }
    }
}
