package pageObjectModel;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

public class BaseTest implements IAutoConstant {
	static WebDriver driver;
	@BeforeMethod
	
	public  void setUp() throws IOException
	{
		Flib flib=new Flib();
		String browserValue=flib.readPropertyData(PROPPATH,"browser");
		if (browserValue.equalsIgnoreCase("chrome"))
		{
			
		System.setProperty(CHROMEKEY,CHROMEPATH);
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(ops);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get(url);
			}
	else if(browserValue.equalsIgnoreCase("firefox")) 
	{
		System.setProperty(GECKOKEY,GECKOPATH);
		 driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get(url);

		
	}
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	public void failed(String methodName) throws IOException
	{TakesScreenshot ts =(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest=new File("./screenshots/"+methodName+".jpg");
	Files.copy(src, dest);
		
	}

}
