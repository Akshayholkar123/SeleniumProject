package Com.Comcast.crm.ObjectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Comcast.Generic.WebDriverUtility.WebDriverUtility;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='index.php?module=Accounts&action=index']")
	private WebElement organization;

	@FindBy(xpath = "//a[@href='index.php?module=Contacts&action=index']")
	private WebElement contact;

	@FindBy(linkText = "More")
	private WebElement more;

	@FindBy(linkText = "Campaigns")
	private WebElement campaigns;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement Administration;

	@FindBy(linkText = "Sign Out")
	private WebElement LogOutButton;

	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getCampaigns() {
		return campaigns;
	}

	public WebElement getAdministration() {
		return Administration;
	}

	public WebElement getLogOutButton() {
		return LogOutButton;
	}

	public void LogOutMethod(WebDriver driver) {
		WebDriverUtility wu = new WebDriverUtility();
		wu.mouseover(driver, Administration);
		LogOutButton.click();
	}

	public WebElement getContact() {
		return contact;
	}

	public WebElement getMore() {
		return more;
	}

	public WebElement getcampaign() {
		return campaigns;
	}

	public void navigateToCampaigns() {

		Actions act = new Actions(driver);
		act.moveToElement(more).perform();
		more.click();
		campaigns.click();
	}

	public WebElement getOrgLink() {
		return organization;
	}

	public void clickOnContact() {
		WebDriverUtility wu = new WebDriverUtility();
		wu.waitForElementPresent(driver, contact);
		contact.click();
	}

}
