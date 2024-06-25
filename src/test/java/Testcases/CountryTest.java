package Testcases;
import java.io.File;

import java.util.Date;import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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
import objects.StateObj;
import libraries.CommonFunctions;
import com.github.javafaker.Faker;
public class CountryTest extends CommonFunctions{
	static String screenShot;

	@BeforeSuite

	public void report() {
		report = new ExtentSparkReporter("Reports/country.html");
		reports = new ExtentReports();
		reports.attachReporter(report);
		Faker faker = new Faker();
 
		reports.setSystemInfo("<b>Application<b>", "<b>Loyaltri<b>");
		reports.setSystemInfo("<b>Module<b>", "<b>Monisha<\b>");
		reports.setSystemInfo("<b>Author<b>", "<b> Cordova Testing Team<b>");

	}

	
	
	
	
	
	@Test(priority = 1)

	public void eventlist() throws Exception {

		

		
		Faker faker = new Faker();             //for give the default value
 		test = reports.createTest("Testcase for Country Page ");
		PageFactory.initElements(driver,CountryObj.class);
		
	test.info("<b><font color = 'purple'>Test case-1 Verify the country page is displayed </b>");
		CountryObj.settings.click();
		test.pass("Settings Menu clicked");
		CountryObj.masters.click();
		test.pass("Master Menu Clicked");
		CountryObj.countryOpt.click();
		test.pass("Country option clicked");
		String actCountry = CountryObj.Country.getText(); 
		if (actCountry.equals("Country")) {
	            test.pass("Country page is displayed");


        } else {
	            test.fail("<font color='red'>Country page is not displayed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
	        }
	
	
		
		
		
	 test.info("<b><font color = 'purple'>Test case-2 Check the Create country page is displayed </b>");
		CountryObj.createcountryOpt.click();
		test.pass("Create Country button clicked.");
		Thread.sleep(1000);
		
		if(CountryObj.createCountryHeading.getText().equals("Create Country")) {
			test.pass("Create Country child window is displayed.The heading is :"+CountryObj.createCountryHeading.getText());
		}else {
            test.fail("<font color='red'>Create Country page navigation failed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		}
	
		
		
	test.info("<b><font color = 'purple'>Test case-3 Verify if the Cancel button on the Create Country page is functioning correctly</b>");
		CountryObj.CountryCancelOpt.click();
		test.pass("Cancel Button is clicked.");
		if(CountryObj.createcountryOpt.isDisplayed()) {
			test.pass("Cancel button worked.Create Country child window is closed.");
		}else {
            test.fail("<font color='red'>The functionality of the cancel button did not execute as expected.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		}
	    
//create 		
	 test.info("<b><font color = 'purple'>Test case-4 Verify create a new country functionality./b>");
	    CountryObj.createcountryOpt.click();
	    Thread.sleep(1000);
	    test.pass("Create country button clicked");
		String name = faker.letterify("???");
		String newCountryName="Country "+name;
		CountryObj.countryName.click();
		CountryObj.countryName.sendKeys(newCountryName);
		test.pass("Country Name is entered");
		CountryObj.countryCode.sendKeys(newCountryName);
		test.pass("Country Code is entered");
		CountryObj.countryDescription.sendKeys(newCountryName);
		test.pass("Country Description is entered");
		CountryObj.CountrySavebtn.click();
		test.pass("Save button is clicked");
		Thread.sleep(1000);

		
		
		
		CountryObj.CountrysearchBox.sendKeys(newCountryName);
		String actCountryName=CountryObj.countryDatatable.getText();
		if(actCountryName.equals(newCountryName)) { 
			test.pass("New country displayed in data table.");
		}else {
            test.fail("<font color='red'>Create new Country failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());

		}
	
		
	
		
	
		
	//Update Country
        test.info("<b><font color = 'purple'>Test case-5 Verify the Update Country functionality </b>");
 		CountryObj.CountryeditBtn.click();
 		String updname ="Test country"+ faker.letterify("???");
		test.pass("Edit button clicked");
//		wait.until(ExpectedConditions.visibilityOf(MastersObj.editCountry));
		CountryObj.countryName.sendKeys(Keys.CONTROL + "a"); // Select all text
		CountryObj.countryName.sendKeys(Keys.DELETE);
		CountryObj.countryName.sendKeys(updname); 

		
		
		CountryObj.countryCode.sendKeys(Keys.CONTROL + "a"); // Select all text
		CountryObj.countryCode.sendKeys(Keys.DELETE);
		CountryObj.countryCode.sendKeys(updname);
		
		
		CountryObj.countryDescription.sendKeys(Keys.CONTROL + "a"); // Select all text
		CountryObj.countryDescription.sendKeys(Keys.DELETE);
		CountryObj.countryDescription.sendKeys(updname);
		CountryObj.CountrySavebtn.click();
		test.pass("Save button is clicked.");
	
		//wait.until(ExpectedConditions.visibilityOf(MastersObj.searchBox));
		
		Thread.sleep(2000);
		//String ExpectedCountryName=newCountryName+"Testcountry";
		CountryObj.CountrysearchBox.click();
		CountryObj.CountrysearchBox.sendKeys(Keys.CONTROL + "a"); // Select all text
		CountryObj.CountrysearchBox.sendKeys(Keys.DELETE);
		
		Thread.sleep(6000);
		
		CountryObj.CountrysearchBox.sendKeys(updname);
		String actCountryNameUpdate=CountryObj.countryDatatable.getText();
        if(actCountryNameUpdate.equals(updname)) { 

        	test.pass("Updated Country details displayed in data table.");
		}else {
            test.fail("<font color='red'>Update Country failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());

		}
		Thread.sleep(6000);

 
		
             
 //Delete Country
		test.info("<b><font color = 'purple'>Test case-6 check the delete button is displyed </b>");
		CountryObj.CountryDeleteOpt.click();
		test.pass("Delete button clicked.");
	
		//no button click
	
		CountryObj.CountryNoOpt.click();
		if(actCountryNameUpdate.equals(newCountryName+"Testcountry")) { 
			test.pass("Data not deleted.No button functionality working");
		}else {
            test.fail("<font color='red'>No button click failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());

	
		}
	
		CountryObj.CountryDeleteOpt.click();
		//delete confirm button
		CountryObj.CountryConfirmOpt.click();
		test.pass("Clicked the confirm option ");
		if(actCountryName.contains(newCountryName+"Testcountry")) { 
			test.fail("Data not deleted.Confirm button functionality not working",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		}else {
            test.pass("Data deleted sucessfully");
		}
	
		
		
		

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
	
	
	
	   
	
	
	@AfterSuite
	public void reportflush() {
		reports.flush();
	}
	@AfterTest
	public void close() {
		driver.close();
	}
	

 
}


