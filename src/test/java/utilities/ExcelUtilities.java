package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	
	String path;
	
	
	public ExcelUtilities(String path) {
		
		this.path= path;
	}
	
	
	
	




	public int getColCount(String sheet_name) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream file = new FileInputStream(path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet =workbook.getSheet(sheet_name);
		
		int col =sheet.getRow(0).getLastCellNum();
		
		workbook.close();		
		return  col;
	
		
	}





	public int getRowCount(String sheet_name) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream file = new FileInputStream(path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet =workbook.getSheet(sheet_name);
		
		int row =sheet.getLastRowNum();
		
		workbook.close();
		
		return row;
		
	}





	public String getCellValue(int r, int c, String sheet_name) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream file = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet =workbook.getSheet(sheet_name);
		
		String value = sheet.getRow(r).getCell(c).toString();
		
		workbook.close();
		
		return value;
		
		
	}

}
