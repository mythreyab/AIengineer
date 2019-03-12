package test;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageFactory.TestBase;
import PageFactory.GoogleHomeSearchPage;

public class TestAutoSuggestion extends TestBase {
	
	GoogleHomeSearchPage googleHomeSearchPage ;
	
	public TestAutoSuggestion() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		googleHomeSearchPage = new GoogleHomeSearchPage() ;
	}
	
	@Test(priority=0)
	public void verifyGoogleAutoSuggestion() {
		
		int actualSize = 0;
		int expectedSize = 0;
		googleHomeSearchPage.homeGoogleSearch.clear();
		googleHomeSearchPage.homeGoogleSearch.sendKeys(searchString);
						
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> googleHomeSearchList =  googleHomeSearchPage.getHomeGoogleSearchList();
		expectedSize = googleHomeSearchList.size();		
		
		for(int i = 0 ;i< googleHomeSearchList.size();i++)
		{				
			if(googleHomeSearchList.get(i).getText().contains(searchString))
			{
				actualSize += 1;
			}
		}

        Assert.assertEquals(actualSize, expectedSize); 
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}


