package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import base.BaseTest;


public class HomePage extends BaseTest {


private static final Logger logger = LogManager.getLogger(HomePage.class);

@FindBy(xpath = "//h6[text()='Dashboard']")
WebElement dashboardHeader;

@FindBy(xpath = "//span[text()='Admin']")
WebElement adminMenu;

@FindBy(xpath = "//span[text()='PIM']")
WebElement pimMenu;

@FindBy(xpath = "//span[text()='Leave']")
WebElement leaveMenu;

public HomePage() {
    // Initialize page elements if needed
    PageFactory.initElements(driver, this);
    logger.debug("HomePage object initialized");
    
}

public String validateHomePageTitle() {
    String title = driver.getTitle();
    logger.info("Home page title retrieved: {}", title);
    return title;

}

public boolean isDashboardHeaderDisplayed() {
    WaitUtils.waitForElementToBeVisible(driver, dashboardHeader);
    boolean isDisplayed = dashboardHeader.isDisplayed();
    logger.info("Dashboard header is displayed: {}", isDisplayed);  
    return isDisplayed;
}


public AdminPage clickAdminMenu() {
    adminMenu.click();
    logger.info("Admin menu clicked, navigating to AdminPage");
    return new AdminPage();

}

public PIMPage clickPIMMenu() {
    pimMenu.click();
    logger.info("PIM menu clicked, navigating to PIMPage");
    return new PIMPage();
}

public LeavePage clickLeaveMenu() {
    leaveMenu.click();
    logger.info("Leave menu clicked, navigating to LeavePage");
    return new LeavePage();
}

}