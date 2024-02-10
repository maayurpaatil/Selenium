
package UtilityMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass extends OneTimeSetup
{
	
	public static WebDriver driver;
	
	 /*
		 * options.addArguments("test-type");
		 * options.addArguments("window-size=1920,1080");
		 * options.addArguments("enable-precise-memory-info");
		 * options.addArguments("disable-default-apps");
		 * options.addArguments("test-type=browser");
		 */
	public static void Initialization()
	{
		DesiredCapabilities Capabilities=new DesiredCapabilities();
		Capabilities.setBrowserName("chrome");
		Capabilities.acceptInsecureCerts();
		
		ChromeOptions options=new ChromeOptions();
		
		options.addArguments("--incognito","--start-maximized");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-popup-blocking");

		options.merge(Capabilities);
		
	    driver=new ChromeDriver(options);
		
		driver.get(ConfigurationProperties.url);
	}
	public static void DisposeDriver()
	{
		if (!driver.equals(null)) {
			driver.close();
			driver.quit();
		}

	}
	public static void TakeScreenshotAtEndOfTest() throws IOException 
	{
		TakesScreenshot ScreenShot=(TakesScreenshot)driver;
		/*Get a screenshot using getScreenshotAs method*/
		File ScreenShotFile = ScreenShot.getScreenshotAs(OutputType.FILE);
		/*Move image file to new destination*/
		File DestFile=new File(System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png");
		/*Copy file at destination*/
		FileUtils.copyFile(ScreenShotFile, DestFile);
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

	public void FluentWait(String Xpath)
	{
		Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(Exception.class);
		wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath( Xpath));
				}});
	}
	
	public void ConfigFileReader() {
		String configFilePath = System.getProperty("user.dir") + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "TestData" + File.separator + "config.properties";

		Properties prop = new Properties();
		try (FileInputStream fis = new FileInputStream(configFilePath)) {
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}
}
