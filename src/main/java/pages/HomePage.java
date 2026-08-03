package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class HomePage extends BaseTest {

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
    
}

public String validateHomePageTitle() {
    return driver.getTitle();

}

public boolean isDashboardHeaderDisplayed() {
    return dashboardHeader.isDisplayed();
}

public AdminPage clickAdminMenu() {
    adminMenu.click();
    return new AdminPage();

}

public PIMPage clickPIMMenu() {
    pimMenu.click();
    return new PIMPage();
}

public LeavePage clickLeaveMenu() {
    leaveMenu.click();
    return new LeavePage();
}

}