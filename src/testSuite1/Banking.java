package testSuite1;

import java.io.IOException;

import org.junit.Assume;
import org.junit.Before;

import Tests.testBase;
import Util.TestUtil;

public class Banking extends testBase{
	
	@Before
	public void beforeTest1() throws IOException{
		initialise();
		if(TestUtil.isSkipped("Banking"))
			   Assume.assumeTrue(false);
		
	}
	
	
	
	

}
