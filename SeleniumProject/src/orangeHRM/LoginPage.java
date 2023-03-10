package orangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class LoginPage{
	@FindBy(name="username") private WebElement usn;
	@FindBy(name="password") private WebElement pass;
	//@FindBy(xpath("//button[@type='submit']")) private WebElement loginButton;
	
	
	
	
	
	//intialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization

	

	public WebElement getUsn() {
		return usn;
	}

	public WebElement getPassword() {
		return pass;
	}

	//public WebElement getLoginButton() {
		// return loginButton;
	//}
	public void loginToOrangeHrm(String username,String password)
	{
		usn.sendKeys(username);
		pass.sendKeys(password);
		//loginButton.click();
	}


	
	
	
	
	
}