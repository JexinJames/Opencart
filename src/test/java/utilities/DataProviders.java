package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="LoginData")
	public Object[][] logindp() throws IOException {
		
		
		String path = "./testData/LoginData.xlsx";
		String sheet = "Sheet1";
		ExcelUtilities excel_util = new ExcelUtilities(path);
		
		
		int row = excel_util.getRowCount(sheet);
		int col = excel_util.getColCount(sheet);
		
		String data[][] = new String[row][col];
		
		
		
		for(int r=1; r<=row;r++) {
			
			for(int c=0; c<col; c++) {
				
				data[r-1][c] = excel_util.getCellValue(r,c,sheet);
				
			}
		}
		
		
		
		
		
		
		
		
		/*
		
		String[][] data = {
		        
				{"email", "pwd","valid"},
				{"yiVgLJ@gmail.com","qZlF9","invalid"}
		        		
		        
		};
		*/
		
		
		return data;
		
	};
	

}
