package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	static WebDriver driver;
	//Declaration
	@FindBy(name="username") private WebElement usn;
	@FindBy(name="pwd")private WebElement password;
	@FindBy(id="loginButton") private WebElement loginbutton;
	@FindBy(id="keepLoggedInCheckBox") private WebElement keepmelogin;
		
		
	
	
	//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}	
	
	//utilization
	public WebElement getUsn() {
		return usn;
	}
	
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginbutton() {
		return loginbutton;
	}
	public WebElement getKeepmelogin() {
		return keepmelogin;
	}
	
	public void validLoginToActitime(String validusername,String validpassword)
	{
		usn.sendKeys(validusername);
		password.sendKeys(validpassword);
		loginbutton.click();
	}
	public void invalidLoginToActitime(String invalidusername,String invalidpassword) throws InterruptedException
	{
		usn.sendKeys(invalidusername);
		Thread.sleep(1000);
		password.sendKeys(invalidpassword);
		Thread.sleep(1000);

		loginbutton.click();
		Thread.sleep(2000);
		usn.clear();


	}
}
