package testSuite1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;

import Tests.testBase;
import Util.TestUtil;

@RunWith(Parameterized.class)
public class LoginParameterTest extends testBase {
	
	
		//1st step
		//make the variables global by declaring them as public 
		public String username;
		public String password;
		
		
		//2nd step
		//create a function with  which accepts the variables in constructor
		public LoginParameterTest (String username, String password){
			this.username = username;
			this.password = password;
		}
		
		@Before
		public void beforeUserTest() throws IOException{
			initialise();
			if(TestUtil.isSkipped("LoginParameterTest"))
			    Assume.assumeTrue(false);
			
			
			
			
		}
		
		@Test
		public void log() {
			try {
				Thread.sleep(100000);
				dr.get(CONFIG.getProperty("testLoginSite"));
				
				//dr.findElement(By.xpath(OR.getProperty("username_field"))).clear();
				
				
				dr.findElement(By.xpath(OR.getProperty("username_field"))).sendKeys(username);
				//dr.findElement(By.xpath(OR.getProperty("password_field"))).clear();
				dr.findElement(By.xpath(OR.getProperty("password_field"))).sendKeys(password);
				dr.findElement(By.xpath(OR.getProperty("submit_link"))).click();
				//Assert.assertEquals(welcomeDemo, );
				String welcomeDemo = dr.findElement(By.xpath(OR.getProperty("welcome_demoMessage"))).getText();
				System.out.println(welcomeDemo);
				
				//take screenshot of user screen
				TestUtil.takeScreenShot(this.username);
				dr.findElement(By.xpath(OR.getProperty("logout_link"))).click();
			} catch (Throwable t) {
				TestUtil.takeScreenShot("error");
				
				System.out.println(t.getMessage());
			}
			
		}
		
		@Parameters
		
		//read data from xls file 
		public static Collection<Object[]>dataSupplier(){
		Object[][] data = TestUtil.getData("LoginParameterTest");
		
		return Arrays.asList(data);
		
		
		/*
		public static Collection<Object[]>dataSupplier(){
			
			//parameterise the data : Running the test 3 times with one variable ie is user search string.
			
			Object [][]data = new Object [3][2];
			//1st row
			data [0][0] = "demo";
			data [0][1] = "1234";
			
			//2nd row
			data [1][0] = "demo3";
			data [1][1] = "1234";
			
			//3rd row
			data [2][0] = "demo2";
			data [2][1] = "1234";
			
			
			return Arrays.asList(data);
			
		*/	
			
		}
		

}
