import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.Assert;

import base.BaseTest;
import pages.AdminPage;
import pages.HomePage;
import pages.LeavePage;
import pages.LoginPage;
import pages.PIMPage;


public class HomePageTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    AdminPage adminPage;
    PIMPage pimPage;
    LeavePage leavePage;    

    public HomePageTest() {
        super(); // Call the BaseTest constructor to initialize properties
    }

    @BeforeMethod
    public void setUp() {
        initialize(); // Initialize WebDriver and open the browser
        loginPage = new LoginPage(); // Create an instance of the LoginPage
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); // Perform login to navigate to HomePage
        adminPage = new AdminPage(); // Create an instance of the AdminPage
        pimPage = new PIMPage(); // Create an instance of the PIMPage
        leavePage = new LeavePage(); // Create an instance of the LeavePage
        
    }


    @Test(priority = 1)
    public void homePageTitleTest() {
        String title = homePage.validateHomePageTitle(); // Validate the home page title
        Assert.assertEquals(title, "OrangeHRM", "Home page title mismatch"); // Assert that the home page title is as expected
           }

    @Test(priority = 2)
    public void dashboardHeaderTest() {
        boolean isDashboardHeaderDisplayed = homePage.isDashboardHeaderDisplayed(); // Validate that the dashboard header is displayed
        Assert.assertTrue(isDashboardHeaderDisplayed, "Dashboard header is not displayed"); // Assert that the dashboard header is displayed
    }

@Test(priority = 3)
public void clickOnAdminTabTest() {
        adminPage = homePage.clickAdminMenu(); // Click on the Admin tab
        //String adminPageTitle = homePage.validateAdminPageTitle(); // Validate the Admin page title after clicking the Admin tab
        //Assert.assertEquals(adminPageTitle, "Admin", "Admin page title mismatch"); // Assert that the Admin page title is as expected
    }

    @Test(priority = 4)
    public void clickOnPIMTabTest() {
        pimPage = homePage.clickPIMMenu(); // Click on the PIM tab
        //String pimPageTitle = homePage.validatePIMPageTitle(); // Validate the PIM page title after clicking the PIM tab
        //Assert.assertEquals(pimPageTitle, "PIM", "PIM page title mismatch"); // Assert that the PIM page title is as expected
    }

    @Test(priority = 5)
    public void clickOnLeaveTabTest() {
        leavePage = homePage.clickLeaveMenu(); // Click on the Leave tab
        //String leavePageTitle = homePage.validateLeavePageTitle(); // Validate the Leave page title after clicking the Leave tab
        //Assert.assertEquals(leavePageTitle, "Leave", "Leave page title mismatch"); // Assert that the Leave page title is as expected
    }

    @AfterMethod
    public void tearDown() {
        driver.quit(); // Close the browser session after all tests are done
    }   
}