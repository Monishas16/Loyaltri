package Testcases;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import java.util.Properties;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import objects.CountryObj;
import objects. DocumentTypeObj;
import objects.StateObj;
import libraries.CommonFunctions;
import com.github.javafaker.Faker;
public class DocumentTypeTest extends CommonFunctions {
	static String screenShot;
	@BeforeSuite
	public void report() {
		
		report = new ExtentSparkReporter("Reports/DocumentType.html");    
		report.config().setReportName("Selenium Automation Report");
		reports = new ExtentReports();
		reports.attachReporter(report);
		reports.setSystemInfo("Application", "Loyaltri Product");
		reports.setSystemInfo("Module", "Masters");
		reports.setSystemInfo("Author", "Monisha");
		
	}
	
	
	@Test(priority=1)
	public void DocumentTypeTest()throws IOException{
		try {
			
			FileInputStream stream = new FileInputStream("config.properties");
			 
			Properties properties = new Properties();
			properties.load(stream);
			
			
			test=reports.createTest("<b><font color='Blue'>Testcases of DocumentType module</b></font>");
			/*
			 * Code for document type page navigation checking
			 */
			test.info("<b><font color='purple'>Testcase 1- Check the Document Type page is displayed </b></font>");
			PageFactory.initElements(driver,DocumentTypeObj.class);
			
// using action  mouse pointing
			
			Actions actions = new Actions(driver);
			actions.moveToElement(DocumentTypeObj.settings).build().perform();
			test.pass("The Setting option clicked");

			actions.moveToElement(DocumentTypeObj.masters).build().perform();
			test.pass("The Masters menu clicked");
			
			
			DocumentTypeObj.documentTypeMenu.click();
			test.pass("The Document Type button clicked");
			
			
			DocumentTypeObj.documentTypeHeading.isDisplayed();
			String documentTypeheading=DocumentTypeObj.documentTypeHeading.getText();
			test.pass("The Document Types page is displayed.The heading of the page is: "+ documentTypeheading);
			
		
			test.info("<b><font color='purple'>Testcase 2 - Check the user is able to Add new Document Type</b> </font>");
			DocumentTypeObj.createDocumentTypeBtn.click();
			test.pass("Create Document Type button is clicked");
			Thread.sleep(4000);
	
			 String actualHeading =DocumentTypeObj.createDocTypeOrg.getText().trim();
			 String expectedHeading = "Create Document Type";                //acutal heading
			 if (actualHeading.equals(expectedHeading)) {
		            test.pass("Heading is correctly displayed: " + actualHeading);
		        } else {
		            test.pass("Heading is not correctly displayed. Expected: " + expectedHeading + ", Actual: " + actualHeading);
		        }
			
	
			 
		
			 
			 
			    test.info("<b><font color = 'purple'>Test case-3 Verify if the Cancel button on the Create Country page is functioning correctly</b>");
			    DocumentTypeObj.documentCancelOpt.click();
				test.pass("Cancel Button is clicked.");
				DocumentTypeObj.createDocumentTypeBtn.click();
			    Thread.sleep(3000);
			 
				if(DocumentTypeObj.createDocumentTypeHead.isDisplayed()) {
					test.pass("Cancel button worked.Create DocumentType child window is closed.");
				}else {
		            test.fail("<font color='red'>The functionality of the cancel button did not execute as expected.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
				}
			 
				DocumentTypeObj.saveDocBtn.click();
			
				test.info("<b><font color = 'purple'>Test case-4 Verify whether the user can successfully create a new Document</b>");
				DocumentTypeObj.documentType.sendKeys(properties.getProperty("Document_Type"));
				test.pass("document type entred successfully");
				Thread.sleep(2000);
				
				DocumentTypeObj.description.sendKeys(properties.getProperty("DescriptionDoc"));
				test.pass("Document description entred successfully");
				Thread.sleep(2000);

				DocumentTypeObj.mantType.click();
				test.pass("The mandatory toggle has been activated");
				Thread.sleep(1000);

	
				DocumentTypeObj.ERToggle.click();
				test.pass("The Expiry Reminders  toggle has been activated");
				Thread.sleep(1000);

			
				DocumentTypeObj.saveDocBtn.click();
				test.pass("Save Button is Clicked");
				Thread.sleep(4000);
				
//search document
//				Thread.sleep(4000);

//				DocumentTypeObj.searchDoc.sendKeys("Document_Type");
//				Thread.sleep(6000);
				
				

	
			
				
				
			
		}catch(Exception E) {
			
		}
	}
 
		// TODO Auto-generated method stub
		
	

	/*
	 * Code for taking Screenshot
	 */
 
	public static String takeScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		screenShot = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp + ".png";
		File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotfile, new File(screenShot));
		return screenShot;
 
	}
	
	
	
	
	
	@AfterSuite
  	public void reportflush() {
   		reports.flush();
   	}
	@AfterTest
	public void close() {
		driver.close();
	}

	
}
 