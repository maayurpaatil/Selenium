package TestClasses;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import UtilityMethods.CommonMethods;

public class Homepage extends CommonMethods {
	
	public Homepage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static WebDriver driver;
	
	 @Test
	public static void main12(){
		driver=Initialization(); 
		driver.get("https://www.google.com/");
		System.out.println( driver.getTitle());
		driver.close();
	}

}
