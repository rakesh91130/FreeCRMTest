package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static final int PAGE_LOAD_TIMEOUT=20;
	public static final int IMPLICIT_WAIT=20;

	public static String TESTDATA_PATH="./src/main/java/com/crm/qa/testdata/FreeCrmTestData.xlsx";
			


	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	/**
	 * 
	 * @param sheetName
	 * @return
	 */
	public static Object[][] getTestData(String sheetName){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(TESTDATA_PATH);
			workbook = new XSSFWorkbook(fis);
		} catch (FileNotFoundException  e) {
			e.printStackTrace();
		}
		catch ( IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(workbook.getNumberOfSheets());
		sheet = workbook.getSheet(sheetName);
		System.out.println("row "+sheet.getLastRowNum());
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for(int i = 0;i<sheet.getLastRowNum();i++) {
			for(int j = 0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j] =sheet.getRow(i+1).getCell(j).toString();
				//System.out.println(data[i][j]);
			}
		}


		return data;
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	public static void takesScreenshotAtEndOfTest() throws IOException {
		TakesScreenshot ts =  (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String trg = System.getProperty("user.dir");
		
		FileUtils.copyFile(src, new File(trg +"/screenshots/"+System.currentTimeMillis()+".png"));
	}
	
	
	
//	public static void main(String[]args) {
//		TestUtil.getTestData("contacts");
//	}


}
