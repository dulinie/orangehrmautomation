package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class AddEmployeePage extends BaseTest {

    @FindBy(xpath = "//label[text()='User Role']/../following-sibling::div//div[contains(@class,'oxd-select-text')]")
    WebElement userRoleDropdown;

    @FindBy(xpath = "//label[text()='Employee Name']/../following-sibling::div//input")
    WebElement employeeNameInput;

    @FindBy(xpath = "//label[text()='Status']/../following-sibling::div//div[contains(@class,'oxd-select-text')]")
    WebElement statusDropdown;

    @FindBy(xpath = "//label[text()='Username']/../following-sibling::div//input")
    WebElement usernameInput;

    @FindBy(xpath = "//label[text()='Password']/../following-sibling::div//input[@type='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//label[text()='Confirm Password']/../following-sibling::div//input[@type='password']")
    WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[@type='submit' and normalize-space()='Save']")
    WebElement saveButton;

    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }

    public void addEmployee(String userRole, String employeeName, String status, String username, String password, String confirmPassword) {
        userRoleDropdown.click();
        driver.findElement(By.xpath("//div[@role='option' and normalize-space()='" + userRole + "']")).click();

        employeeNameInput.sendKeys(employeeName);

        statusDropdown.click();
        driver.findElement(By.xpath("//div[@role='option' and normalize-space()='" + status + "']")).click();

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confirmPassword);
        saveButton.click();
    }
}

