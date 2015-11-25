package com.cyclos.roughWork;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cyclos.util.TestUtil;

public class linkTest {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver dr = null;
	
		dr = new FirefoxDriver ();
		dr.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		dr.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		dr.navigate().to("https://demo.cyclos.org/#login");
		
	/*
		//String winHandleBefore = driver.getWindowHandle(); 
		
		List<WebElement> elements = driver.findElements(By.xpath("html/body/div[4]/div/div/div/div/div/div[5]/div/a"));
		
		System.out.println(elements.size());
		
		for(int i=0;i<elements.size();i++)
	        System.out.println(elements.get(i).getAttribute("href"));
		
		
		for(int i=0;i<elements.size();i++){
		
	        elements.get(i).click();
	       
		}
		
		// prints how many windows are open
		Set<String> winIds = driver.getWindowHandles();
		System.out.println("Total browsers-> "+winIds.size());
		Iterator<String> it= winIds.iterator();
		System.out.println(it.next());
		
	String l = "html/body/div[4]/div/div/div/div/div/div[5]/div/a[";
		String b = "]/img";
		
		for(int i=1; i<=3 ;i++){
			
			System.out.println(driver.findElement(By.xpath(l + i + b)).getTagName());
			
		*/
		
		
		
	dr.findElement(By.xpath("html/body/div[4]/div/div/div/div/div/div[5]/div/a[1]/img")).click();
	// prints how many windows are open
			Set<String> winIds = dr.getWindowHandles();
			System.out.println("Total browsers-> "+winIds.size());// this should print 2
			Iterator<String> it= winIds.iterator();
			System.out.println(it.next());
			System.out.println(it.next());
			String mainWindow = it.next();
			String facebookWindow = it.next();
//switch to facebook page
			dr.switchTo().window(facebookWindow);
	
			System.out.println(dr.getCurrentUrl());
			
			dr.close();
			dr.switchTo().window(mainWindow);
			/*
// now find and click on twitter link
			
			dr.findElement(By.xpath("html/body/div[4]/div/div/div/div/div/div[5]/div/a[2]/img")).click();// twitter
			System.out.println("Total browsers-> "+winIds.size());
			
			
			//String twitterWindow = it.next();
			//switch to twitter
			//dr.switchTo().window(twitterWindow);
			System.out.println(dr.getCurrentUrl());// can you assert functions
			
			dr.close();
			dr.switchTo().window(mainWindow);
			
			
			
//now find youTube link
			dr.switchTo().window(mainWindow);
			dr.findElement(By.xpath("html/body/div[4]/div/div/div/div/div/div[5]/div/a[2]/img")).click();// twitter
			
			String youtubeWindow = it.next();
			//switch to twitter
			dr.switchTo().window(youtubeWindow);
			System.out.println(dr.getCurrentUrl());
			
			dr.close();
			dr.switchTo().window(mainWindow);
			*/
			
			
			
			
			
			
			
			
	
		
	}	
	

	
	
}	
		
		
		
			


