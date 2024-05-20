package POMTesting;

import java.io.FileNotFoundException;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Com.Comcast.Generic.WebDriverUtility.WebDriverUtility;
import Com.Comcast.crm.GenricCommFilesUtility.BS_Class;
import Com.Comcast.crm.ObjectUtility.CreatingNewOrgPage;
import Com.Comcast.crm.ObjectUtility.HomePage;
//import Com.Comcast.crm.ObjectUtility.Login;
import Com.Comcast.crm.ObjectUtility.LoginPage;
import Com.Comcast.crm.ObjectUtility.OrganizationPage;

public class LoginUsingPOM extends BS_Class {
	static WebDriver driver;
	HomePage hp = new HomePage(driver);
	WebDriverUtility wu = new WebDriverUtility();

	@Test
	public void run() {
		WebDriver driver = new ChromeDriver();
		LoginPage l = new LoginPage(driver);
		// l.login("admin","admin");
		hp.LogOutMethod(driver);
		// driver.quit();
		// hp.getMore().click();
		// hp.getcampaign().click();
		// driver.close();
	}

	@Test
	public void run2() {
		WebDriver driver = new ChromeDriver();

		LoginPage l = new LoginPage(driver);
		// l.loginP("admin","admin");
		HomePage hp = new HomePage(driver);

		hp.navigateToCampaigns();
		driver.close();
	}

	@Test
	public void createOrg(String orgName) throws EncryptedDocumentException, FileNotFoundException, IOException, Throwable {

		WebDriver driver = new ChromeDriver();

		LoginPage l = new LoginPage(driver);
		// l.login("admin","admin");
		HomePage hp = new HomePage(driver);
		CreatingNewOrgPage creOrg = new CreatingNewOrgPage(driver);
		hp.getOrgLink().click();
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrg().click();
		creOrg.createOrgWithName();
	}

	@Test
	public void createOrgWithInd() throws EncryptedDocumentException, FileNotFoundException, IOException {
		{
			WebDriver driver = new ChromeDriver();

			LoginPage l = new LoginPage(driver);
			// l.login("admin","admin");
			HomePage hp = new HomePage(driver);
			CreatingNewOrgPage creOrg = new CreatingNewOrgPage(driver);
			hp.getOrgLink().click();
			OrganizationPage op = new OrganizationPage(driver);
			op.getCreateOrg().click();
			//creOrg.createOrgWithIndustry();
		}
	}

	@Test
	public void verifyOrgInfo() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();

		LoginPage l = new LoginPage(driver);
		// l.login("admin","admin");
		HomePage hp = new HomePage(driver);
		CreatingNewOrgPage creOrg = new CreatingNewOrgPage(driver);
		hp.getOrgLink().click();
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrg().click();
	//	creOrg.createOrgWithName();
		String OrgName = creOrg.getOrgname().getText();
		if (OrgName.contains("NASA")) {
			Reporter.log("pass", true);
		}

	}

}