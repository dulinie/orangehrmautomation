package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class DataProviderUtils {

        String sheetname = "EmployeeDetails"; // Specify the sheet name for test data
        private static final Logger logger = LogManager.getLogger(DataProviderUtils.class);

        public static String TESTDATA_SHEET_PATH = "orangehrmTestData/OrangeHRMDemData.xlsx";

        
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
            logger.error("IOException occurred while reading test data: {}", e.getMessage());
        } catch (Exception e) {
            logger.error("Error reading test data: {}", e.getMessage());        
        }

        return new Object[0][0];
    }


}
