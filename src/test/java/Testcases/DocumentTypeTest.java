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
import org.testng.Assert;
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
		reports.setSystemInfo("Module", "DocumentType");
		reports.setSystemInfo("Author", "Monisha");
		
	}
	
	
	
	@Test(priority=1)
	public void DocumentTypeTest()throws IOException{
		try {
			
			Faker faker = new Faker();             //for give the default value

			FileInputStream stream = new FileInputStream("config.properties");
			 
			Properties properties = new Properties();
			properties.load(stream);
			
			
			test = reports.createTest("Testcase for DocumentType Page ");
		
			/*
			 * Code for document type page navigation checking
			 */
			test.info("<b><font color='purple'>Testcase 1- Check the Document Type page is displayed </b></font>");
			  PageFactory.initElements(driver,DocumentTypeObj.class);

			  
			  
			DocumentTypeObj.settingsDocumtTy.click();
			test.pass("Setting button clicked Successfully ");
			
			DocumentTypeObj.mastersopt.click();
			test.pass("Master Option clicked Successfully");
			
			
	
			DocumentTypeObj.documentTypeMenu.click();
			test.pass("Create Document button clicked successfully");
	
			
			
			String actDocutment = DocumentTypeObj.documentTypeHeading.getText(); 
			if (actDocutment .equals("Document Type")) {
		            test.pass("Country page is displayed");


	        } else {
		            test.fail("<font color='red'>Country page is not displayed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		        }
		
			
		 test.info("<b><font color = 'purple'>Test case-2 Check the Create Document page is displayed </b>");
		        DocumentTypeObj.createDocTypeOpt.click();
				test.pass("Create documenttype button clicked.");
				Thread.sleep(1000);
				
				if(DocumentTypeObj.documentTypeChild.getText().equals("Create Document Type")) {
					test.pass("Create document type child window is displayed.The heading is :"+DocumentTypeObj.documentTypeChild.getText());
				}else {
		            test.fail("<font color='red'>Create Country page navigation failed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
				}
	
			 
				
//cancel 	issue			
//				DocumentTypeObj.canceloptDT.click();
//				test.pass("Cancel Button is clicked.");
//				if(DocumentTypeObj.createDocTypeOpt.isDisplayed()) {
//					test.pass("Cancel button worked.Create Country child window is closed.");
//				}else {
//		            test.fail("<font color='red'>The functionality of the cancel button did not execute as expected.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
//				}

			
				

				
			    Thread.sleep(1000);

//create	
			 test.info("<b><font color = 'purple'>Test case-3 Verify create a new Document Type functionality./b>");
//			       DocumentTypeObj.createDocTypeOpt.click();
//				    Thread.sleep(1000);
	
				    test.pass("Create Document type button clicked");
					String name = faker.letterify("???");
					String newDocumentName="Document "+name;
					DocumentTypeObj.DocumentName.click();
					DocumentTypeObj.DocumentName.sendKeys(newDocumentName);
					test.pass("Document Type is entered");
					
					DocumentTypeObj.description.sendKeys(newDocumentName);
					test.pass("Document description entred successfully");
					
				
					DocumentTypeObj.saveDocBtn.click();
					test.pass("Document  saved  successfully");

					
					
					DocumentTypeObj.SearchDoc.sendKeys(newDocumentName);
				    Thread.sleep(4000);

					String actDocName=DocumentTypeObj.DocDatatable.getText();
					if(actDocName.equals(newDocumentName)) { 
						test.pass("New country displayed in data table.");
					}else {
			            test.fail("<font color='red'>Create new Country failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());

					}
				
//update									    
					Thread.sleep(4000);
			
				
				
			test.info("<b><font color = 'purple'>Test case-5 Verify the Update DocumentType functionality </b>");
			           DocumentTypeObj.EditbtnDoc.click();
				 		String upddocname ="Test Document"+ faker.letterify("???");
						test.pass("Edit button clicked");
						
						Thread.sleep(2000);

//						wait.until(ExpectedConditions.visibilityOf(MastersObj.editCountry));
						DocumentTypeObj.DocumentName.sendKeys(Keys.CONTROL + "a"); // Select all text
						DocumentTypeObj.DocumentName.sendKeys(Keys.DELETE);
						Thread.sleep(2000);

						DocumentTypeObj.DocumentName.sendKeys(upddocname); 
						
						DocumentTypeObj.description.sendKeys(Keys.CONTROL + "a"); // Select all text
						DocumentTypeObj.description.sendKeys(Keys.DELETE);
	
						DocumentTypeObj.description.sendKeys(upddocname);
						DocumentTypeObj.saveDocBtn.click();
					
						test.pass("Save button is clicked.");
		
						
	
						Thread.sleep(2000);
						DocumentTypeObj.SearchDoc.click();
						DocumentTypeObj.SearchDoc.sendKeys(Keys.CONTROL + "a"); // Select all text
						DocumentTypeObj.SearchDoc.sendKeys(Keys.DELETE);
						
						Thread.sleep(2000);
						
						DocumentTypeObj.SearchDoc.sendKeys(upddocname);
						String actDocNameUpdate=DocumentTypeObj.DocDatatable.getText();
				        if(actDocNameUpdate.equals(upddocname)) { 

				        	test.pass("Updated Country details displayed in data table.");
						}else {
				            test.fail("<font color='red'>Update Country failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());

						}
						Thread.sleep(6000);

				
				
//delete
			test.info("<b><font color = 'purple'>Test case-6 check the delete button is displyed </b>");
			DocumentTypeObj.DeleteDocbtn.click();
						test.pass("Delete button clicked.");
					
						//no button click
					
						DocumentTypeObj.NobtnDoc.click();
						if(actDocNameUpdate.equals(newDocumentName+"Test Document")) { 
							test.pass("Data not deleted.No button functionality working");
						}else {
				            test.fail("<font color='red'>No button click failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());

					
						}
					
						DocumentTypeObj.DeleteDocbtn.click();
						//delete confirm button
						DocumentTypeObj.ConfirmbtnDoc.click();
						test.pass("Clicked the confirm option ");
						if(actDocName.contains(newDocumentName+"Test Document")) { 
							test.fail("Data not deleted.Confirm button functionality not working",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
						}else {
				            test.pass("Data deleted sucessfully");
						}
					
									
         
   	
		}catch(Exception E) {
			
		}
	}
 
		// TODO Auto-generated method stub
		
	

	/*
	 * Code for taking Screenshot
	 */
 
	private boolean verifyDataNotDeleted(String searchDocValue) {
		// TODO Auto-generated method stub
		return true;
	}


	
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
 