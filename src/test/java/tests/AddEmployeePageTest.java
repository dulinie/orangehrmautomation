package tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Utilities.DataProviderUtils;
import pages.AddEmployeePage;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;

public class AddEmployeePageTest extends TestBase {


    LoginPage loginPage;
    HomePage homePage;  
    AdminPage adminPage;
    AddEmployeePage addEmployeePage;
    
    
    public AddEmployeePageTest() {
        super(); // Call the BaseTest constructor to initialize properties
    }

    @BeforeMethod   
    public void addEmployeePageSetUp() {
        loginPage = new LoginPage(); // Create an instance of the LoginPage
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); // Perform login to navigate to HomePage
        adminPage = new AdminPage(); // Create an instance of the AdminPage
        adminPage = homePage.clickAdminMenu(); // Click on the Admin tab to navigate to the AdminPage
        
    }

    @DataProvider(name = "getemployeeData")
    public Object[][] getemployeeData() {
        return DataProviderUtils.getTestData("EmployeeDetails"); // Fetch test data from the specified sheet
        
    }

    @Test(dataProvider = "getemployeeData")
    public void testAddEmployee(String urole, String ename, String status, String username, String password, String confirmPassword) {
        addEmployeePage = adminPage.clickAddEmployeeButton(); // Click on the Add Employee button to navigate to the AddEmployeePage
        addEmployeePage.addEmployee(urole, ename, status, username, password, confirmPassword); // Fill in the employee details and submit the form
       
    }
}
