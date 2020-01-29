package Test_Package;


import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_methods.Genericlib;

public class copy1 
{
	public static void main(String[] args) throws Throwable 
	{
		Genericlib gl = new Genericlib();

		
		String u_name=gl.getvaluesfromProp("username");
		String pass=gl.getvaluesfromProp("password");
		String url=gl.getvaluesfromProp("url");

		int no=gl.genRandomvalue();
		String orgName="good"+no;
		String email="good@gmail.com";
		String phone=""+no;

		WebDriver driver = new ChromeDriver();
		driver.get(url);

		//fill username and password
		driver.findElement(By.name("user_name")).sendKeys(u_name);
		driver.findElement(By.name("user_password")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		//click on organisation
		driver.findElement(By.linkText("Organizations")).click();	
		//click on  + image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//enter org name
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		//enter email
		driver.findElement(By.id("email1")).sendKeys(email);
		//enter phone no
		driver.findElement(By.id("phone")).sendKeys(phone);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();

		gl.switchChild(driver);

		driver.findElement(By.id("search_txt")).sendKeys("qsp");
		//driver.findElement(By.name("search")).click(); or
		driver.findElement(By.xpath("//input[@type='button']")).click();

		driver.findElement(By.xpath("//*[@id=\"1\"]")).click();
		//accept popup
		driver.switchTo().alert().accept();

		gl.switchParent(driver);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();


	}
}
