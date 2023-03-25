package com.jbk;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginWithExcel {
	int count = 0;
	Sheet sh = null;
	Row r = null;
	Cell c = null;

	public String getCellData(int row, int col) throws Exception {
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("Test.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Cell c = sh.getRow(row).getCell(col);
		return df.formatCellValue(c);
	}

	public void writeCell(int row, int col, String data) throws Exception {
		FileInputStream fis = new FileInputStream("Test.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		if (wb.getSheet("Sheet1") == null) {
			sh = wb.createSheet("Sheet1");
			r = sh.createRow(row);
			c = r.createCell(col);
		} else {
			sh = wb.getSheet("Sheet1");
			if (sh.getRow(row) == null) {
				r = sh.createRow(row);
				c = r.createCell(col);
			} else {
				r = sh.getRow(row);
				if (r.getCell(col) == null) {
					c = r.createCell(col);
				} else {
					c = r.getCell(col);
				}
			}
			c.setCellValue(data);
			FileOutputStream fos = new FileOutputStream("Test.xlsx");
			wb.write(fos);
			wb.close();
			fos.close();
		}
	}
	

	@Test
	public void test01() throws Exception {
		while (count <= 5) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///C:/Users/Admin/Downloads/javabykiran-Selenium-Softwares/Offline%20Website/index.html");

			driver.findElement(By.id("email")).sendKeys(getCellData(count, 0));// 1
			driver.findElement(By.id("password")).sendKeys(getCellData(count, 1));
			driver.findElement(By.xpath("//button")).click();

			if (driver.getTitle().contains("Dashboard")) {
				writeCell(count, 2, "PASS");// 1
				count++;
           }else{
        	   writeCell(count, 2, "FAIL");
        	   count++;
           }
		}
	}

}
