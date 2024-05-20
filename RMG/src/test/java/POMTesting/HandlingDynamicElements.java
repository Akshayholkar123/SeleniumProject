package POMTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Com.Comcast.Generic.WebDriverUtility.JavaUtility;
import Com.Comcast.Generic.WebDriverUtility.WebDriverUtility;
import Com.Comcast.crm.GenricCommFilesUtility.ExcelUtility;
import Com.Comcast.crm.ObjectUtility.CreatingNewOrgPage;
import Com.Comcast.crm.ObjectUtility.HomePage;
import Com.Comcast.crm.ObjectUtility.LoginPage;
import Com.Comcast.crm.ObjectUtility.OrganizationInfoPage;
import Com.Comcast.crm.ObjectUtility.OrganizationPage;

public class HandlingDynamicElements {
	@Test
	public void handleDynamicXpath() throws Throwable {
		WebDriver driver = new ChromeDriver();
		WebDriverUtility wu = new WebDriverUtility();
		wu.maximizeBrowser(driver);
JavaUtility ju=new JavaUtility();
		wu.implicitlyWait(driver);
		LoginPage lg = new LoginPage(driver);
		//lg.login("admin","admin");
		HomePage hp = new HomePage(driver);
		CreatingNewOrgPage creOrg = new CreatingNewOrgPage(driver);
		hp.getOrgLink().click();
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrg().click();
		ExcelUtility ex=new ExcelUtility();
		String orgName = "NASA" + ju.getRandomNumber();
		//String orgName1 = ex.getDataFromExcel("convert",4,4)+ ju.getRandomNumber();

		creOrg.createOrgWithName();

		OrganizationInfoPage oip2 = new OrganizationInfoPage(driver);
		//oip2.orgInfo(orgName);
		WebElement ele = oip2.getOrgHeaderInfo();
		wu.waitForElementPresent(driver, ele);
		
		//org link
		hp.getOrgLink().click();
		
		// String visibleText="Organization Name";
		op.getSearchBox().sendKeys(orgName);
		wu.selectDropdown(op.getSearchDD(), "Organization Name");
		op.getClickOnSerachButton().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
		wu.switchToAlert(driver);
System.out.println("deleted");

	}
}
