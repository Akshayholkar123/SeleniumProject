package importantJavaPrograms;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriver {

	public static void main(String[] args) 
	{
		/*System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));*/
System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe") ;       
        WebDriver driver = new FirefoxDriver();
                driver.manage().window().maximize();
        

driver.get("https://www.flipkart.com/");
	}

}
