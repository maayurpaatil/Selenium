package UtilityMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CommonMethods {
	
	
	public static WebDriver driver;
	
	public static WebDriver Initialization()
	{
		DesiredCapabilities Capabilities=new DesiredCapabilities();
		Capabilities.setBrowserName("firefox");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito","--start-maximized");
		options.merge(Capabilities);
		
		WebDriver driver=new ChromeDriver(options);
		return driver;	
	}

}
