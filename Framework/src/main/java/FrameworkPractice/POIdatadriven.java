package FrameworkPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIdatadriven {
	
	public static void main(String[] args) throws IOException{

	// Create Workbook instance holding reference to .xlsx file
	FileInputStream fs = new FileInputStream("C:\\dev\\Documents\\DataSheet.xlsx");
	XSSFWorkbook wb = new XSSFWorkbook(fs);
	
	// Get first/desired sheet from the workbook 
	int sheets = wb.getNumberOfSheets();
	System.out.println(sheets);
	for (int i=0; i<sheets; i++)
	{
		if(wb.getSheetName(i).equalsIgnoreCase("Sample"))
		{
		XSSFSheet sheet = wb.getSheetAt(i);
		System.out.println(sheet.getSheetName());
		
		// Iterate through each rows one by one
		Iterator <Row> rowiterator = sheet.iterator();
		while(rowiterator.hasNext()){
			Row row = rowiterator.next();
			
		//Iterate through each column in the particular row
			Iterator<Cell> celliterator = row.cellIterator();
			while(celliterator.hasNext())
			{
				Cell cell =celliterator.next();
				
				// Check the cell type and format accordingly 
				switch(cell.getCellType())
				{
				case NUMERIC:
					System.out.println(cell.getNumericCellValue() +"\t");
					break;
				case STRING:
					System.out.println(cell.getStringCellValue()+"\t");
					break;
				default:
					break;
				}
				System.out.println(""); 
              } 
			fs.close();
			}
		}
		}
	}
}
