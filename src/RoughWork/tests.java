package RoughWork;


import java.io.File;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Tests.testBase;
import Util.TestUtil;

public class tests{

public static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
 driver = new FirefoxDriver ();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
driver.get("https://demo.cyclos.org/#login");

driver.findElement(By.cssSelector("input.inputField.medium")).sendKeys("demo");
//driver.findElement(By.xpath(OR.getProperty("password_field"))).clear();
driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234");
driver.findElement(By.xpath("//button[@type='button'] ")).click();
//Assert.assertEquals(welcomeDemo, );


Thread.sleep(5000);

String welcomeDemo = driver.findElement(By.xpath("//div[@class= 'pageSectionHeading']")).getText();
System.out.println(welcomeDemo);
takeScreenShot("AfterLogin");

/*
driver.findElement(By.xpath("//span[contains(text(),'User')]")).click();//click on user link in home page

driver.findElement(By.xpath("//input[@type='text' and @class = 'inputField large']")).sendKeys("user");//input user in the keyword box

driver.findElement(By.xpath("//button[ @type = 'button' and @class = 'actionButton']")).click();

//List<WebElement> searchRresult= driver.findElements(By.tagName("a"));

List<WebElement> searchResult = driver.findElements(By.xpath("//div[@class = 'tiledResultLabel']"));

System.out.println(searchResult.size());










//invalid username
/*
 *
driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234");
driver.findElement(By.xpath("//button[@type='button'] ")).click();

System.out.println(driver.findElement(By.xpath("//div[@class = 'notificationText']/ul")).getText());
System.out.println(driver.findElement(By.xpath("//div[@class = 'notificationText']/b")).getText());
driver.findElement(By.cssSelector("button.actionButton.notificationButton")).click();

//invalid password
driver.findElement(By.xpath("//input[@type='password']")).clear();
Thread.sleep(5000);
driver.findElement(By.cssSelector("input.inputField.medium")).sendKeys("demo");
driver.findElement(By.xpath("//button[@type='button']")).click();

System.out.println(driver.findElement(By.xpath("//div[@class ='notificationText']/ul")).getText());
//System.out.println(driver.findElement(By.xpath("//div[@class = 'notificationText']/b")).getText());


//invalid username and passowrd
driver.findElement(By.cssSelector("input.inputField.medium")).sendKeys("abx");
driver.findElement(By.xpath("//input[@type='password']")).sendKeys("8888");
driver.findElement(By.xpath("//button[@type='button']")).click();

Thread.sleep(5000);
System.out.println(driver.findElement(By.xpath("//div[@class = 'notificationText']")).getText());
*/



	}
	
	//store screenshots
public static void takeScreenShot(String fileName) {
				
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			    try {
					FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+fileName+".jpg"));
				} catch (Throwable t) {
					
					t.printStackTrace();
				}
 
}
}
