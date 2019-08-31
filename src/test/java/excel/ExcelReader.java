package excel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) {

		try {
			// Step 1 - create work book object
			XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\Prempc\\Documents\\Book1.xlsx");
			
			// Step 2 -> get sheet 
			
			XSSFSheet sheet1 = workbook.getSheet("Sheet1");
			
			// iterate rows and cols
			
			// get last row no
			int lrNo = sheet1.getLastRowNum();
			int frNo = sheet1.getFirstRowNum();
			
			for (int i = frNo; i <lrNo ; i++) {
				// get row object
				XSSFRow row = sheet1.getRow(i);
				// from row , get col numbers
				int fcNo = row.getFirstCellNum();
				int lcNo = row.getLastCellNum();
				
				for (int j = fcNo; j < lcNo; j++) {
					
					XSSFCell cell = row.getCell(j);
					System.out.println(cell.getStringCellValue());
				}
				
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
