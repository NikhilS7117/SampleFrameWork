package Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization_Info 

{
		
	@FindBy(id="dtlview_Organization Name")
	private WebElement orgnametext;
	
	public WebElement orgnameText() {
		return orgnametext;
	}

	public Organization_Info (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
