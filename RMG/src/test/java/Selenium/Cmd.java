package Selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class Cmd {
	@Test
	public static void cmd() throws IOException{
		System.out.println("data");
		
	
		String browser=System.getProperty(null);
		String Usn=System.getProperty(null);
		String pass=System.getProperty(null);
		String url=System.getProperty(null);

		if(browser.equalsIgnoreCase("firefox")) {
			
		//System.setProperty("webdriver.gecko.driver","./src/test/resources/drivers/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		//---------------------------------------------------------------------------------------
		username.sendKeys(Usn);
		//-----------------------------------------------------------------------------
		password.sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		}		
	}

}
