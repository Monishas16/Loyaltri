package Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
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
import libraries.CommonFunctions;
import net.lightbody.bmp.proxy.jetty.html.Select;
import objects.LoginpageObj;
import objects.CountryObj;
import objects.StateObj;

import com.github.javafaker.Faker;

import libraries.CommonFunctions;

public class StateTest  extends CommonFunctions{
	static String screenShot;

	@BeforeSuite

	
	public void report() {
		report = new ExtentSparkReporter("Reports/state.html");
		reports = new ExtentReports();
		reports.attachReporter(report);
		Faker faker = new Faker();
 
		reports.setSystemInfo("<b>Application<b>", "<b>Loyaltri<b>");
		reports.setSystemInfo("<b>Module<b>", "<b>Monisha<\b>");
		reports.setSystemInfo("<b>Author<b>", "<b> Cordova Testing Team<b>");

	}
 
	
	@Test(priority = 1)
	public void eventlist() throws Exception {
		Faker faker = new Faker();

		FileInputStream stream = new FileInputStream("config.properties");
		 
		Properties properties = new Properties();
		properties.load(stream);

	
 		test = reports.createTest("Testcase for State Page ");
		PageFactory.initElements(driver,StateObj.class);
		test.info("<b><font color = 'purple'>Test case-1 Verify the state page is displayed </b>");
		StateObj.settings.click();
		test.pass("Settings Menu clicked");
		StateObj.masters.click();
		test.pass("Master Menu Clicked");
		StateObj.state.click();
		test.pass("Country option clicked");
		String actCountry = StateObj.StateHeading.getText(); 
		if (actCountry.equals("State")) {
	            test.pass("State page is displayed");

	        } else {
	            test.fail("<font color='red'>State page is not displayed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
	 
	        }
				
		
		
		
		test.info("<b><font color = 'purple'>Test case-2 Check the Create State page is displayed </b>");
		StateObj.createState.click();
		test.pass("Create State button clicked.");
		Thread.sleep(3000);
		
	
		
		if(StateObj.createStateHeading.getText().equals("Create State")) {
			test.pass("Create Country child window is displayed.The heading is :"+StateObj.createStateHeading.getText());
		}else {
            test.fail("<font color='red'>Create Country page navigation failed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		}
		
	
		
	
		
		
		
	    test.info("<b><font color = 'purple'>Test case-3 Verify if the Cancel button on the State  page is functioning correctly</b>");
		StateObj.StatecancelOpt.click();
		test.pass("Cancel Button is clicked.");
		
		if(StateObj.createState.isDisplayed()) {
			test.pass("Cancel button worked.Create Country child window is closed.");
		}else {
            test.fail("<font color='red'>The functionality of the cancel button did not execute as expected.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		}
		
		
	
		
		test.info("<b><font color = 'purple'>Test case-4 Verify whether the user can successfully create a new State</b>");
	    StateObj.createState.click();
		test.pass("Create country button clicked");
	
		
//		country selection dropdown
		test.info("<b><font color = 'purple'>Test case-5 Verify  the user can Click the dropdown </b>");
	
//		StateObj.StatedropDown.click();
//		test.pass("Dropdown clicked");
		
		
//		StateObj.StatedropDown.sendKeys(properties.getProperty("country"));

		
		
		
		
		

//  Choose Country
		
		StateObj.StateDropDown.click();
		test.pass("Country Selected");
		String name = faker.letterify("???");
		String newStateName="State "+name;
		StateObj.State.sendKeys(newStateName);
		StateObj.city.sendKeys(newStateName);
		test.pass("Country Code is entered");
		StateObj.StateDesc.sendKeys(newStateName);
		test.pass("Country Description is entered");
		StateObj.StatesaveBtn.click();
		test.pass("Save button is clicked");
		//wait.until(ExpectedConditions.visibilityOf(MastersObj.searchBox));
		//wait.until(ExpectedConditions.visibilityOf(MastersObj.Action));
		Thread.sleep(3000); 
		

		
		
		
		
		
		
		
		StateObj.StatesearchBox.click();
		StateObj.StatesearchBox.sendKeys(Keys.CONTROL + "a"); // Select all text
		StateObj.StatesearchBox.sendKeys(Keys.DELETE);
		StateObj.StatesearchBox.sendKeys(newStateName);
		String actCountryName=StateObj.stateDatatable.getText();
		if(actCountryName.equals(newStateName)) { 
			test.pass("New country displayed in data table.");
		}else {
            test.fail("<font color='red'>Create new Country failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());

		}


		
		
		//Update Country
        test.info("<b><font color = 'purple'>Test case-5 Verify the Update State functionality </b>");
 		StateObj.StateeditBtn.click();
		test.pass("Edit button clicked");
//		wait.until(ExpectedConditions.visibilityOf(MastersObj.editCountry));
		Thread.sleep(3000);
		StateObj.State.sendKeys("Test");
		StateObj.city.sendKeys("Test");
		StateObj.StateDesc.sendKeys("Test");
		StateObj.StatesaveBtn.click();
		test.pass("Save button is clicked.");
		//wait.until(ExpectedConditions.visibilityOf(MastersObj.searchBox));

		

		
		
		Thread.sleep(2000);
		String ExpectedState=newStateName+"Test";
		StateObj.StatesearchBox.click();
		StateObj.StatesearchBox.sendKeys(Keys.CONTROL + "a"); // Select all text
		StateObj.StatesearchBox.sendKeys(Keys.DELETE);
		StateObj.StatesearchBox.sendKeys(ExpectedState);
		String actCountryNameUpdate=StateObj.stateDatatable.getText();
        if(actCountryNameUpdate.equals(ExpectedState)) { 
			test.pass("Updated Country details displayed in data table.");
		}else {
            test.fail("<font color='red'>Update Country failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());

		}
	
        
        
    
      
       
                Thread.sleep(3000);
        
	
        
        
		  //Delete Country
				test.info("<b><font color = 'purple'>Test case-6 check the delete button is displyed </b>");
		        StateObj.StatesearchBox.click(); 
		        StateObj.StatesearchBox.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			    StateObj.StatesearchBox.sendKeys(ExpectedState);
				StateObj.StateDeleteOpt.click();
				test.pass("Delete button clicked.");

				//no button click
				StateObj.StateNoOpt.click();
				if(actCountryNameUpdate.equals(newStateName+"Test")) { 
					test.pass("Data not deleted.No button functionality working");
				}else {
		   
					test.fail("<font color='red'>No button click failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());

				}
				
				StateObj.StateDeleteOpt.click();
				//delete confirm button
				StateObj.StateConfirmOpt.click();
				test.pass("Clicked the confirm option ");
				if(actCountryNameUpdate.contains(newStateName+"Test")) { 
					test.fail("Data not deleted.Confirm button functionality not working",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
				}else {
		            test.pass("Data deleted sucessfully");
				}
		
		
		
				
				
				
		
	}

	@AfterSuite
	public void reportflush() {
		reports.flush();
	}
 
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
	 
 
	@AfterTest
	public void close() {
		driver.close();
	
	}
}
 

	
	

	
	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


