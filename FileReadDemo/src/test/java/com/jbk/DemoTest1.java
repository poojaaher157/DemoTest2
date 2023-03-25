
package com.jbk;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class DemoTest1{
	Sheet sh = null;
	Row r = null;
	
	Cell c= null;
	@Test
	public void test01() throws Exception{
	FileInputStream fis = new FileInputStream("Test.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	if(wb.getSheet("Test")==null){
		sh=wb.createSheet("Test");
		r=sh.createRow(3);
		c=r.createCell(5);
	}
	else {
		r=sh.createRow(3);
		if(r.getCell(5)==null){
			c=r.createCell(5);
		}
			else
				c=r.getCell(5);
		}
			c.setCellValue("TheKiranAcademy");
			FileOutputStream fos = new FileOutputStream("Test.xlsx");
			wb.write(fos);
			wb.close();
			fos.close();
		
	
	}
	
	

}
