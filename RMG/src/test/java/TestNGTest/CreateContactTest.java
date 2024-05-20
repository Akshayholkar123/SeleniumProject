package TestNGTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Com.Comcast.crm.GenricCommFilesUtility.BS_Class;
import Com.Comcast.crm.GenricCommFilesUtility.ExcelUtility;
import Com.Comcast.crm.ObjectUtility.Contacts;
import Com.Comcast.crm.ObjectUtility.HomePage;
import Com.Comcast.crm.ObjectUtility.OrganizationPage;
import Com.Comcast.crm.ObjectUtility.createNewContactPage;
@Listeners(Com.Comcast.crm.GenricCommFilesUtility.CustomListeners.class)

public class CreateContactTest extends BS_Class {
	@Test(groups = "smoke")
	public void createContactWithMandatoryInfoTest()
			throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException {
		ExcelUtility eu = new ExcelUtility();
		HomePage hp = new HomePage(driver);
		hp.clickOnContact();

		Contacts ct = new Contacts(driver);
		ct.getCreateContact().click();

		createNewContactPage c = new createNewContactPage(driver);
		c.createContactWithOrgNameAndDates(eu.getDataFromExcel("convert", 1, 2), eu.getDataFromExcel("convert", 7, 4));
		Reporter.log("pass 1st", true);
	}

	@Test(groups = "regression")
	public void createContactDateTest()
			throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException {
		ExcelUtility eu = new ExcelUtility();
		HomePage hp = new HomePage(driver);
		hp.clickOnContact();

		Contacts ct = new Contacts(driver);
		ct.getCreateContact().click();

		createNewContactPage c = new createNewContactPage(driver);
		c.createContactWithOrgNameAndDates(eu.getDataFromExcel("convert", 1, 2), eu.getDataFromExcel("convert", 7, 4));

		Thread.sleep(6000);

		Reporter.log("pass 2nd", true);
	}

	@Test(groups = "regression")
	public void createContactWithOrgName()
			throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException {
		ExcelUtility eu = new ExcelUtility();
		HomePage hp = new HomePage(driver);
		hp.clickOnContact();

		Contacts ct = new Contacts(driver);
		ct.getCreateContact().click();

		createNewContactPage c = new createNewContactPage(driver);
		c.createContactWithOrgName(eu.getDataFromExcel("convert", 1, 2), eu.getDataFromExcel("convert", 7, 4));
		Thread.sleep(6000);
		OrganizationPage op = new OrganizationPage(driver);
		op.serachOrg(eu.getDataFromExcel("convert", 4, 4), driver);

		Reporter.log("pass 3rd", true);
	}

}
