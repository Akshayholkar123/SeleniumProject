package orangeHRM;

import java.io.IOException;

import org.testng.annotations.Test;

public class TestValidorangrHRM extends BaseTest {

@Test
public void testOrangeHrm() throws IOException, InterruptedException
{
	
	LoginPage lp=new LoginPage(driver);
	Flib flib=new Flib();

lp.loginToOrangeHrm(flib.readPropertyData(PROP_PATH,"username"),flib.readPropertyData(PROP_PATH,"password"));			
}
}
