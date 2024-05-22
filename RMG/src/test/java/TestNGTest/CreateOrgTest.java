package TestNGTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Com.Comcast.Generic.WebDriverUtility.UtilityClassObj;
import Com.Comcast.crm.GenricCommFilesUtility.BS_Class;
import Com.Comcast.crm.ObjectUtility.CreatingNewOrgPage;
import Com.Comcast.crm.ObjectUtility.HomePage;
import Com.Comcast.crm.ObjectUtility.OrganizationPage;

@Listeners(Com.Comcast.crm.GenricCommFilesUtility.CustomListeners.class)

public class CreateOrgTest extends BS_Class {

	@Test(groups = "smoke")
	public void createOrgNameTest() throws EncryptedDocumentException, IOException, Throwable {

		UtilityClassObj.getTest().log(Status.INFO, "login to app");
		OrganizationPage op = new OrganizationPage(driver);
		CreatingNewOrgPage cno = new CreatingNewOrgPage(driver);
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		UtilityClassObj.getTest().log(Status.INFO, "click on org link");

		op.getCreateOrg().click();
		UtilityClassObj.getTest().log(Status.INFO, "click on create org link");

		cno.createOrgWithName();
		UtilityClassObj.getTest().log(Status.PASS, "new org with name created");

		// Reporter.log("pass Org1", true);
	}

	@Test(groups = "regression")
	public void createOrgNameIndustryTest() throws EncryptedDocumentException, IOException, Throwable {

		OrganizationPage op = new OrganizationPage(driver);
		CreatingNewOrgPage cno = new CreatingNewOrgPage(driver);
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		op.getCreateOrg().click();
		cno.createOrgWithIndustry();
		Reporter.log("pass Org2 ", true);

	}

	@Test(groups = "regression")
	public void createOrgNameContactTest() throws EncryptedDocumentException, IOException, Throwable {

		OrganizationPage op = new OrganizationPage(driver);
		CreatingNewOrgPage cno = new CreatingNewOrgPage(driver);
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		op.getCreateOrg().click();
		cno.createOrgWithContact();

		// Thread.sleep(3000);
		Reporter.log("pass 3", true);

	}
}
