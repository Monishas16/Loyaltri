package Testcases;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import libraries.CommonFunctions;
import objects.LoginpageObj;


public class Logintestcase  extends CommonFunctions{
	@BeforeSuite
	public void report() {
		report = new ExtentSparkReporter("Reports/loginpage");
		reports = new ExtentReports();
		reports.attachReporter(report);
 
		
		reports.setSystemInfo("<b>Application<b>", "<b>Loyaltri<b>");
		reports.setSystemInfo("<b>Module<b>", "<b>Monisha<\b>");
		reports.setSystemInfo("<b>Author<b>", "<b> Cordova Testing Team<b>");
	}
 
	@Test(priority = 0)
	public void eventlist() throws Exception {
		

		
		test = reports.createTest("Testcase for Loginpage ");
		PageFactory.initElements(driver, LoginpageObj.class);
		node = test.createNode("<b>Test case for view deatails </b>");
//		Thread.sleep(3000);
		
		
		
		
		
		
		
		
		

		
		
	}

	@AfterSuite
	public void reportflush() {
		reports.flush();
	}
 
	public static String takeScreenshot(WebDriver driver, String screenshotName) throws Exception {
 
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(0));
		String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp
				+ ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshot, new File(destination));
 
		return destination;
 
	}
 
	@AfterTest
	public void close() {
		driver.close();
	
	}
}
 

	
	
	
	


