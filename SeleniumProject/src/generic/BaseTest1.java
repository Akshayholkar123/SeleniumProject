package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest1 implements IAutoConstant{
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
if (browservalue.equalsIgnoreCase("chrome"))
{
	System.setProperty(CHROME_KEY, CHROME_PATH);
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	Thread.sleep(2000);
	driver.get("https://www.flipkart.com/");
}
else if(browservalue.equalsIgnoreCase("firefox")) 
{
	System.setProperty(GECKO_KEY, GECKO_PATH);
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	Thread.sleep(2000);
	driver.get("https://www.flipkart.com/");

	
}
	}
	}