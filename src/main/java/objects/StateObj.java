package objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StateObj {
	
	@FindBy (xpath="(//p[@class ='text-[9px] 2xl:text-xs text-white'])[7]")
	public static WebElement settings;
	
	@FindBy (xpath="//a[contains(text(),'Masters')]")
	public static WebElement masters;
	
	@FindBy(xpath = "//p[text()=\"State\"]")
	public static WebElement state;
	
	//create state page heading (Child window)
	@FindBy(xpath ="//h1[text()='Create State']")
    public static WebElement createStateHeading;
	
	@FindBy(xpath ="//p[@class='text-lg font-semibold dark:text-white ']")
    public static WebElement StateHeading;
	
	
	
	//select country 
	@FindBy(xpath="//span[text()='Create State ']")
	public static WebElement createState;
	
	@FindBy(xpath = "//*[text()='Create State']//following::input[1]")
	public static WebElement countryDD;
	
//dropdown of country
	
	@FindBy(xpath="//label[text()='Country']/following::div[@class='rc-virtual-list-holder-inner']//div")
	public static 	WebElement StateDropDown;

	
	
	@FindBy(xpath="//label[text()='Country']/following::div[@class='rc-virtual-list-holder-inner']//div")
	public static 	List<WebElement> StatedropDown;
	
	@FindBy(xpath="//input[@placeholder='Enter State']")
	public static WebElement State;
	
	@FindBy(xpath="(//input[@placeholder='Enter City'])[1]")
	public static WebElement city;
	
	@FindBy(xpath="//p[@class ='text-xs font-medium cursor-pointer dark:text-white']")
	public static WebElement addCity;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Description']")
	public static WebElement StateDesc;
	
	@FindBy (xpath="//span[text()='Cancel ']")
	public static WebElement StatecancelOpt;
	
	@FindBy (xpath="//span[text()='Save ']")
	public static WebElement StatesaveBtn;
	
	//state data table
	@FindBy(xpath="(//td[@class='ant-table-cell'][2])")
	public static WebElement stateDatatable;
	
	
	@FindBy(xpath="//table//tbody//tr//td[1]//div//div//p")
	public static 	List<WebElement> stateDatatab;
	
	@FindBy(xpath="//table//tbody//tr//td[2]//div//div//p")
	public static 	List<WebElement> stateDescab;
	
	
	
//	@FindBy (xpath="//input[@placeholder='Search']")
//	public static WebElement Search;
	
	@FindBy (xpath="//table//tbody//tr//td[5]//div//button[2]")
	public static List<WebElement> ToggleBtn;
	
	
	@FindBy (xpath="//*[text()='Status']//following::button[1]")
	public static WebElement activeToggle;
	//serach
	@FindBy (xpath="//input[@placeholder='Search']")
	public static WebElement StatesearchBox;
	
	//edit btn
	@FindBy (xpath="(//button[@class ='w-8 h-8 2xl:w-10 2xl:h-10 rounded-full vhcenter hover:bg-primaryalpha/20 dark:hover:bg-primaryalpha/30 text-accent transition-all duration-300'])[1]")
	public static WebElement StateeditBtn;
	

	//delete the country
	@FindBy (xpath="((//button[@class='w-8 h-8 2xl:w-10 2xl:h-10 rounded-full vhcenter hover:bg-primaryalpha/20 dark:hover:bg-primaryalpha/30 text-accent transition-all duration-300'])[2])[1]")
	public static WebElement StateDeleteOpt;
	
	@FindBy (xpath="//span[contains(text(), 'Confirm')]")
	public static WebElement StateConfirmOpt;
	
	@FindBy (xpath="(//span[text()='No'])[1]")
	public static WebElement StateNoOpt;
	
	
	
}
