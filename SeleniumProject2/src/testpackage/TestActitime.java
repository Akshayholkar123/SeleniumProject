package testpackage;


import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.CustomListner;
import generic.Flib;
import pagepackage.LoginPage;
@Listeners(CustomListner.class)
public class TestActitime extends BaseTest{
	
	@Test
	public void testValidLogin() throws IOException, InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		Flib flib = new Flib();
		lp.validLoginToActiTime(flib.readPropertyData(propPath,"usernam"),flib.readPropertyData(propPath,"password"));
	}

}
