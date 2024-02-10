package UtilityMethods;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportBase {

	static ExtentTest test;
	static ExtentReports reports;

	public static void StartReport() {
		reports = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/Spark.html");
		reports.attachReporter(spark);

		reports.setSystemInfo("Host Name", "SoftwareTestingMaterial");
		reports.setSystemInfo("Environment", "Production");
		reports.setSystemInfo("User Name", "Rajkumar SM");
		spark.config().setDocumentTitle("Amazon Automation Report");
		spark.config().setReportName("Report");
	}

	public static void CreateTest(String MethodName, String Description) {

		reports.createTest(MethodName, Description);
	}

	public static void EndReport() {
		reports.flush();
	}

	@AfterMethod
	
	  public static void LogTestcaseStatusToExtentReport(ITestResult result) {
	 
	  if(result.getStatus() == ITestResult.FAILURE) {
	  test.log(Status.FAIL,result.getThrowable());
	  test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").
	  build()); } else if(result.getStatus() == ITestResult.SUCCESS) {
	  test.log(Status.PASS, result.getTestName()); } else { test.log(Status.SKIP,
	  result.getTestName()); } }
	 

	public static String CaptureScreenshot(WebDriver driver) throws IOException {
		String FileSeparator = System.getProperty("file.separator");
		String Extent_report_path = "." + FileSeparator + "Reports";
		String ScreenshotPath = Extent_report_path + FileSeparator + "screenshots";

		String src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		String screenshotName = "screenshot" + Math.random() + ".png";
		String screenshotpath = ScreenshotPath + FileSeparator + screenshotName;

		// FileUtils.copyFile(src,new File(screenshotpath));
		return "." + FileSeparator + "screenshots" + FileSeparator + screenshotName;

	}

}
