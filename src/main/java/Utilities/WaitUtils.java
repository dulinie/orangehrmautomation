package Utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BaseTest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class WaitUtils extends BaseTest {

    public static long pageLoadTimeout = 20; // Default page load timeout in seconds    
    public static long implicitWaitTime = 10; // Default implicit wait time in seconds

    public static String TESTDATA_SHEET_PATH = "C:\\Dulini\\Studies\\SeleniumAutomation\\orangehrmautomation\\orangehrmTestData\\OrangeHRMDemData.xlsx";



    // Explicit wait for element visibility
    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static Object[][] getTestData(String sheetName) {
        try (FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH)) {
            Workbook book = WorkbookFactory.create(file);
            Sheet sheet = book.getSheet(sheetName);

            if (sheet == null) {
                throw new IllegalArgumentException("Sheet not found: " + sheetName);
            }

            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                return new Object[0][0];
            }

            DataFormatter formatter = new DataFormatter();
            List<Object[]> rows = new ArrayList<>();
            int columnCount = headerRow.getLastCellNum();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }

                boolean isEmptyRow = true;
                for (int c = 0; c < columnCount; c++) {
                    if (row.getCell(c, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL) != null) {
                        isEmptyRow = false;
                        break;
                    }
                }

                if (isEmptyRow) {
                    continue;
                }

                Object[] values = new Object[columnCount];
                for (int c = 0; c < columnCount; c++) {
                    values[c] = formatter.formatCellValue(row.getCell(c, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL));
                }
                rows.add(values);
            }

            return rows.toArray(new Object[0][0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Object[0][0];
    }

    public static void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        File screenshotDir = new File(currentDir, "screenshots");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }
        FileUtils.copyFile(scrFile, new File(screenshotDir, System.currentTimeMillis() + ".png"));
    }

	
}

