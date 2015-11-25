package com.cyclos.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.cyclos.datatable.Xls_Reader;

public class testBase {
	
	//initialise the property file
	public static Properties CONFIG = null;
	public static Properties OR = null;
	public static WebDriver dr = null;
	public static  EventFiringWebDriver driver = null;
	public static boolean isLoggedin = false;
	public static  Xls_Reader xlRead = null;
	
	
	
public void initialise() throws IOException{
	
	
	
if(dr == null){
//Initialise the confing file
		CONFIG = new Properties();
		FileInputStream fis = new FileInputStream (System.getProperty("user.dir")+"//src//com//cyclos//config//config.properties");
		CONFIG.load(fis);
		//C:\Users\bharathi.ramapatnam\Documents\PageFactory_Projects\JunitProject\src\com\cyclos\config\config.properties
		
		
//Initialise the or file
		OR= new Properties();
	    FileInputStream fn = new FileInputStream (System.getProperty("user.dir")+"//src//com//cyclos//config//or.properties");
		OR.load(fn);
		
		// initialise the xls reader and sheet 
					xlRead = new Xls_Reader (OR.getProperty("xlsReaderPath"));
			//xlRead = new Xls_Reader("C://Users//bharathi.ramapatnam//Documents//Selenium Excels//Book2.xlsx");
					//C://Users//bharathi.ramapatnam//Documents//Selenium Excels//Book2.xlsx
		
		
	
	
//initialise browser
	if(CONFIG.getProperty("browser").equals("Firefox")){
		 dr = new FirefoxDriver ();
	}else if(CONFIG.getProperty("browser").equals("Chrome")){
		System.setProperty("webdriver.chrome.driver",CONFIG.getProperty("chromedriverexe"));
	     dr= new ChromeDriver();
		
	}else if(CONFIG.getProperty("browser").equals("IE")){
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();					
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);					
		System.setProperty("webdriver.ie.driver", CONFIG.getProperty("ieDriverexe"));					
	    dr = new InternetExplorerDriver();
	}
	
	//driver = new EventFiringWebDriver(dr);
	dr.manage().window().maximize();
	dr.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	dr.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
}
	
	}
/*	

public static WebElement getObject(String xpathval){
	try {
		return dr.findElement(By.xpath(xpathval));
	} catch (Throwable t) {
		// TODO Auto-generated catch block
	   return null;
	}
	

	}
public static WebElement getCss(String cssval){
	try {
		return dr.findElement(By.xpath(cssval));
	} catch (Throwable t) {
		// TODO Auto-generated catch block
		return null;
	}
	
*/	
}	
	
	


