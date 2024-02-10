package UtilityMethods;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class OneTimeSetup {

	@BeforeSuite
	public void BeforeSuite() {
		ExtentReportBase.StartReport();
		BaseClass.Initialization();
	}

	@AfterSuite
	public void AfterSuite() {
		ExtentReportBase.EndReport();
		BaseClass.DisposeDriver();
	}

	@BeforeTest
	public void BeforeTest() {
		
	}
	
	@AfterTest
	public void AfterTest() {
		
	}
	
	@BeforeMethod
	public void BeforeMethod(Method method) {
		ExtentReportBase.CreateTest(method.getName(),"");
	}

	@BeforeClass
	public void BeforeClass() {

	}

	@AfterMethod
	public void AfterMethod() {

	}

	@AfterClass
	public void AfterClass() {

	}

	
	
}
