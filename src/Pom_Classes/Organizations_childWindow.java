package Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations_childWindow 
{
	@FindBy(id="search_txt")
	private WebElement OrgChildSearch;

	public WebElement getOrgChildSearch() {
		return OrgChildSearch;
	}

	@FindBy(xpath="//input[@type='button']")
	private WebElement OrgChildbutton;


	public WebElement getOrgChildbutton() {
		return OrgChildbutton;
	}
	@FindBy(id="1")
	private WebElement searchResult;

	public WebElement getSearchResult() {
		return searchResult;
	}
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement save;

	public WebElement getSave() {
		return save;
	}

	public Organizations_childWindow(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

}
