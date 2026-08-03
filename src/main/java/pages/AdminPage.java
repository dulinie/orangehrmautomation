package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class AdminPage extends BaseTest {

    @FindBy(xpath = "//h6[text()='Admin']")
    WebElement adminHeader ;
    
    @FindBy(xpath = "//button[@type='button' and text()=' Add ']")
    WebElement addEmployeeButton;

    public AdminPage() {
        // Initialize page elements if needed
        PageFactory.initElements(driver, this);
    }

    public String validateAdminPageTitle() {
        return driver.getTitle();
    }

    public boolean isAdminHeaderDisplayed() {
        return adminHeader.isDisplayed();
    }

    public boolean isAddEmployeeButtonDisplayed() {
        return addEmployeeButton.isDisplayed();

    }

    public AddEmployeePage clickAddEmployeeButton() {
        addEmployeeButton.click();
        return new AddEmployeePage(); // Return an instance of the AddEmployeePage after clicking the button
    }

}
