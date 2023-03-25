package com.jbk;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
//import org.junit.Test;

public class DemoTest {
	@Test
	public void test01() throws Exception{
		DataFormatter df =new DataFormatter();
		FileInputStream fis = new FileInputStream ("Test.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rows=sh.getLastRowNum();
		for(int i=0; i<=rows; i++){
			int cols=sh.getRow(i).getLastCellNum();
			for(int j=0; j<cols; j++){
				Cell c= sh.getRow(i).getCell(j);
				System.out.print(df.formatCellValue(c)+" ");
			}
			System.out.println();
		}
	}

}
