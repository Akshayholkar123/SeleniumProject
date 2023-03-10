package importantJavaPrograms;

import org.junit.Test;

public class Basic {
	@Test
	public void demo() {
		System.out.println("i am from deo method");
		
	}

	/*import java.io.File;
	import java.io.IOException;
	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;




	/*public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://www.selenium.dev/");
		Thread.sleep(3000);
		/*TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/acti.jpg");
		Files.copy(src,dest);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	/*jse.executeScript("window.scrollBy(0,-500)");
	Thread.sleep(2000);
	jse.executeScript("window.scrollBy(500,0)");
	Thread.sleep(2000);
	jse.executeScript("window.scrollBy(-500,0)");
	Thread.sleep(4000);
	WebElement readmore=driver.findElement(By.xpath("//a[@class='selenium-button selenium-ide text-uppercase font-weight-bold']"));
	Actions action=new Actions(driver);
	//action.doubleClick(readmore).perform();
	*/
}
