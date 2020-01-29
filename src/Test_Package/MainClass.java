package Test_Package;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_methods.Genericlib;
import Pom_Classes.Create_Organizations;
import Pom_Classes.Home_Page;
import Pom_Classes.Organization_Info;
import Pom_Classes.Organizations_Page;
import Pom_Classes.Organizations_childWindow;
import Pom_Classes.Vtiger_Commercial_Open;

public class MainClass 
{
	@Test
	public void TestStart() throws Throwable
	{
		Genericlib gl = new Genericlib();
		String url = gl.getvaluesfromProp("url");
		String Uname=gl.getvaluesfromProp("username");
		String Pass=gl.getvaluesfromProp("password");
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		Vtiger_Commercial_Open v1 = new Vtiger_Commercial_Open(driver);	
		v1.login(Uname, Pass);
		Home_Page h1 = new Home_Page(driver);
		h1.getorgLink().click();
		Organizations_Page o1 = new Organizations_Page(driver);
		o1.getAddbutton().click();

		Create_Organizations c1 = new Create_Organizations(driver);
		String orgName=gl.getExcelDataFixSHEET("Sheet1",5,0)+gl.genRandomvalue();
		c1.getOrgnamebox().sendKeys(orgName);
		c1.getEmailid().sendKeys(gl.getExcelDataFixSHEET("Sheet1",3,1));
		c1.getPhoneno().sendKeys(gl.getExcelDataFixSHEET("Sheet1",3,2));
		c1.getAddimage().click();
		//switch to child
		gl.switchChild(driver);

		Organizations_childWindow ow1 = new Organizations_childWindow(driver);
		ow1.getOrgChildSearch().sendKeys(gl.getExcelDataFixSHEET("Sheet1",1,3));
		ow1.getOrgChildbutton().click();
		ow1.getSearchResult().click();
		driver.switchTo().alert().accept();
		//switch to parent
		gl.switchParent(driver);
		ow1.getSave().click();
		Organization_Info oi = new Organization_Info(driver);
		Thread.sleep(3000);
		String actual_name =oi.orgnameText().getText();
		Assert.assertEquals(actual_name, orgName);
		
		h1.getUser().click();
		Thread.sleep(3000);
		h1.getSignout().click();
		Thread.sleep(3000);
		driver.close();

	}
}
