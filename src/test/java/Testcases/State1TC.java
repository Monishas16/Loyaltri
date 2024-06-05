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
import libraries.CommonFunctions;
import net.lightbody.bmp.proxy.jetty.html.Select;
import objects.LoginpageObj;
import objects.CountryObj;
import objects.StateObj;

import com.github.javafaker.Faker;
import libraries.CommonFunctions;

public class State1TC  extends CommonFunctions{
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
		StateObj.countryDD.click();
		
		for (int i = 0; i < StateObj.StatedropDown.size(); i++) {
	    	
	        if (StateObj.StatedropDown.get(i).getText().equalsIgnoreCase(properties.getProperty("country"))) {
	        	
	        	StateObj.StatedropDown.get(i).click();
	        	
	            break;
	    
	
	            
       }
	
	}
//create state		
		StateObj.State.sendKeys(properties.getProperty("state"));
		test.pass("state enterd  successfully");
		Thread.sleep(3000);

		StateObj.city.sendKeys(properties.getProperty("city1"));
		test.pass("city1 enterd  successfully");
		Thread.sleep(3000);

		StateObj.StateDesc.sendKeys(properties.getProperty("Description"));
		test.pass("Description enterd  successfully");
		Thread.sleep(3000);
		
		StateObj.StatesaveBtn.click();
		test.pass("Save button is clicked");
		Thread.sleep(5000);
		
//search
	
    	String name = properties.getProperty("search_box");
		System.out.println(name);
		
		
//		StateObj.StatesearchBox.click();
//		
//		StateObj.StatesearchBox.sendKeys(properties.getProperty("search_box"));
//		Thread.sleep(5000);
//
//        Assert.assertEquals(StateObj.StatesearchBox.getAttribute() , properties.getProperty("search_box"), "Search text mismatch");

//        
        
		
        
	String actCountryName=StateObj.stateDatatable.getText();
	if(actCountryName.equals(name)) { 		
		test.pass("New country displayed in data table.");
		}
	else {
            test.fail("<font color='red'>Create new Country failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());		}
     	 Thread.sleep(2000);
		
		StateObj.StatesearchBox.sendKeys(properties.getProperty("search_box"));
		test.pass("search the value  successfully");
		Thread.sleep(2000);
		
		
		StateObj.SelectOpt.click();
		test.pass("Click  the Option  successfully");
        Thread.sleep(3000);
        
		StateObj.OkBtn.click();
        Thread.sleep(3000);
        


        
        
        

//Update country		
        test.info("<b><font color = 'purple'>Test case-5 Verify the Update State functionality </b>");
        StateObj.StateeditBtn.click();
		test.pass("Edit button clicked");
		Thread.sleep(3000);
//		
		StateObj.State.sendKeys(Keys.CONTROL + "a");
//// Delete the selected text
		StateObj.State.sendKeys(Keys.DELETE);
//
         StateObj.State.clear();
		Thread.sleep(6000);
//		
//
//		StateObj.State.sendKeys(properties.getProperty("update_state"));
//		Thread.sleep(3000);
//		StateObj.city.sendKeys(Keys.CONTROL + "a");
//		StateObj.city.sendKeys(Keys.DELETE);
//		
//
		Thread.sleep(3000);
        StateObj.city.clear();
		StateObj.city.sendKeys(properties.getProperty("update_city"));
//		
		Thread.sleep(3000);
		StateObj.StateDesc.sendKeys(Keys.CONTROL + "a");
		StateObj.StateDesc.sendKeys(Keys.DELETE);
//		
		Thread.sleep(3000);
		StateObj.StateDesc.sendKeys(properties.getProperty("upd_Description"));
		test.pass("Update the state sucessfully");
		Thread.sleep(6000);
		StateObj.StatesaveBtn.click();

		
//delete the state
	
		
		test.info("<b><font color = 'purple'>Test case-6 check the delete button is displyed </b>");
		StateObj.StatesearchBox.sendKeys(properties.getProperty("search_box"));
		StateObj.StateDeleteOpt.click();
		test.pass("Delete button clicked.");
		
		String searchValue = properties.getProperty("search_box");
		boolean dataNotDeleted = verifyDataNotDeleted(searchValue); // Implement this method to verify if data is not deleted
		if (dataNotDeleted) { 
		    test.pass("Data not deleted. No button functionality working");
		} else {
		    test.fail("<font color='red'>No button click failed.</font>", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver, screenShot)).build());
		}

		StateObj.StateDeleteOpt.click();
		// Delete confirm button
		StateObj.StateConfirmOpt.click();


		

		
	
		
//	for (int i = 0; i < StateObj.stateDatatab.size(); i++) {
//	    	
//	       if (StateObj.stateDatatab.get(i).getText().equalsIgnoreCase(properties.getProperty("search_box"))) {
//	        	
//	        if (StateObj.stateDescab.get(i).getText().equalsIgnoreCase(properties.getProperty("search_box"))) {
//	        		
//	        		StateObj.ToggleBtn.get(i).click();
//	        		
////	        	StateObj.StateeditBtn.click();
//	        		
//	        		Thread.sleep(3000);
//	        	}
//	        	
//	        }
//	       break;
//	}
	}
private boolean verifyDataNotDeleted(String searchValue) {
	// TODO Auto-generated method stub
	return false;
}

//
//delete 
		
		
		

		
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
