package Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations_Page
{
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement addbutton;


	public WebElement getAddbutton() 
	{
		return addbutton;
	}



	public Organizations_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
