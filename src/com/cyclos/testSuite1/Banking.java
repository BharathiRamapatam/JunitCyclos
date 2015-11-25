package com.cyclos.testSuite1;

import java.io.IOException;

import org.junit.Assume;
import org.junit.Before;

import com.cyclos.tests.testBase;
import com.cyclos.util.TestUtil;

public class Banking extends testBase{
	
	@Before
	public void beforeTest1() throws IOException{
		initialise();
		if(TestUtil.isSkipped("Banking"))
			   Assume.assumeTrue(false);
		
	}
	
	
	
	

}
