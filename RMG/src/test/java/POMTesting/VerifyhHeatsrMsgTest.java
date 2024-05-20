package POMTesting;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Com.Comcast.crm.ObjectUtility.CreatingNewOrgPage;
import Com.Comcast.crm.ObjectUtility.HomePage;
import Com.Comcast.crm.ObjectUtility.LoginPage;
//import Com.Comcast.crm.ObjectUtility.Login;
import Com.Comcast.crm.ObjectUtility.OrganizationPage;

public class VerifyhHeatsrMsgTest {
	@Test
	 public void verifyOrgInfo() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException
	 {
		 WebDriver driver = new ChromeDriver();
		 

		LoginPage l=new LoginPage(driver);
		//l.login();
HomePage hp=new HomePage(driver);
CreatingNewOrgPage creOrg=new CreatingNewOrgPage(driver);
hp.getOrgLink().click();
	 OrganizationPage op=new OrganizationPage(driver);
	 op.getCreateOrg().click();
	 //creOrg.createOrgWithName();
String OrgName=creOrg.getOrgname().getText();
if(OrgName.contains("NASA")) {
Reporter.log("pass",true);
}




		 
	 }


}
