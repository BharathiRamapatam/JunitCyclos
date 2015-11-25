package com.cyclos.roughWork;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class llinks3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver dr = null;

		dr = new FirefoxDriver ();
		dr.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		dr.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		dr.navigate().to("https://demo.cyclos.org/#login");
		
		
  List<WebElement> elements = dr.findElements(By.xpath("html/body/div[4]/div/div/div/div/div/div[5]/div/a"));
		
		System.out.println(elements.size());
		
		for(int i = 0;i<elements.size();i++){
			Thread.sleep(5000);
		   
		    elements.get(i).click();
		    System.out.println(elements.get(i).getAttribute("href"));
		    
		}   
		
		
		Set<String> winIds = dr.getWindowHandles();
		System.out.println("Total browsers-> "+winIds.size());
		Iterator<String> it= winIds.iterator();
	
		
		String main = it.next();
		String facebook = it.next();
		String twitter = it.next();
		String youtube = it.next();
// facebook
		dr.switchTo().window(facebook);
        //get screenshot
	   dr.close();
	   dr.switchTo().window(main);
//twitter
		dr.switchTo().window(twitter);
        //take screen shot		
		dr.close();
		dr.switchTo().window(main);
//youtube
		dr.switchTo().window(youtube);
		//take screnshot
		dr.close();
		dr.switchTo().window(main);
		
		
		
		
		
		}
		
		

		
	
	
	
	}
		
		
		
		
	
	


