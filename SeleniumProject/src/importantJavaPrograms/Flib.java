package importantJavaPrograms;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Flib {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement (By.name("username")).sendKeys("Admin");
		driver.findElement (By.name("password")).sendKeys("admin123");
driver.findElement(By.xpath("//button[@type='submit']")).click();

		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File target=new File("./screenshots/scroll.jpg");
		Files.copy(src, target);
		//driver.close();
		
	}
	

}
