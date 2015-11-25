package com.cyclos.testSuite1;

import java.io.IOException;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.cyclos.tests.testBase;
import com.cyclos.util.TestUtil;

public class InvalidLoginTests extends testBase{
	
	@Before
	public void beforeInvalidLogin() throws IOException{
		initialise();
		if(TestUtil.isSkipped("InvalidLoginTests"))
			   Assume.assumeTrue(false);
		
	}
//collect all the errors
	@Rule
	public ErrorCollector errCollector = new ErrorCollector();
	
//verify error 	message when no username is supplied
	
	@Test 
	public void invalidLogin1() {
		try {
			Thread.sleep(5000);
			dr.get(CONFIG.getProperty("testLoginSite"));
			TestUtil.blankUsername("1234");
			TestUtil.takeScreenShot("blankUsername");
		} catch (Throwable t) {
            System.err.println("Error Encountered");
			
			errCollector.addError(t);
			
		}
		}

//verify error message when no password is entered
	@Test
	public void invalidLogin() {
		try {
			Thread.sleep(5000);
			dr.get(CONFIG.getProperty("testLoginSite"));
			TestUtil.invalidLogin("aaaa", "8888");
			TestUtil.takeScreenShot("invalidlogins");
		} catch (Throwable t) {
			
		    System.err.println("Error Encountered");
			errCollector.addError(t);
		}
		
		
	}

}
