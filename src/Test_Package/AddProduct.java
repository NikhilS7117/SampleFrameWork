package Test_Package;

import java.sql.Driver;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.internal.ApacheHttpClient;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Generic_methods.Genericlib;

public class AddProduct 
{
	@Test
	public void addCampaign() throws Throwable
	{
		Genericlib gl = new Genericlib();
		int no =gl.genRandomvalue();



		String u_name=gl.getvaluesfromProp("username");
		String pass=gl.getvaluesfromProp("password");
		String url=gl.getvaluesfromProp("url");
		String productName="lux"+no;
		String searchProduct="lux";

		//		System.setProperty("webdriver.chrome.driver", url);

		WebDriver driver = new ChromeDriver();
		driver.get(url);

		driver.findElement(By.name("user_name")).sendKeys(u_name);
		driver.findElement(By.name("user_password")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();

		gl.mouseover(driver, "/html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[22]/a");

		//	driver.findElement(By.linkText("More")).click();or

		driver.findElement(By.xpath("//*[@name='Campaigns']")).click();

		driver.findElement(By.xpath("//img[@alt='Create Campaign...\']")).click();

		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(productName);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		//parent to child
		gl.switchChild(driver);
		Set <String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		String parentWindow1=it.next();
		String childWindow1=it.next();

		driver.switchTo().window(childWindow1);

		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(searchProduct);

		gl.dropDown(driver,"/html/body/table/tbody/tr/td/table[2]/tbody/tr/td/form/table/tbody/tr[1]/td[3]/select","Product Name");

		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.id("1")).click();
		//back tot parent window

		driver.switchTo().window(parentWindow1);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		driver.findElement(By.linkText("Campaigns")).click();

		
		
		String result=gl.comapreList(driver,"/html/body/table[4]/tbody/tr/td[2]/div[4]/form/table/tbody/tr[1]/td/div/table/tbody/tr[1]/td[3]/a" ,productName);
		System.out.println(result);
		driver.close();
	}
}
