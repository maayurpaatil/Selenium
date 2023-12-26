package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import UtilityMethods.CommonMethods;

public class Homepage extends CommonMethods {
	
	private static WebDriver driver;
	
	public static void main(String[] args) {
		driver=Initialization();
		driver.get("https://www.google.com/");
		System.out.println( driver.getTitle());
		driver.close();
	}

}
