package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DocumentTypeObj {
	/*
	 * Locators of Document Types
	 */
	
	@FindBy (xpath="(//p[@class ='text-[9px] 2xl:text-xs text-white'])[7]")
	public static WebElement settings;
	
	@FindBy (xpath="//a[contains(text(),'Masters')]")
	public static WebElement masters;
	
	@FindBy (xpath="//p[text()='Document Type']")
	public static WebElement documentTypeMenu;
	
	@FindBy (xpath="//p[contains(text(),'Document Type')]")
	public static WebElement documentTypeHeading; //need to change after bug fix
	
	
	//span[text()='Create Document Type']
	@FindBy (xpath="//span[@class='ant-btn-icon']")
	public static WebElement createDocumentTypeBtn; //need to change after bug fix
	
	@FindBy (xpath="//h1[text()='Create Document Type']")
	public static WebElement createDocTypeOrg; //need to change after bug fix
	
	@FindBy (xpath="//label[text()='Document Type']//following::input")
	public static WebElement documentType;
	
	
	@FindBy (xpath="//textarea[@placeholder='Enter Description']")
	public static WebElement description;
	
	@FindBy (xpath="(//div[@class='ant-switch-handle'])[1]")
	public static WebElement mantType;
	
	@FindBy (xpath="(//div[@class='ant-switch-handle'])[2]")
	public static WebElement ERToggle;

	
	@FindBy (xpath="//span[contains(text(),'Save')]//ancestor::button[1]")
	public static WebElement saveDocBtn;
	
	@FindBy (xpath="//span[text()='Cancel ']")
	public static WebElement documentCancelOpt;
	
	@FindBy (xpath="//h1[contains(text(),'Create Document Type')]")
	public static WebElement createDocumentTypeHead;
	
	
	@FindBy (xpath="//input[@placeholder='Search']")
	public static WebElement searchDoc;


}
