package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import Utilities.WaitUtils;
import Utilities.WebEventListener;







public class BaseTest {
    public static WebDriver driver;
    public static Properties prop;

   
    public BaseTest() {
        // Initialize WebDriver and other setup here
        try {   
            prop = new Properties();
            // Load properties from config file if needed
            FileInputStream fis = new FileInputStream("C:\\Dulini\\Studies\\SeleniumAutomation\\orangehrmautomation\\src\\main\\resources\\config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();    
        } catch (IOException e) {
            e.printStackTrace();    
        }
    }

public static void initialize() {
    // Initialize WebDriver based on properties
    String browser = prop.getProperty("browser");
    if (browser.equalsIgnoreCase("chrome")) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    } 
     else if (browser.equalsIgnoreCase("firefox")) {
         // Set up FirefoxDriver using WebDriverManager
         WebDriverManager.firefoxdriver().setup();
         driver = new FirefoxDriver();
     }
     else if (browser.equalsIgnoreCase("edge")) {
         // Set up EdgeDriver using WebDriverManager
         WebDriverManager.edgedriver().setup();
         driver = new EdgeDriver();
     }
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

