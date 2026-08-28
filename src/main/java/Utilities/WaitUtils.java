package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class WaitUtils {

    public static long pageLoadTimeout = 20; // Default page load timeout in seconds    
    public static long implicitWaitTime = 10; // Default implicit wait time in seconds

        // Explicit wait for element visibility
    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(implicitWaitTime));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    
  

	
}

