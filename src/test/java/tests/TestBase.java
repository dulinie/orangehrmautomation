package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Utilities.ScreenshotUtils;
import base.BaseTest;


public class TestBase extends BaseTest {


    private static final Logger logger = LogManager.getLogger(TestBase.class);

      public TestBase() {
        super();
    }


     @BeforeMethod
    public void setUp() {
        initialize(); // Call the initialization method to set up the WebDriver and open the browser
        logger.info("Test setup complete - WebDriver initialized");
      
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
    if (result.getStatus() == ITestResult.FAILURE) {
        ScreenshotUtils.captureScreenshot(driver, result.getName());
    }
    if (driver != null) {
        driver.quit();
    }



    }
}
