package objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DocumentTypeObj {
	/*
	 * Locators of Document Types
	 */
	

	@FindBy (xpath="//p[contains(text(),'Settings')]")
	public static WebElement settingsDocumtTy;
	
	
	@FindBy (xpath="//a[text()='Masters']")
	public static WebElement mastersopt;
//	
	@FindBy (xpath="//p[contains(text(), 'Document Type')]")
	public static WebElement documentTypeMenu;
	
	@FindBy (xpath="(//p[text()='Document Type'])[2]")
	public static WebElement documentTypeHeading; 
	
	@FindBy (xpath="//span[text()='Create Document Type']")
	public static WebElement createDocTypeOpt; 
	
	
	
	
	@FindBy (xpath="//h1[text()='Create Document Type']")
	public static WebElement documentTypeChild;
	
	@FindBy (xpath="//button[@class='ant-btn css-1b597yz ant-btn-default  false text-xs 2xl:text-sm font-medium w-fit flex items-center justify-center leading-6 z-50 sm:pr-8']")
	public static WebElement canceloptDT;
	
	
	@FindBy (xpath="//textarea[@placeholder='Enter Description']")
	public static WebElement description;
//	
//	@FindBy (xpath="(//button[@class='ant-switch ant-switch-small w-fit css-10rv5he'])[1]")
//	public static WebElement mantType;
//	
//	@FindBy (xpath="(//button[@type='button'])[10]")
//	public static WebElement ERToggle;
//
	
	@FindBy (xpath="//span[contains(text(),'Save')]//ancestor::button[1]")
	public static WebElement saveDocBtn;
	
	@FindBy (xpath="//span[text()='Cancel ']")
	public static WebElement documentCancelOpt;
	
	@FindBy (xpath="//h1[contains(text(),'Create Document Type')]")
	public static WebElement createDocumentTypeHead;
	
	
	@FindBy (xpath="//input[@placeholder='Enter Document Type']")
	public static WebElement DocumentName;
	
	@FindBy (xpath="//input[@placeholder='Search']")
	public static WebElement SearchDoc;
	
	
	
//update
	@FindBy (xpath="//input[@placeholder='Search']")
	public static WebElement searchDoc;
	
	@FindBy (xpath="(//button[@class='w-8 h-8 2xl:w-10 2xl:h-10 rounded-full vhcenter hover:bg-primaryalpha/20 dark:hover:bg-primaryalpha/30 text-accent transition-all duration-300'])[1]")
	public static WebElement EditbtnDoc;
	
	@FindBy (xpath="//table//tr[2]/td[1]")
	public static WebElement DocDatatable;
	
//delete
	

	@FindBy (xpath="(//button[@class='w-8 h-8 2xl:w-10 2xl:h-10 rounded-full vhcenter hover:bg-primaryalpha/20 dark:hover:bg-primaryalpha/30 text-accent transition-all duration-300'])[2]")
	public static WebElement DeleteDocbtn;
	
	@FindBy (xpath="//span[text()='No']")
	public static WebElement NobtnDoc;

	
	@FindBy (xpath="//span[text()='Confirm']")
	public static WebElement ConfirmbtnDoc;

	@FindBy (xpath="//table//tr/td[1]")
	public static List<WebElement> datatable1;
////	
////	
	

	
	
}
