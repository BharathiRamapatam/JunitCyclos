package testSuite1;

import java.io.IOException;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;

import Tests.testBase;
import Util.TestUtil;

public class LoginTest extends testBase{
	
	@Before
	public void beforeTest() throws IOException{
		
		initialise();
		
		if(TestUtil.isSkipped("LoginTest"))
		    Assume.assumeTrue(false);
		
	}
	
	@Rule
	public ErrorCollector errCollector = new ErrorCollector();
	
	@Ignore
	@Test
	public void Login() throws InterruptedException{
		
		try {
			dr.get(CONFIG.getProperty("testLoginSite"));
			Thread.sleep(5000);
			TestUtil.doLogin("demo","1234");
			//logout
			
			dr.findElement(By.xpath(OR.getProperty("logout_link"))).click();
		} catch (Throwable t) {
			System.err.println("Error Encountered");
			
			errCollector.addError(t);
		}
		
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
	}


