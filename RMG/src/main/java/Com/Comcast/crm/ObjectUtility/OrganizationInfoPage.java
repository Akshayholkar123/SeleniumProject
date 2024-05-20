package Com.Comcast.crm.ObjectUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import Com.Comcast.Generic.WebDriverUtility.WebDriverUtility;

public class OrganizationInfoPage {
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement orgHeaderMsgInfo;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement Administration;

	@FindBy(linkText = "Sign Out")
	private WebElement LogOutButton;
    
	@FindBy(xpath ="//span[@class='dvHeaderText']/../../..")private WebElement OnlyorgName;	
	
	

	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getAdministration() {
		return Administration;
	}
	public WebElement getOnlyorgName() {
		return OnlyorgName;
	}
	public WebElement getOrgHeaderInfo() {
		return orgHeaderMsgInfo;
	}
	
	public void verifyHeaderMSG1(String orgName1)
	{	
WebElement actEle=driver.findElement(By.xpath("//span[@class='dvHeaderText']/.."));
		
		String actOrgName1=actEle.getText();
		String actOrgName = actOrgName1.substring(actOrgName1.indexOf("NASA"), actOrgName1.indexOf(" -")).trim();
		Reporter.log(actOrgName+" "+orgName1,true);

		Assert.assertEquals(actOrgName,orgName1);

	
	
	
	}
	public void verifyHeaderMSG(String orgName1)
	{
	//	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		WebDriverUtility wu=new WebDriverUtility();
		wu.waitForElementPresent(driver,orgHeaderMsgInfo);
		String actOrgName = getOrgHeaderInfo().getText();
		if (actOrgName.contains(orgName1)) {
			System.out.println("-- Organization created successfully");
		} else {
			System.out.println("-- Organization not created");
		}	
	}
	
	
	
	
	
	
}