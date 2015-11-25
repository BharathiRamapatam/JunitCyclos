package com.cyclos.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.cyclos.datatable.Xls_Reader;
import com.cyclos.tests.testBase;

public class TestUtil extends testBase {
	
	public static void launchLoginsite(){
		dr.get(CONFIG.getProperty("testLoginSite"));
		
	}
	//reusable login code
	public static void doLogin(String uname, String pword) throws InterruptedException{
		//if(isLoggedin == true){
			//return;
		
	
		try {
			dr.findElement(By.xpath(OR.getProperty("username_field"))).clear();
			
			dr.findElement(By.xpath(OR.getProperty("username_field"))).sendKeys(uname);
			dr.findElement(By.xpath(OR.getProperty("password_field"))).clear();
			dr.findElement(By.xpath(OR.getProperty("password_field"))).sendKeys(pword);
			dr.findElement(By.xpath(OR.getProperty("submit_link"))).click();
			//Assert.assertEquals(welcomeDemo, );
			Thread.sleep(5000);
			
			TestUtil.takeScreenShot("afterLogin");// take screenshot
			String welcomeDemo = dr.findElement(By.xpath(OR.getProperty("welcome_demoMessage"))).getText();
			System.out.println(welcomeDemo);
			//dr.findElement(By.xpath(OR.getProperty("logout_link"))).click();
		} catch (Throwable t) {
		TestUtil.takeScreenShot("doLogin");	// TODO Auto-generated catch block
			System.out.println(t.getMessage());
		}
		
		
	}
	//blank user name or password field
	public static void blankUsername(String pword){
		try {
			//enter no username
			//dr.findElement(By.cssSelector(OR.getProperty("username_field"))).sendKeys(uname);
			dr.findElement(By.xpath(OR.getProperty("password_field"))).sendKeys(pword);
			dr.findElement(By.xpath(OR.getProperty("submit_link"))).click();
			Thread.sleep(5000);
			System.out.println(dr.findElement(By.xpath(OR.getProperty("error_heading"))).getText());
			System.out.println(dr.findElement(By.xpath(OR.getProperty("loginNameMissing"))).getText());
    
			dr.findElement(By.cssSelector(OR.getProperty("error_CloseButton"))).click();
		} catch (Throwable t) {
			TestUtil.takeScreenShot("blankUsername");
			
			System.out.println("Error Encountered " + t.getMessage());
		}
		
		
		

		
		
	}
	//enter invalid username and password
	public static void invalidLogin(String uname, String pword)  {
		dr.findElement(By.xpath(OR.getProperty("username_field"))).clear();
		dr.findElement(By.xpath(OR.getProperty("password_field"))).clear();
		dr.findElement(By.xpath(OR.getProperty("username_field"))).sendKeys(uname);
		dr.findElement(By.xpath(OR.getProperty("password_field"))).sendKeys(pword);
		//getObject("password_field").sendKeys(pword);
		dr.findElement(By.xpath(OR.getProperty("submit_link"))).click();
		//Thread.sleep(5000);
		System.out.println(dr.findElement(By.xpath(OR.getProperty("errorMessage"))).getText());
	
	    
	}

//verify if existig user can be registered again	
public static void existingUserregister(String sname, String lName,String nemail, String Pword ) throws InterruptedException{
	
	dr.findElement(By.xpath(OR.getProperty("RegisterLink"))).click();
	dr.findElement(By.cssSelector(OR.getProperty("name"))).sendKeys(sname);
	dr.findElement(By.xpath(OR.getProperty("loginname"))).sendKeys(lName);
	dr.findElement(By.xpath(OR.getProperty("password"))).sendKeys(Pword);
	dr.findElement(By.xpath(OR.getProperty("confirmPssword"))).sendKeys(Pword);
	dr.findElement(By.xpath(OR.getProperty("emailField"))).sendKeys(nemail);
	dr.findElement(By.cssSelector(OR.getProperty("femaleRadiobutton"))).click();
	//System.out.println("Please enter security code you have 20 seconds");
	Thread.sleep(20000);
	//click business checkbox
	dr.findElement(By.xpath(OR.getProperty("agreewithBusinessCheckBox"))).click();
	//click submit button
	dr.findElement(By.cssSelector(OR.getProperty("submitButton"))).click();
	System.out.println(dr.findElement(By.xpath(OR.getProperty("ConfirmationMessage"))).getText());
	
	
}
//register new user 
public static void doNewRegister(String sname, String lName,String nemail, String Pword ) throws InterruptedException{
	dr.findElement(By.xpath(OR.getProperty("RegisterLink"))).click();
	dr.findElement(By.cssSelector(OR.getProperty("name"))).sendKeys(sname);
	dr.findElement(By.xpath(OR.getProperty("loginname"))).sendKeys(lName);
	dr.findElement(By.xpath(OR.getProperty("password"))).sendKeys(Pword);
	dr.findElement(By.xpath(OR.getProperty("confirmPssword"))).sendKeys(Pword);
	dr.findElement(By.xpath(OR.getProperty("emailField"))).sendKeys(nemail);
	dr.findElement(By.cssSelector(OR.getProperty("femaleRadiobutton"))).click();
	System.out.println("Please enter security code you have 20 seconds");
	Thread.sleep(20000);
	//click business checkbox
	dr.findElement(By.xpath(OR.getProperty("agreewithBusinessCheckBox"))).click();
	//click submit button
	dr.findElement(By.cssSelector(OR.getProperty("submitButton"))).click();
	System.out.println(dr.findElement(By.xpath(OR.getProperty("ConfirmationMessage"))).getText());
	
}

public static void searchExistingUser(String existingUser){
	
	dr.findElement(By.xpath("")).click(); //click on user link in home page
	dr.findElement(By.xpath("")).sendKeys(existingUser);
	
	
}

public static  boolean isSkipped(String testCase){
	//System.out.println(xlRead.getRowCount("FirstSuite"));
	//System.out.println(xlRead.getCellData("FirstSuite", "TCID", 2));
	
	for (int rowNum=2; rowNum<= xlRead.getRowCount("FirstSuite");rowNum++ ){
		if(testCase.equals(xlRead.getCellData("FirstSuite", "TCID", rowNum))){
			if(xlRead.getCellData("FirstSuite", "Runmode", rowNum).equals("y"))
				
				return true;
			//System.out.println("run the test ");
				
			else
				return false;
				//System.out.println("skip the test ");
	
	
}
	
	}
	return false;	
  }

//get the data from xl file
public static Object[][]getData(String testName){
	//return test data
	//read test data from xls
	if(xlRead == null){
		xlRead = new Xls_Reader (System.getProperty("user.dir")+ "//src//com//cyclos//config//Book2.xlsx ");
		//C:\Users\bharathi.ramapatnam\Documents\PageFactory_Projects\JunitProject\src\com\cyclos\config\Book2.xlsx
		
	}
	/*
	int rows = xlRead.getRowCount(testName)-1;// -1 because first row is the column name
	if (rows<=0){
		Object[][] testData = new Object[1][0];
		return testData;
		}
		*/
	
	int rows = xlRead.getRowCount(testName);
	int cols = xlRead.getColumnCount(testName);
	System.out.println("Test Name ==== "+ testName);
	System.out.println("Number of Rows ==== "+ rows);
	System.out.println("Number of Columns ==== "+ cols);
	
	Object data [][] = new Object [rows-1][cols];
	
	for (int rowNum= 2; rowNum<rows; rowNum++){
		
	  for (int colNum= 0; colNum<cols; colNum++){
		data [rowNum-2][colNum]= xlRead.getCellData(testName, colNum, rowNum);
		
				
				}
	
	}
	return data;
}


//store screenshots
	public static void takeScreenShot(String fileName) {
		
		
		File scrFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	    try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+fileName+".jpg"));
		} catch (Throwable t) {
			
			t.printStackTrace();
		}
			
			
		}	   


}
	

