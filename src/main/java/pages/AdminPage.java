package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import base.BaseTest;

public class AdminPage extends BaseTest {
    private static final Logger logger = LogManager.getLogger(AdminPage.class);
    

    @FindBy(xpath = "//h6[text()='Admin']")
    WebElement adminHeader ;
    
    @FindBy(xpath = "//button[@type='button' and text()=' Add ']")
    WebElement addEmployeeButton;

    public AdminPage() {
        // Initialize page elements if needed
        PageFactory.initElements(driver, this);
        logger.debug("AdminPage object initialized");
    }

    public String validateAdminPageTitle() {
        String title = driver.getTitle();
        logger.info("Admin page title retrieved: {}", title);
        return title;
    }

    public boolean isAdminHeaderDisplayed() {
        WaitUtils.waitForElementToBeVisible(driver, adminHeader);
        boolean isDisplayed = adminHeader.isDisplayed();
        logger.info("Admin header is displayed: {}", isDisplayed);
        return isDisplayed;
    }

    public boolean isAddEmployeeButtonDisplayed() {
        boolean isDisplayed = addEmployeeButton.isDisplayed();  
        logger.info("Add Employee button is displayed: {}", isDisplayed);
        return isDisplayed;
    }

    public AddEmployeePage clickAddEmployeeButton() {
        addEmployeeButton.click();
        logger.info("Add Employee button clicked, navigating to AddEmployeePage");
        return new AddEmployeePage(); // Return an instance of the AddEmployeePage after clicking the button
    }

}
