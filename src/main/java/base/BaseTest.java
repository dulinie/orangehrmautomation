package base;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.edge.EdgeDriver;


import Utilities.WaitUtils;
import Utilities.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class BaseTest {
    public static WebDriver driver;
    public static Properties prop;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

   
    public BaseTest() {
        // Initialize WebDriver and other setup here
        prop = new Properties();
    try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
        if (input == null) {
            logger.error("config.properties not found on classpath");
            return;
        }
        prop.load(input);
        logger.debug("Configuration properties loaded successfully");
    } catch (IOException e) {
        logger.error("Error loading config.properties: {}", e.getMessage());
    }
        }

public static void initialize() {
    // Initialize WebDriver based on properties
    String browser = prop.getProperty("browser");
     logger.info("Initializing WebDriver for browser: {}", browser);
    if (browser.equalsIgnoreCase("chrome")) {
        logger.debug("Setting up ChromeDriver via WebDriverManager");
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    } 
     else if (browser.equalsIgnoreCase("firefox")) {
          logger.debug("Setting up FirefoxDriver via WebDriverManager");
         // Set up FirefoxDriver using WebDriverManager
       WebDriverManager.firefoxdriver().setup();
         driver = new FirefoxDriver();
     }
     else if (browser.equalsIgnoreCase("edge")) {
         logger.debug("Setting up EdgeDriver via WebDriverManager");
         // Set up EdgeDriver using WebDriverManager
        WebDriverManager.edgedriver().setup();
         driver = new EdgeDriver();
     }
     else {
        logger.error("Unsupported browser specified in properties: {}", browser);
    }

    logger.info("WebDriver initialized successfully");

    // Add more browsers as needed

    WebEventListener listener = new WebEventListener();
    driver = new EventFiringDecorator<>(listener).decorate(driver);

    // Maximize the browser window
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WaitUtils.pageLoadTimeout));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtils.implicitWaitTime));

    // Navigate to the URL specified in properties
    driver.get(prop.getProperty("url"));
}

    

}
    
    
