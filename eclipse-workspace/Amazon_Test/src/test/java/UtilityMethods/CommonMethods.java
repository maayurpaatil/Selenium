
package UtilityMethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.google.common.util.concurrent.FluentFuture;

public class CommonMethods 
{
	
	public static WebDriver driver;
	
	 public CommonMethods(WebDriver driver) {
	        CommonMethods.driver = driver;
	 }
	
	public static WebDriver Initialization()
	{
		DesiredCapabilities Capabilities=new DesiredCapabilities();
		Capabilities.setBrowserName("chrome");
		Capabilities.acceptInsecureCerts();
		
		ChromeOptions options=new ChromeOptions();
		
		options.addArguments("--incognito","--start-maximized");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-popup-blocking");
		
		/*
		 * options.addArguments("test-type");
		 * options.addArguments("window-size=1920,1080");
		 * options.addArguments("enable-precise-memory-info");
		 * options.addArguments("disable-default-apps");
		 * options.addArguments("test-type=browser");
		 */
		    
		options.merge(Capabilities);
		
		WebDriver driver=new ChromeDriver(options);
		return driver;	
	}
	
	public static WebElement WaitUntillExpectedConditions(String Xpath,boolean IsClickable,boolean IsVisible,boolean IsPresent)
	{
		WebElement element=null;
				
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		if(IsClickable)
		    element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)));
		if(IsVisible)
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
		if(IsPresent)
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
		return element;	
	}

	public static void takeScreenshotAtEndOfTest() throws IOException 
	{
		TakesScreenshot ScreenShot=(TakesScreenshot)driver;
		/*Get a screenshot using getScreenshotAs method*/
		File ScreenShotFile = ScreenShot.getScreenshotAs(OutputType.FILE);
		/*Move image file to new destination*/
		File DestFile=new File(System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png");
		/*Copy file at destination*/
		FileUtils.copyFile(ScreenShotFile, DestFile);
		
	}
	
	public void FluentWait(String Xpath)
	{
		Wait<WebDriver> wait1 = new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(Exception.class);
		wait1.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath( Xpath));
				}});
		
		
	}
}
