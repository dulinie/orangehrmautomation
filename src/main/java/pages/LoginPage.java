package pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import Utilities.WaitUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoginPage extends BaseTest {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    //Definng Object Repository for Login Page
    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//img[@alt='company-branding']")
    WebElement orangeHrmLogo;

    
    //LoginPage Constructor  Initializing the Page Objects using Page Factory
    public LoginPage() {
        PageFactory.initElements(driver, this);
        logger.debug("LoginPage object initialized");
    }

    // Actions on Login Page  load
    public String validateLoginPageTitle() {
        String title = driver.getTitle();
        logger.info("Login page title retrieved: {}", title);
        return title;   
    }

public boolean validateOrangeHrmLogo() {
    try {
        // Wait for logo to be visible
        WaitUtils.waitForElementToBeVisible(driver, orangeHrmLogo);
        boolean isDisplayed = orangeHrmLogo.isDisplayed();
        logger.info("Logo is displayed: {}", isDisplayed);
        
        return isDisplayed;
    } catch (Exception e) {
        logger.error("Logo not found or not visible: {}", e.getMessage());
        
        return false;
    }
}

public HomePage login(String un, String pwd) {
     logger.info("Attempting login with username: {}", un);
    username.sendKeys(un);
    password.sendKeys(pwd);
    loginButton.click();
   logger.info("Login button clicked, navigating to HomePage");
    return new HomePage(); // Return an instance of the HomePage after successful login     
}
}
