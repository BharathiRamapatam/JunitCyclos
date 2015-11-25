package com.cyclos.roughWork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class links2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver ();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
		driver.navigate().to("https://demo.cyclos.org/#login");
List<WebElement> links = driver.findElements(By.xpath("//span"));
System.out.println(links.size());
	    	 
	    
	  
		
		
	}

}
