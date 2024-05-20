package TestNGTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.Comcast.Generic.WebDriverUtility.JavaUtility;
import Com.Comcast.Generic.WebDriverUtility.WebDriverUtility;
import Com.Comcast.crm.GenricCommFilesUtility.BS_Class;
import Com.Comcast.crm.GenricCommFilesUtility.ExcelUtility;
import Com.Comcast.crm.ObjectUtility.Contacts;
import Com.Comcast.crm.ObjectUtility.CreatingNewOrgPage;
import Com.Comcast.crm.ObjectUtility.HomePage;
import Com.Comcast.crm.ObjectUtility.OrganizationInfoPage;
import Com.Comcast.crm.ObjectUtility.OrganizationPage;
import Com.Comcast.crm.ObjectUtility.createNewContactPage;

public class FirstCreatOrgForsameContact extends BS_Class{
  @Test
  public void createContactOrg() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException {
	  ExcelUtility eu=new ExcelUtility();
	  JavaUtility ju=new JavaUtility();
	  HomePage hp=new HomePage(driver);
	  hp.getOrganization().click();
	  OrganizationPage op=new OrganizationPage(driver);
	  op.getCreateOrg().click();
	  CreatingNewOrgPage cop=new CreatingNewOrgPage(driver);
	  String sOrgName=eu.getDataFromExcel("convert",4,4)+ju.getRandomNumber();
	  cop.getOrgname().sendKeys(sOrgName);
	  cop.getSaveButton().click();
	  OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	  WebDriverUtility wu=new WebDriverUtility();
	  Thread.sleep(3000);
	  oip.verifyHeaderMSG(sOrgName);
	  hp.getContact().click();
	  Contacts c=new Contacts(driver);
	  c.getCreateContact().click();
	  createNewContactPage cnc=new createNewContactPage(driver);
	  cnc.createContactWithOrgName("Holkar","9730384041");
	  Thread.sleep(9000);

	  op.serachOrg(sOrgName, driver);
	  op.getClickOnOrg().click();
	  Thread.sleep(9000);
	  
	  
	  
	  
  }
}
