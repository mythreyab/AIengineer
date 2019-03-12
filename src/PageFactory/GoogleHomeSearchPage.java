package PageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import PageFactory.TestBase;

public class GoogleHomeSearchPage extends TestBase {
	
	@FindBy(xpath="//input[@title='Search']")
	public WebElement homeGoogleSearch;
			
	 @FindBys(@FindBy(xpath="//ul[@role='listbox']//li"))
     private List<WebElement> homeGoogleSearchList;

     public List<WebElement> getHomeGoogleSearchList() {
         return homeGoogleSearchList;
     }


	// Initializing the Page Objects:
	public GoogleHomeSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
}
