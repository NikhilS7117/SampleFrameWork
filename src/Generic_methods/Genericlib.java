package Generic_methods;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
/**@author Lenovo**/

public class Genericlib
{

	String childWindow;
	String parentWindow;

	public String getExcelData(String expath,String sheet,int row,int col) throws Throwable
	{

		FileInputStream fis = new FileInputStream( expath);
		Workbook wb =WorkbookFactory.create(fis);
		Sheet sht =wb.getSheet(sheet);
		Row r = sht.getRow(row);
		Cell c = r.getCell(col);
		String s = c.toString();
		return s;
	}
	
	public String getExcelDataFixSHEET(String sheetName,int row,int col) throws Throwable
	{

		FileInputStream fis = new FileInputStream("../Shri_Framework/VtigerData.xlsx");
		Workbook wb =WorkbookFactory.create(fis);
		Sheet sht =wb.getSheet(sheetName);
		Row r = sht.getRow(row);
		Cell c = r.getCell(col);
		String s = c.toString();
		return s;
	}


	public String getvaluesfromProp(String key) throws Throwable
	{	FileInputStream fisObj = new FileInputStream("../Shri_Framework/ExternalData.properties");
	Properties pObj = new Properties();
	pObj.load(fisObj);
	String s = pObj.getProperty(key);
	return s;
	}	
	/**  to switch from parent window to child window**/
	public void switchChild(WebDriver driver)
	{
		Set <String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		parentWindow=it.next();
		childWindow=it.next();
		driver.switchTo().window(childWindow);
	}
	/**comapre the givern data with list pass driver ,xpath of element , value**/
	public String comapreList(WebDriver driver,String xstr,String product)
	{
		List<WebElement> list =driver.findElements(By.xpath("xstr"));	

		for(WebElement wb:list)
		{		 
			if(wb.getText().equals(product));
			{
				break;
			}
		}
		return "Data inserted";
	}
	/**provide driver and xpath of the element  to mousehoveron**/
	public void mouseover(WebDriver driver , String xstr)
	{
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(xstr));
		action.moveToElement(element).perform();
	}

	/**  to switch from child window to parent window**/
	public void switchParent(WebDriver driver)
	{
		driver.switchTo().window(parentWindow);
	}
	/**to select Dropdown list contents
	 * pass driver , xapth of the element , value**/
	public void dropDown(WebDriver driver,String xstr,String visibleText)
	{
		WebElement wb1 = driver.findElement(By.xpath(xstr));
		Select s1 = new Select(wb1);
		s1.selectByVisibleText(visibleText);
	}
	/** it will search element for 20 times or for 20 seconds**/
	public void customWait(WebElement wb) throws Throwable
	{
		int count=0;
		while(count<20)
		{
			try
			{
				wb.click();
				break;
			}
			catch(Throwable t1)
			{
				Thread.sleep(1000);
				count ++;
			}
		}
	}
	/**generate random value**/
	public int genRandomvalue()
	{
		Random r = new Random();
		int no=r.nextInt(1000);
		return no;
	}

}