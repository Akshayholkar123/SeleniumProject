package generic;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class TestActitime extends BaseTest {
@Test
	public void setUp() {
System.setProperty("webdriver.chrome.driver" ,"./drivers/chromedriver.exe");
ChromeOptions ops = new ChromeOptions();
ops.addArguments("--remote-allow-origins=*");

WebDriver driver=new ChromeDriver(ops);
driver .manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}
@AfterMethod
public void tearDown()
{
	driver.quit();
}
public void failed(String failedMethodname) 
{
TakesScreenshot ts=(TakesScreenshot)driver;	
File src=ts.getScreenshotAs(OutputType.FILE);
File dest=new File("./screenshots");
try {
	Files.copy(src, dest);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

}
