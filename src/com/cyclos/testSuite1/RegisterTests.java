package com.cyclos.testSuite1;

import java.io.IOException;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import com.cyclos.tests.testBase;
import com.cyclos.util.TestUtil;

public class RegisterTests extends testBase{
	@Before
	public  void beforeRegister() throws IOException{
		//initiliase the browser and properties files
		initialise();
		
		//check the run mode of test cases in xls file
		if(TestUtil.isSkipped("RegisterTests"))
			   Assume.assumeTrue(false);
		
	}
	
	//please change parameters for each run 
	@Test
	public void newRegister(){
		try {
			Thread.sleep(5000);
			dr.get(CONFIG.getProperty("testLoginSite"));
			TestUtil.existingUserregister("abcd", "abcdf", "bu@gmail.com", "Testing");
		} catch (Throwable t) {
			TestUtil.takeScreenShot("newRegisterUser");
			System.err.println(t.getMessage());
			System.out.println("Error");
		}
	}
	
	@Test
	public void existingUserRegister() throws InterruptedException{
		try {
			dr.get(CONFIG.getProperty("testLoginSite"));
			TestUtil.existingUserregister("pranav", "pranav", "p@gmail.com", "testing");
		} catch (Throwable t) {
		TestUtil.takeScreenShot("existingUserRegister");
			System.err.println(t.getMessage());
			System.out.println("Error");
		}
		
	}
	
	
	
	
	
	

	

}
