package seleniummavenproject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TestSelenium {
@Test
public void setup() {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	 ChromeOptions op = new ChromeOptions();
	 op.addArguments("--remote-allow-origins=*");
	WebDriver driver=new ChromeDriver(op);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("http://127.0.0.1/login.do;jsessionid=1l4514s15e7b2\r\n");
	
	
}
}
