package pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import Utilities.WaitUtils;

public class LoginPage extends BaseTest {

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
    }

    // Actions on Login Page  loa
    public String validateLoginPageTitle() {
        return driver.getTitle();   
    }

public boolean validateOrangeHrmLogo() {
    try {
        // Wait for logo to be visible
        WaitUtils.waitForElementToBeVisible(driver, orangeHrmLogo);
        boolean isDisplayed = orangeHrmLogo.isDisplayed();
        System.out.println("✓ Logo is displayed: " + isDisplayed);
        return isDisplayed;
    } catch (Exception e) {
        System.out.println("✗ Logo not found or not visible: " + e.getMessage());
        return false;
    }
}

public HomePage login(String un, String pwd) {
    username.sendKeys(un);
    password.sendKeys(pwd);
    loginButton.click();

    return new HomePage(); // Return an instance of the HomePage after successful login     
}
}
