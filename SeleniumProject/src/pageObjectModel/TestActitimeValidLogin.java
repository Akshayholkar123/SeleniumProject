package pageObjectModel;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListner.class)
public class TestActitimeValidLogin extends BaseTest implements IAutoConstant 
		{
	@Test
			public void testActiTime() throws IOException, InterruptedException {
			BaseTest bt = new BaseTest();
			bt.setUp();
			
			LoginPage lp = new LoginPage(driver);
			Flib flib = new Flib();
			
			String validUsername = flib.readPropertyData(PROPPATH, "username1");
			String validPassword = flib.readPropertyData(PROPPATH, "password1");
			
			lp.validLoginToActitime(validUsername, validPassword);
		
			
		}

	}
