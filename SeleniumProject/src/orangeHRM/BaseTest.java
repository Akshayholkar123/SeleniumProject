package orangeHRM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant{
	public static WebDriver driver;
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		System.setProperty(CHROME_KEY, CHROME_PATH);
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get(orangehrm);
		Thread.sleep(3000);
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
