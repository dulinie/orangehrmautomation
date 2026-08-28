package tests;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.ScreenshotUtils;
import base.BaseTest;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminPageTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    AdminPage adminPage;
   // TestUtil testUtil;

    public AdminPageTest() {
        super(); // Call the BaseTest constructor to initialize properties
    }

    @BeforeMethod
    public void setUp() {
        initialize(); // Initialize WebDriver and open the browser
       // testUtil = new TestUtil(); // Create an instance of the TestUtil class
        
        loginPage = new LoginPage(); // Create an instance of the LoginPage
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); // Perform login to navigate to HomePage
        adminPage = new AdminPage(); // Create an instance of the AdminPage

        adminPage = homePage.clickAdminMenu(); // Click on the Admin tab to navigate to the AdminPage
        
    }

    @Test(priority = 1)
    public void adminPageTitleTest() {
        String title = adminPage.validateAdminPageTitle(); // Validate the Admin page title
        Assert.assertEquals(title, "OrangeHRM", "Admin page title mismatch"); // Assert that the Admin page title is as expected
    }

    @Test(priority = 2)
    public void adminHeaderTest() {
        Assert.assertTrue(adminPage.isAdminHeaderDisplayed(), "Admin header is not displayed"); // Assert that the Admin header is displayed    
    }

    @Test(priority = 3)
    public void addEmployeeButtonTest() {   
        Assert.assertTrue(adminPage.isAddEmployeeButtonDisplayed(), "Add Employee button is not displayed"); // Assert that the Add Employee button is displayed
    }   


    
   @AfterMethod
public void tearDown(ITestResult result) {
    if (result.getStatus() == ITestResult.FAILURE) {
        ScreenshotUtils.captureScreenshot(driver, result.getName());
    }
    if (driver != null) {
        driver.quit();
    }
}
}
