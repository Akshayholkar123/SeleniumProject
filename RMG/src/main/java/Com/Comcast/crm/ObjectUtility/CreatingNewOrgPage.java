package Com.Comcast.crm.ObjectUtility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import Com.Comcast.Generic.WebDriverUtility.JavaUtility;
import Com.Comcast.Generic.WebDriverUtility.WebDriverUtility;
import Com.Comcast.crm.GenricCommFilesUtility.ExcelUtility;

public class CreatingNewOrgPage {
	WebDriver driver;

	public CreatingNewOrgPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriverUtility wu = new WebDriverUtility();
	ExcelUtility ex = new ExcelUtility();
	JavaUtility ju = new JavaUtility();

	@FindBy(xpath = "//input[@name='phone']")
	private WebElement PhoneNumber;

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgname;

	@FindBy(xpath = "//input[@title='Save [Alt+S]' and @class='crmbutton small save']")
	private WebElement saveButton;

	@FindBy(xpath = "//select[@name='industry']")
	private WebElement idustryDropdown;

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getPhoneNumber() {
		return PhoneNumber;
	}

	public WebElement getIdustryDropdown() {
		return idustryDropdown;
	}

	public void createOrgWithIndustry() throws IOException, Throwable {

		String orgName1 = ex.getDataFromExcel("convert", 4, 4) + ju.getRandomNumber();
		orgname.sendKeys(orgName1);
		wu.waitForElementPresent(driver, idustryDropdown);
		wu.selectDropdown(idustryDropdown, "Energy");
		saveButton.click();
		Thread.sleep(2000);
		//OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		WebElement actEle=driver.findElement(By.xpath("//span[contains(@class, 'dvHeaderText') and contains(text(), '"+orgName1+"')]"));
		String actOrgName1=actEle.getText();
		//span[contains(@class, 'dvHeaderText') and contains(text(), 'NASA') and contains(text(), ' - Orgnization Information')]
		String actOrgName = actOrgName1.substring(actOrgName1.indexOf("NASA"), actOrgName1.indexOf(" -")).trim();
		//String actOrgName = actOrgName1.substring(0,actOrgName1.indexOf(" -")).trim();
		Reporter.log(actOrgName+" "+orgName1,true);
		Thread.sleep(3000);
		Assert.assertEquals(orgName1,actOrgName);
		//String actOrgName = oip.getOrgHeaderInfo().getText();
		
	}

	public void createOrgWithName() throws Throwable, IOException {
		String orgName1 = ex.getDataFromExcel("convert", 4, 4) + ju.getRandomNumber();
		orgname.sendKeys(orgName1);
		saveButton.click();
		Thread.sleep(2000);
	//	OrganizationInfoPage oip = new OrganizationInfoPage(driver);
WebElement actEle=driver.findElement(By.xpath("//span[@class='dvHeaderText']/.."));
		
		String actOrgName1=actEle.getText();
		String actOrgName = actOrgName1.substring(actOrgName1.indexOf("NASA"), actOrgName1.indexOf(" -")).trim();
		Reporter.log(actOrgName+" "+orgName1,true);
		Thread.sleep(5000);
		Assert.assertEquals(actOrgName,orgName1);
		
}

	public void createOrgWithContact() throws Throwable, IOException {
		String orgName1 = ex.getDataFromExcel("convert", 4, 4) + ju.getRandomNumber();
		orgname.sendKeys(orgName1);
		PhoneNumber.sendKeys(ex.getDataFromExcel("convert", 7, 4));
		saveButton.click();
		Thread.sleep(2000);
		
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		oip.verifyHeaderMSG1(orgName1);

		//OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		//String actOrgName = oip.getOrgHeaderInfo().getText();
		//OrganizationInfoPage oip=new OrganizationInfoPage(driver);

	}

}
