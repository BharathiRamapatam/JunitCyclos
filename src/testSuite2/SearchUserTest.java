package testSuite2;

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
public class SearchUserTest extends testBase{
	//1st step
	//make the variables global by declaring them as public 
	public String searchUser;
	
	//2nd step
	//create a function with  which accepts the variables in constructor
	public SearchUserTest (String srcUser){
		this.searchUser = srcUser;
	}
	
	@Before
	public void beforeUserTest() throws IOException{
		initialise();
		
		if(TestUtil.isSkipped("SearchUserTest"))
		    Assume.assumeTrue(false);
		
		
		
	}

	//3rd actual test 
	@Test
	public void searchUsers() throws Exception{

			
		Thread.sleep(3000);
		//dr.get("https://demo.cyclos.org/#users.users.search");
		dr.findElement(By.xpath(OR.getProperty("userLink"))).click();//click on user link in home page
		
		Thread.sleep(5000);

		dr.findElement(By.xpath(OR.getProperty("searchInputBox"))).sendKeys(searchUser);//input user in the keyword box

		dr.findElement(By.xpath(OR.getProperty("searchButton"))).click();
		
		Thread.sleep(5000);
		
	}
	
	@Parameters
	public static Collection<Object[]>dataSupplier(){
     Object[][] data = TestUtil.getData("SearchUserTest");
		
		return Arrays.asList(data);
	}
	
	/*
	public static Collection<Object[]>dataSupplier(){
		//runing the test 3 times with one variable ie is user search string.
		Object [][]data = new Object [3][1];
		
		data [0][0] = "user";
		data [1][0] = "sogeti";
		data [2][0] = "test";
		
		return Arrays.asList(data);
		
		*/
		
		
	}
	
	
		
		

	
	
	
	


