package tests;  
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.WaitUtils;
import base.BaseTest;
import pages.AddEmployeePage;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;

public class AddEmployeePageTest extends BaseTest {


    LoginPage loginPage;
    HomePage homePage;  
    AdminPage adminPage;
    AddEmployeePage addEmployeePage;
    String sheetname = "EmployeeDetails"; // Specify the sheet name for test data

    public AddEmployeePageTest() {
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

@DataProvider(name = "getemployeeData")
public Object[][] getemployeeData() {
    return WaitUtils.getTestData(sheetname); // Fetch test data from the specified sheet
}


    @Test(dataProvider = "getemployeeData")
    public void testAddEmployee(String firstName, String lastName, String status, String username, String password, String confirmPassword) {
        addEmployeePage = adminPage.clickAddEmployeeButton(); // Click on the Add Employee button to navigate to the AddEmployeePage
        addEmployeePage.addEmployee(firstName, lastName, status, username, password, confirmPassword); // Fill in the employee details and submit the form
    }

     @AfterMethod
    public void tearDown() {
        if(driver != null) { 
               driver.quit(); // Close the browser and quit the WebDriver
    }
    }
}
