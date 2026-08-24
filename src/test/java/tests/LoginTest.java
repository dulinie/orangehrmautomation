
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import org.testng.Assert;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {  
    
     LoginPage loginPage ;
     HomePage homePage ;


    public LoginTest() {
        super(); // Call the constructor of BaseTest to initialize properties
    }   


    @BeforeMethod
    public void setUp() {
        initialize(); // Call the initialization method to set up the WebDriver and open the browser
        loginPage = new LoginPage(); // Create an instance of the LoginPage
    }

    @Test(priority = 1 )
    public void LoginPageTitleTest () {
        
        String title = loginPage.validateLoginPageTitle(); // Validate the page title
        Assert.assertEquals(title, "OrangeHRM", "Login page title mismatch"); // Assert that the page title is as expected
            }
            


@Test(priority = 2)
public void isLogoDisplayedTest() {
        boolean isLogoDisplayed = loginPage.validateOrangeHrmLogo(); // Validate that the logo is displayed
        Assert.assertTrue(isLogoDisplayed); // Assert that the logo is displayed
}

@Test(priority = 3)
public void loginTest() {   
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); // Perform login using credentials from config.properties
       // String homeTitle = homePage.validateHomePageTitle(); // Validate the home page title after login
       // assertEquals("OrangeHRM", homeTitle); // Assert that the home page title is as expected
    }

    @AfterMethod    
    public void tearDown() {
        driver.quit(); // Close the browser session after each test
    }

}
