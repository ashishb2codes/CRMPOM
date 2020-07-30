package codes.pom.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import codes.pom.base.BaseMain;

public class Util extends BaseMain{
	
	
	// ########## DataDriven Utility ##########
	public static String TESTDATA_SHEET_PATH = "D:\\WorkspaceSelen\\CRMPOM\\src\\main\\java\\codes\\pom\\util\\DataDrivenTestData.xlsx";
	
	static Workbook workbook;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			workbook = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		
		sheet = workbook.getSheet(sheetName);
		Object[][] inputData = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int r=0; r<sheet.getLastRowNum(); r++) {
			for(int c=0; c<sheet.getRow(0).getLastCellNum(); c++) {
				inputData[r][c] = sheet.getRow(r+1).getCell(c).toString();
			}
		}
		return inputData;
	}
	
	// ########## ScreenShot Utility ##########
	public static void takeScreenShot() throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File captureScrShot = scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(captureScrShot, new File("..\\CRMPOM\\projectScreenshots\\" + System.currentTimeMillis() + ".png"));
	}

}
