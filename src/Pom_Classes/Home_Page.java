package Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page 
{
	@FindBy(xpath="/html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[6]/a")
	private WebElement orglink;

	public WebElement getorgLink() 
	{
		return orglink;
	}
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement home;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement User;

	@FindBy(linkText="Sign Out")
	private WebElement Signout;
	
	public WebElement getHome() {
		return home;
	}

	public WebElement getUser() {
		return User;
	}
	public WebElement getSignout() {
		return Signout;
	}
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
}
