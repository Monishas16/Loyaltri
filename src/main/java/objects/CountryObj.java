package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CountryObj {
	
	@FindBy (xpath="//p[contains(text(),'Settings')]")
		public static WebElement settings;

	
		@FindBy (xpath="//a[contains(text(),'Masters')]")
		public static WebElement masters;
	
	@FindBy (xpath="//p[text()=\"Country\"]")
	public static WebElement countryOpt;
	
	@FindBy (xpath="(//button[@type='button'])[2]")
	public static WebElement createcountryOpt;
	
	
	//data table  heading
	@FindBy (xpath="//table/tbody/tr[1]/td[2]")
	public static WebElement countryDatatable;
	

    @FindBy (xpath="(//p[text()='Country'])[2]")
	public static WebElement countryHeading;
//	
	@FindBy (xpath="//h1[text()='Create Country']")
	public static WebElement createCountryHeading;


	
	

	@FindBy (xpath="//p[text()='Country']")
	public static WebElement Country;
	
	//edit country
//	
	@FindBy (xpath="(//button[@class ='w-8 h-8 2xl:w-10 2xl:h-10 rounded-full vhcenter hover:bg-primaryalpha/20 dark:hover:bg-primaryalpha/30 text-accent transition-all duration-300'])[1]")
	public static WebElement CountryeditBtn;
//	
	
	@FindBy (xpath="//button[@class='ant-btn css-10rv5he ant-btn-primary  bg-accent text-xs 2xl:text-sm font-medium w-fit flex items-center justify-center leading-6 z-50 sm:px-5 sm:py-2 text-xs font-semibold text-white rounded-md lg:text-sm']")
	public static WebElement CountrySavebtn;
	
	//create country
	
//	@FindBy (xpath="//span[text()='Create Country ']")
//	public static WebElement createCountryOpt;
	
	
	@FindBy (xpath="//input[@placeholder='Enter Country']")
	public static WebElement countryName;
	
	@FindBy (xpath="//input[@placeholder='Enter Country Code']")
	public static WebElement countryCode;
	


	@FindBy (xpath="//textarea[@placeholder='Enter Description']")
	public static WebElement countryDescription;
	
	
	@FindBy (xpath="((//button[@class='w-8 h-8 2xl:w-10 2xl:h-10 rounded-full vhcenter hover:bg-primaryalpha/20 dark:hover:bg-primaryalpha/30 text-accent transition-all duration-300'])[2])[1]")
	public static WebElement CountrydeleteBtn;

	
	//cANCEL OPTION
	

	@FindBy (xpath="//button[@class='ant-btn css-10rv5he ant-btn-default  false text-xs 2xl:text-sm font-medium w-fit flex items-center justify-center leading-6 z-50 sm:pr-8']")
	public static WebElement CountryCancelOpt;
	
	
	
	//seacrh option home page
		@FindBy (xpath="//input[@placeholder='Search']")
		public static WebElement CountrysearchBox;
	
//search the country name
	
//	@FindBy (xpath="//span[@class='ant-input-affix-wrapper css-1r82puo ant-input-outlined w-full border focus:outline-none  mt-0 w-ful md:w-auto']")
//	public static WebElement searchValue;
//
//	
	
	
	//delete the country
	@FindBy (xpath="((//button[@class='w-8 h-8 2xl:w-10 2xl:h-10 rounded-full vhcenter hover:bg-primaryalpha/20 dark:hover:bg-primaryalpha/30 text-accent transition-all duration-300'])[2])[1]")
	public static WebElement CountryDeleteOpt;
	
	@FindBy (xpath="//button[@class='ant-btn css-10rv5he ant-btn-primary ant-btn-sm']")
	public static WebElement CountryConfirmOpt;
	
	@FindBy (xpath="//button[@class='ant-btn css-10rv5he ant-btn-default ant-btn-sm']")
	public static WebElement CountryNoOpt;
	

	

}
