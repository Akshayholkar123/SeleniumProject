package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ReadCmdLineDataTest {

	@Test
	public void readaDataCmd()
	{
		String browser =System.getProperty("browser");
		String url=System.getProperty("url");
		String usn=System.getProperty("pass");
		String pass=System.getProperty("usn");

//		System.out.println("URL"+url);
//		System.out.println("browser"+browser);
//		System.out.println("usn"+usn);
//		System.out.println("pass"+pass);
//		String browser=System.getProperty(browser);
//		String Usn=System.getProperty(usn);
//		String pass=System.getProperty(pass);
//		String url=System.getProperty(url);

		if(browser.equalsIgnoreCase("firefox")) {
			
		//System.setProperty("webdriver.gecko.driver","./src/test/resources/drivers/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		//---------------------------------------------------------------------------------------
		username.sendKeys(usn);
		//-----------------------------------------------------------------------------
		password.sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		}

	}
}
