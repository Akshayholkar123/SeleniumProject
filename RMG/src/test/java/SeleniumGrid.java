import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGrid {
	@Test
	public void testGrid() throws  URISyntaxException, MalformedURLException
	{
		URL url=new URI("http://localhost:4444").toURL();
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
	//	cap.setBrowserName("firefox");
       // DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();

		cap.setPlatform(Platform.WINDOWS);
		
		RemoteWebDriver driver=new RemoteWebDriver(url,cap);
        driver.get("https://flipkart.com");
        }

}
