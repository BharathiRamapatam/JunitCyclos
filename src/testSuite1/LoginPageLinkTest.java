package testSuite1;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Tests.testBase;
import Util.TestUtil;


public class LoginPageLinkTest extends testBase {
	
	@Before
	public void beforeLinkTest() throws Exception{
	initialise();
	
	//if(TestUtil.isSkipped("LoginPageLinkTest"))
	    //Assume.assumeTrue(false);

	}
	@Rule
	public ErrorCollector errCollector = new ErrorCollector();
	
	@Ignore
	@Test
	
	public void doLinkTestLoginPage(){// facebook, twitter, youtube link test
		TestUtil.launchLoginsite();
	//dr.navigate().to(CONFIG.getProperty("testLoginSite"));
	List<WebElement> elements = dr.findElements(By.xpath(OR.getProperty("social_links")));
	System.out.println(elements.size());
		
		try {
			for(int i=0;i<elements.size();i++){
			    System.out.println(elements.get(i).getAttribute("href"));
			    Thread.sleep(5000);
			    elements.get(i).click();
			    
			}
			
			Set<String> winIds = dr.getWindowHandles();
			System.out.println("Total browsers-> "+winIds.size());
			Iterator<String> it= winIds.iterator();
	        String main = it.next();
			String facebook = it.next();
			String twitter = it.next();
			String youtube = it.next();
	// facebook
			dr.switchTo().window(facebook);
	        //get screenshot
			TestUtil.takeScreenShot("facebookPage");
		   dr.close();
		   dr.switchTo().window(main);
	//twitter
			dr.switchTo().window(twitter);
	        //take screen shot	
			TestUtil.takeScreenShot("twitterPage");
			dr.close();
			dr.switchTo().window(main);
	//youtube
			dr.switchTo().window(youtube);
			//take screnshot
			TestUtil.takeScreenShot("youtubePage");
			dr.close();
			dr.switchTo().window(main);
			
			 }catch (Throwable t) {
				 
	//report errors			
			System.err.println("Error Encountered");
					
			errCollector.addError(t);
			 }
	}
			
@Test
public void mainLiks(){	//main tabs in login page
	TestUtil.launchLoginsite();
	List<WebElement> mainLinks = dr.findElements(By.xpath("//a"));
	System.out.println(mainLinks.size());
	
	for (int j = 1; j<mainLinks.size();j++){
		System.out.println(mainLinks.get(j).getText());
	}
	
	
	
	
		
		
}	
	}
	
		
		
	
	
	

