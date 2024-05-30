package Com.Comcast.crm.ObjectUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Comcast.Generic.WebDriverUtility.WebDriverUtility;

public class OrganizationPage {
	public OrganizationPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	@FindAll({
	    @FindBy(xpath = "//img[@alt='Create Organization...']"),
	    @FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	})

	private WebElement createOrg;
	
	//driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
//@FindElement(By.xpath("//a[text()='NASA1427']")) private WebElement dynamic;	
	@FindBy(xpath ="//a[@href='index.php?module=Accounts&parenttab=Marketing&action=DetailView&record=317']") private WebElement clickOnOrg;
	public WebElement getClickOnOrg() {
		return clickOnOrg;
	}

	@FindBy(xpath = "//input[@name='search_text']")private WebElement searchbox;
	
	@FindBy(xpath = "//select[@name='search_field']")
	private WebElement searchDD;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement clickOnSerachButton;

	public WebElement getClickOnSerachButton() {
		return clickOnSerachButton;
	}

	public WebElement getSearchBox() {
		return searchbox;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getCreateOrg() {

		return createOrg;
	}

	public void serachOrg(String OrgName, WebDriver driver) throws InterruptedException {
		WebDriverUtility wu = new WebDriverUtility();
		wu.waitForElementPresent(driver, searchbox);
		searchbox.sendKeys(OrgName);
		searchDD.click();
		wu.selectDropdown(searchDD, "Organization Name");
		// wu.waitForElementPresent(driver,clickOnSerachButton);
		clickOnSerachButton.click();
		wu.switchToNewTab(driver, "module=Contacts&action");
	}
}