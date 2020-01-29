package Generic_methods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelAttach 
{
	public static void main(String[] args) throws Throwable 
	{
		/*FileInputStream fis = new FileInputStream("../Shri_Framework/VtigerData.xlsx");
		Workbook wb =WorkbookFactory.create(fis);
		Sheet sheet =wb.getSheet("Sheet1");
		Row r = sheet.getRow(0);
		Cell c = r.getCell(0);
		System.out.println(c.toString());
		*/
		FileInputStream fis = new FileInputStream("../Shri_Framework/VtigerData.xlsx");
		Workbook wb =WorkbookFactory.create(fis);
		Sheet sheet =wb.getSheet("Sheet1");
		int lastrow =sheet.getLastRowNum();
		System.out.println(lastrow);
		Row r = sheet.getRow(lastrow);
		int lastvalue=r.getLastCellNum();
		Cell c = r.getCell(0);
		System.out.println(c);
		wb.write(new FileOutputStream("../Shri_Framework/VtigerData.xlsx"));
		
		
	}
}
