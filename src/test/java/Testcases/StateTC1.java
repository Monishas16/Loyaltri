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
import org.openqa.selenium.interactions.Actions;
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

public class StateTC1  extends CommonFunctions{
	static String screenShot;
@BeforeSuite

	

	public void report() {
	report = new ExtentSparkReporter("Reports/State.html");    
	report.config().setReportName("Selenium Automation Report");
	reports = new ExtentReports();
	reports.attachReporter(report);
	reports.setSystemInfo("Application", "Loyaltri Product");
	reports.setSystemInfo("Module", "State");
	reports.setSystemInfo("Author", "Monisha");

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
	
	
	 Actions actions = new Actions(driver);
	 actions.moveToElement(StateObj.settingsState).build().perform();
     test.pass("Settings Menu clicked Successfully");
 
	  StateObj.mastersState.click();
      test.pass("Master Menu Clicked Successfully");
    
	 StateObj.state.click();
	 test.pass("State option clicked Successfully");
	
	 String actCountry = StateObj.StateHeading.getText(); 
	 if (actCountry.equals("State")) {
            test.pass("State page is displayed");

        } else {
            test.fail("<font color='red'>State page is not displayed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
 
        }
			

 test.info("<b><font color = 'purple'>Test case-2 Check the Create State page is displayed </b>");
	StateObj.createState.click();
	test.pass("Create State button clicked Successfully.");
	Thread.sleep(1000);
	
//create state child window	
	
	if(StateObj.createStateHeading.getText().equals("Create State")) {
		test.pass("Create Country child window is displayed.The heading is :"+StateObj.createStateHeading.getText());
	}else {
        test.fail("<font color='red'>Create Country page navigation failed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
	}
	
	StateObj.StatecancelBtn.click();
	test.pass("Cancel button clicked Successfully.");

	StateObj.createState.click();
	test.pass("Create State button clicked Successfully.");
	
	
	StateObj.countryDD.click();
	test.pass("State DropDown clicked Successfully.");
	
//country selection dropdown
		StateObj.countryDD.click();
		
		for (int i = 0; i < StateObj.StatedropDown.size(); i++) {
	    	
	        if (StateObj.StatedropDown.get(i).getText().equalsIgnoreCase(properties.getProperty("country"))) {
	        	
	        	StateObj.StatedropDown.get(i).click();
	        	
	            break;     
	            
       }
	
	}
//create state		
		
			String name = faker.letterify("???");
			String newStateName="State "+name;
//			CountryObj.countryName.click();
			StateObj.State.sendKeys(newStateName);
			test.pass("Country Name is entered");
			Thread.sleep(2000);
			StateObj.city.sendKeys(newStateName);
			test.pass("Country Code is entered");
			StateObj.StateDesc.sendKeys(newStateName);
			test.pass("Country Description is entered");
			StateObj.StatesaveBtn.click();
			test.pass("Save button is clicked");
			Thread.sleep(1000);
		
			

			String createNameState = StateObj.StateDatatable.getText();
			if (createNameState.equals("state")) {
		            test.pass("State displayed in data table");
		        } else {
		
		       test.fail("<font color='red'>Create State failed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());       
		
		        }
			Thread.sleep(2000);
			
		
			
			
			
			
			

		
		
//search
			
			StateObj.StatesearchBox.click();
			StateObj.StatesearchBox.sendKeys(Keys.CONTROL + "a"); // Select all text
			StateObj.StatesearchBox.sendKeys(Keys.DELETE);
			StateObj.StatesearchBox.sendKeys(newStateName);
			String actCountryName=StateObj.StateDatatable.getText();
////			if(actCountryName.equals(newStateName)) { 
////				test.pass("New country displayed in data table.");
////			}else {
////	            test.fail("<font color='red'>Create new Country failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
////
////			}
//			
			
			
			
			
			
			
			
			
			
			
			
			
	
//		String createNameState = StateObj.StateDatatable.getText();
//		if (createNameState.equals("state")) {
//	            test.pass("State displayed in data table");
//
//	            
//	        } else {
//	
//	
//	   
//	       test.fail("<font color='red'>Create State failed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());       
//	
//	        }
//		Thread.sleep(2000);
         
//		
//		StateObj.StatesearchBox.sendKeys(properties.getProperty("state"));
//		test.pass("search the value  successfully");
//		Thread.sleep(1000);

//update
			test.info("<b><font color = 'purple'>Test case-5 Verify the Update State functionality </b>");
			StateObj.StateeditBtn.click();
//			Thread.sleep(1000);

	 		String updstatename ="Test country"+ faker.letterify("???");
			test.pass("Edit button clicked");
//			wait.until(ExpectedConditions.visibilityOf(MastersObj.editCountry));
			StateObj.State.sendKeys(Keys.CONTROL + "a"); // Select all text
			StateObj.State.sendKeys(Keys.DELETE);
			StateObj.State.sendKeys(updstatename); 
			test.pass("Update the state name Successfully");

			
			StateObj.city.sendKeys(Keys.CONTROL + "a"); // Select all text
			StateObj.city.sendKeys(Keys.DELETE);
			StateObj.city.sendKeys(updstatename); 
			test.pass("Update the city name Successfully");

			Thread.sleep(1000);

			StateObj.StateDesc.sendKeys(Keys.CONTROL + "a");
			StateObj.StateDesc.sendKeys(Keys.DELETE);
			StateObj.State.sendKeys(updstatename); 
			test.pass("Update the statedescription sucessfully");
			
			Thread.sleep(1000);
			StateObj.StatesaveBtn.click();

			Thread.sleep(2000);

			
			
			StateObj.StatesearchBox.click();
			StateObj.StatesearchBox.sendKeys(Keys.CONTROL + "a"); // Select all text
			StateObj.StatesearchBox.sendKeys(Keys.DELETE);
			
			Thread.sleep(1000);
			
			StateObj.StatesearchBox.sendKeys(updstatename);
			String actCountryNameUpdate=StateObj.StateDatatable.getText();
	        if(actCountryNameUpdate.equals(updstatename)) { 

	        	test.pass("Updated Country details displayed in data table.");
			}else {
	            test.fail("<font color='red'>Update Country failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());

			}
			Thread.sleep(1000);
			
	
		
//Update state	
		
//      test.info("<b><font color = 'purple'>Test case-5 Verify the Update State functionality </b>");
//        StateObj.StateeditBtn.click();
//		test.pass("Edit button clicked Successfully");
//	
//	
//		
//		StateObj.State.sendKeys(Keys.CONTROL + "a");
//		StateObj.State.sendKeys(Keys.DELETE);
//        StateObj.State.sendKeys(properties.getProperty("update_state"));
//		test.pass("Update the state name Successfully");
//
	
		
//		StateObj.city.sendKeys(Keys.CONTROL + "a");
//		StateObj.city.sendKeys(Keys.DELETE);
//		StateObj.city.sendKeys(properties.getProperty("update_city"));
//		test.pass("Update the city name Successfully");
//
//	    
//		StateObj.StateDesc.sendKeys(Keys.CONTROL + "a");
//		StateObj.StateDesc.sendKeys(Keys.DELETE);
//		StateObj.StateDesc.sendKeys(properties.getProperty("upd_Description"));
//		test.pass("Update the statedescription sucessfully");
//		Thread.sleep(1000);
//		StateObj.StatesaveBtn.click();

		
//delete the state
		
		
	

		
		
		
		
		
	test.info("<b><font color = 'purple'>Test case-6 check the delete button is displyed </b>");
	

	
	   
	
//		StateObj.StatesearchBox.sendKeys(properties.getProperty("update_state"));
		StateObj.StateDeleteOpt.click();
		test.pass("Delete button clicked.");
		
		
		
		StateObj.StateNoOpt.click();
		if(actCountryNameUpdate.equals(updstatename+"TestState")) { 
			test.pass("Data not deleted.No button functionality working");
		}else {
            test.fail("<font color='red'>No button click failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());

	
		}
	
		StateObj.StateConfirmOpt.click();
		//delete confirm button
		CountryObj.CountryConfirmOpt.click();
		test.pass("Clicked the confirm option ");
		if(createNameState.contains(updstatename+"TestState")) { 
			test.fail("Data not deleted.Confirm button functionality not working",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		}else {
            test.pass("Data deleted sucessfully");
		}
	
		
		

	} 
 

//
		
		
		
		
		
		
//		
//		
//// Implement this method to verify if data is not deleted
//		if (dataNotDeleted) { 
//		    test.pass("Data not deleted. No button functionality working");
//		} else {
//		    test.fail("<font color='red'>Data deleted.No functionality not working</font>", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver, screenShot)).build());
//		}
//		Thread.sleep(2000);
//

		
	
   
//		
//		StateObj.StateDeleteOpt.click();
//		// Delete confirm button
//		Thread.sleep(2000);
//
//		StateObj.StateConfirmOpt.click();
//
//
//}	
		

		
	

//private boolean verifyDataNotDeleted(String searchValue) {
//	// TODO Auto-generated method stub
//	return false;
//}

//
//delete 
		
   
	
	
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
