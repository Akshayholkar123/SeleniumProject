package Com.Comcast.crm.ObjectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name="user_name") 
	private WebElement usernameTxt;
	

	@FindBy(name="user_password")
	private WebElement passwordTxt;
	
	@FindBy(id="submitButton") 
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver,this);//pagefactory is implementation for pom
	}

	public WebElement getUsername() {
		return usernameTxt;
	}

	public WebElement getPassword() {
		return passwordTxt;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void loginToApp(WebDriver driver, String url, String username, String password) {
		driver.get(url);
		usernameTxt.sendKeys(username);
		passwordTxt.sendKeys(password);
		loginButton.click();
	}
	
}
