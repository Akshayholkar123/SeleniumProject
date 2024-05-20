package Com.Comcast.crm.ObjectUtility;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Com.Comcast.Generic.WebDriverUtility.JavaUtility;
import Com.Comcast.Generic.WebDriverUtility.WebDriverUtility;
import Com.Comcast.crm.GenricCommFilesUtility.ExcelUtility;

public class createNewContactPage {
	WebDriver driver;

	public createNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="//img[@title='Create Contact...']") private WebElement
	// createContact;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement LastNameTextField;
	@FindBy(id = "mobile")
	private WebElement mobileNumberTextField;
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgName;
	@FindBy(xpath = "//input[@name='support_start_date']")
	private WebElement supportStarDate;
	@FindBy(xpath = "//input[@name='support_end_date']")
	private WebElement supportEndDate;
	@FindBy(xpath = "//input[@class='crmButton small save']")
	private WebElement SaveButton;
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement selectOrg;
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrgImg;

	/*
	 * public WebElement getCreateContact() { return createContact; }
	 */
	public WebElement getLastNameTextField() {
		return LastNameTextField;
	}

	public WebElement getMoobileNumberTextField() {
		return mobileNumberTextField;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getSupportDate() {
		return supportStarDate;
	}

	public WebElement getSupportStarDate() {
		return supportStarDate;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

	public void createContactWithOrgNameAndDates(String LastName, String mobileno)
			throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException {
		ExcelUtility ex = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		WebDriverUtility wu = new WebDriverUtility();
		LastNameTextField.sendKeys(LastName);
		mobileNumberTextField.sendKeys(mobileno);
		Thread.sleep(3000);
		// String OrgName=ex.getDataFromExcel("convert",4,4)+ju.getRandomNumber();
		// orgName.sendKeys(OrgName);
		supportStarDate.clear();
		supportStarDate.sendKeys(ju.getSystemDate());
		wu.scrollDown(driver);
		wu.scrollUp(driver);
		Thread.sleep(2000);

		// String date=ju.getRequiredDate(30);
		supportEndDate.clear();
		// supportEndDate.sendKeys(date);

		SaveButton.click();

	}

	public void createContactWithOrgName(String LastName, String mobileno)
			throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException {
		ExcelUtility ex = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		WebDriverUtility wu = new WebDriverUtility();
		LastNameTextField.sendKeys(LastName);
		mobileNumberTextField.sendKeys(mobileno);
		selectOrgImg.click();

		wu.switchToNewTab(driver, "module=Accounts&action");
		wu.maximizeBrowser(driver);

		// wu.scrollDown(driver);

//SaveButton.click();

	}
}
