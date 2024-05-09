package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginpageObj {
	
	
	


	@FindBy (xpath="//*[@id='floating_filled_email']")
	public static WebElement username;

	@FindBy (xpath="//*[@id='floating_filled_password']")
//
	public static WebElement password;
	
	@FindBy(xpath="//span[text()='Sign In']")
  
	public static WebElement sigin;
	


}
