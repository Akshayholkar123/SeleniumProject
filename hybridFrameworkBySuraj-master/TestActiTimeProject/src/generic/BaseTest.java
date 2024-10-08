package generic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

public class BaseTest implements IAutoConstant{
 protected static WebDriver driver;
	@BeforeMethod
	public void setUp() throws IOException
	{
		
		Flib flib = new Flib();
		String browserValue = flib.readPropertyData(PROP_PATH,"browser");
		String url = flib.readPropertyData(PROP_PATH,"url");
		if(browserValue.equalsIgnoreCase("chrome"))
		{
		    ChromeOptions options = new ChromeOptions();

		    options.addArguments("--disable-infobars"); 
			System.setProperty(CHROME_KEY,CHROME_PATH);


			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			driver.get(url);

		}

		else if(browserValue.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECKO_KEY,GECKO_PATH);
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			driver.get(url);

		}

		else
		{
			Reporter.log("invalid browser",true);
		}


	}

	public void failed(String methodName)
	{
		try{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(SCREENSHOT_PATH+methodName+".png");
			Files.copy(src, dest);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
		public void failed(String methodName)
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dest=new File(screenshotParh+methodName+".png");//String screenshotsPath=".screenshots/";
			Files.copy(src,dest);
		}
		public void onTestFailure()
		{
			String failedMethodName=result.getMethod().getMethodName();
			Reporter.Log(failedMethodName+" is the method which got failed",true);
			failed(failedMethodName);
		}

	}
