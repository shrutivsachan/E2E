package FrameworkPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String[] args) throws IOException {
		//Open the desired workbook or file
		FileInputStream fs = new FileInputStream("C:\\dev\\Documents\\DataSheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		
		// open the desired sheet
		int sheets = workbook.getNumberOfSheets();
		for(int i =0;i<sheets;i++){
			if(workbook.getSheetName(i).equalsIgnoreCase("Sample"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				//iterate through all the rows
				
				Iterator<Row> rowiterator =sheet.iterator();
				while(rowiterator.hasNext())
				{
					Row row =rowiterator.next();
					
					// iterate through all the column in the particular row.
					Iterator<Cell> celliterator =row.cellIterator();
					while(celliterator.hasNext())
					{
						Cell cell = celliterator.next();
						
						switch(cell.getCellType())
						{
						case NUMERIC:
						System.out.println(cell.getNumericCellValue()+"\t");
						break;
						case STRING:
							System.out.println(cell.getStringCellValue()+"\t");
						break;
						default:
							break;
						}
					}
					fs.close();
				}
			}
		}
		
	}

}
