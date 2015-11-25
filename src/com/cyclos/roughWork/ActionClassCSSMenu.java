package com.cyclos.roughWork;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ActionClassCSSMenu {
	 public static WebDriver driver;
	/*This script does not work for chrome. This is a known bug. use javaScript
	 * executor instead.
	 * 
	 */

//http://seleniumeasy.com/selenium-tutorials/mouse-hover-using-javascriptexecutor

	 public static void main(String[] args) throws InterruptedException {
		
		
		 String browser = "Chrome";
		  
			if(browser.equals("Firefox")){
				 driver = new FirefoxDriver ();
			}else if(browser.equals("Chrome")){
				System.setProperty("webdriver.chrome.driver","C:\\Users\\bharathi.ramapatnam\\Downloads\\chromedriver_win32\\chromedriver.exe");
			     driver= new ChromeDriver();
				
			}else if(browser.equals("IE")){
				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();					
				caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);					
				System.setProperty("webdriver.ie.driver", "C:\\Users\\bharathi.ramapatnam\\Downloads\\IEDriverServer_Win32_2.48.0\\IEDriverServer.exe");	
			//"C:\\Users\\bharathi.ramapatnam\\Documents\\Selenium Jars\\IEDriverServer.exe");
			    driver = new InternetExplorerDriver();
			}
		
		driver.get("http://www.toolsqa.com/selenium-webdriver/c-sharp/download-and-install-visual-studio/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//*[@id="main-nav"]/li[9]/ul/li[4]/a/span
		/*
		
		if(browser.equals("Firefox")){
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		 
        action.moveToElement(element).build().perform();
		}else if(browser.equals("Chrome")){
		element.click();	
		}else {
			element.click();	
		}
		*/
		WebElement element = driver.findElement(By.xpath("//*[@id='main-nav']/li[9]"));
		
		mouseHoverJScript(element);
		
		
	}

		
		
		
	
	public static boolean isElementPresent(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed()
					|| element.isEnabled())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		} catch (StaleElementReferenceException e) {
			flag = false;
		}
		return flag;
	}
	
	public static void mouseHoverJScript(WebElement HoverElement) {
		try {
			if (isElementPresent(HoverElement)) {
				
				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				
				((JavascriptExecutor) driver).executeScript(mouseOverScript,
						HoverElement);

			} else {
				System.out.println("Element was not visible to hover " + "\n");

			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + HoverElement
					+ "is not attached to the page document"
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + HoverElement + " was not found in DOM"
					+ e.getStackTrace());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while hovering"
					+ e.getStackTrace());
		}
	}
}
