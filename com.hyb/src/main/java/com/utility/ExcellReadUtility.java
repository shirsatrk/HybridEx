package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import com.testBase.BaseClass;

public class ExcellReadUtility extends BaseClass{

	FileInputStream fis;
	Workbook wb;
	
	public String getCellData(String filepath, String sheet, int i, int j) {
		DataFormatter df = new DataFormatter();
		try {
			fis = new FileInputStream(filepath);
			wb = WorkbookFactory.create(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		Sheet sh = wb.createSheet(sheet);
		Cell c = sh.getRow(i).getCell(j);
		return df.formatCellValue(c);
	}
	
	@Test
	public void uTest() {
		String poi = System.getProperty("user.dir")+"/src/test/resources/poi.xlsx";
		String jxl = System.getProperty("user.dir")+"/src/test/resources/jxl.xls";
		
		System.out.println(getCellData(jxl, "Sheet1", 0, 0));
		System.out.println(getCellData(poi, "Sheet1", 0, 0));
		
	}
	
}
