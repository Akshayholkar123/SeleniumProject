package importantJavaPrograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class RTP {
	@Parameters({"browserValue","vusername","vpassword"})
	@Test
	public void openBrowser(String browserValue,String vusername,String vpassword) {
	if(browserValue.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver.", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("http://www.google.com");
		driver.findElement(By.name("username")).sendKeys(vusername);
		driver.findElement(By.name("pwd")).sendKeys(vpassword);
		driver.findElement(By.id("loginButton")).click();

	}
	else if(browserValue.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver.", "./drivers/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("http://www.google.com");
		driver.findElement(By.name("username")).sendKeys(vusername);
		driver.findElement(By.name("pwd")).sendKeys(vpassword);
		driver.findElement(By.id("loginButton")).click();

	}
	else {
		Reporter.log("wrong browserValue",true);
	}
}
}