package objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StateObj {
	
	@FindBy (xpath="//p[text()='Settings']")
	public static WebElement settingsState;
	
	@FindBy (xpath="(//a[contains(text(),'Masters')])[1]")
	public static WebElement mastersState;
	
	@FindBy(xpath = "//p[text()='State']")
	public static WebElement state;
	
//create state page heading (Child window)
	
	@FindBy(xpath ="//h1[text()='Create State']")
    public static WebElement createStateHeading;
	
	@FindBy(xpath ="//p[@class='text-lg font-semibold dark:text-white ']")
    public static WebElement StateHeading;

	
//select country 
	@FindBy(xpath="(//button[@type='button'])[2]")
	public static WebElement createState;
	
	@FindBy(xpath = "//input[@role='combobox']")
	public static WebElement countryDD;
	
//dropdown of country

	@FindBy(xpath="//label[text()='Country']/following::div[@class='rc-virtual-list-holder-inner']//div")
	public static 	List<WebElement> StatedropDown;
	
	@FindBy(xpath="//input[@placeholder='Enter State']")
	public static WebElement State;
	
	@FindBy(xpath="//input[@placeholder='Enter City1']")
	public static WebElement city;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Description']")
	public static WebElement StateDesc;
	
	@FindBy (xpath="//button[@class='ant-btn css-10rv5he ant-btn-default  false text-xs 2xl:text-sm font-medium w-fit flex items-center justify-center leading-6 z-50 sm:pr-8']")
	public static WebElement StatecancelBtn;
	
	@FindBy (xpath="//span[contains(text(),'Save')]")
	public static WebElement StatesaveBtn;
	
	@FindBy (xpath="(//p[text()='Sikkim'])[1]")
	public static WebElement SelectOpt;
	
	@FindBy(xpath="//span[text()='OK']")
	public static WebElement OkBtn;
	
	@FindBy (xpath="//table//tr/td[1]")
	public static WebElement StateDatatable;	
	//table//tr[2]/td[1]
	//state data table

	
	@FindBy (xpath="//table//tbody//tr//td[5]//div//button[2]")
	public static List<WebElement> ToggleBtn;
	
	
	@FindBy (xpath="//*[text()='Status']//following::button[1]")
	public static WebElement activeToggle;
	//serach
	@FindBy (xpath="//input[@placeholder='Search']")
	public static WebElement StatesearchBox;
	
	//edit btn
	@FindBy (xpath="(//button[@class ='w-8 h-8 2xl:w-10 2xl:h-10 rounded-full vhcenter hover:bg-primaryalpha/20 dark:hover:bg-primaryalpha/30 text-accent transition-all duration-300'])")
	public static WebElement StateeditBtn;
	

	//delete the country
	@FindBy (xpath="//button[@class='w-8 h-8 2xl:w-10 2xl:h-10 rounded-full vhcenter hover:bg-primaryalpha/20 dark:hover:bg-primaryalpha/30 text-accent transition-all duration-300'][2]")
	public static WebElement StateDeleteOpt;
	
	@FindBy (xpath="//button[@class='ant-btn css-10rv5he ant-btn-primary ant-btn-sm']")
	public static WebElement StateConfirmOpt;
	
	@FindBy (xpath="(//span[text()='No'])[1]")
	public static WebElement StateNoOpt;
	
	
	
}
