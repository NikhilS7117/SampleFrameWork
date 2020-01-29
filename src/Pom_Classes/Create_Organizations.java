package Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Organizations 
{
	@FindBy(xpath="/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/"
			+ "tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input")
	private WebElement Orgnamebox;
	
	@FindBy(id="phone")
	private WebElement phoneno;


	public WebElement getPhoneno() {
		return phoneno;
	}


	@FindBy(id="email1")
	private WebElement emailid;

	public WebElement getEmailid() {
		return emailid;
	}

	@FindBy(xpath="//img[@alt='Select']")
	private WebElement addimage;

	public WebElement getAddimage() {
		return addimage;
	}

	public Create_Organizations(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getOrgnamebox() 
	{
		return Orgnamebox;
	}





}
