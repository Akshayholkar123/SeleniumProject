package TestNGTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import freemarker.core.JavaScriptOutputFormat;

public class Practice {
	
	@Test
	public void practicetest() throws InterruptedException
	{
		
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://www.amazon.in/");
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("as it is whey protien 1 kg ");
driver.findElement(By.id("nav-search-submit-button")).click();
//WebElement element=driver.findElement(By.xpath("//span[text()='iPhone 15 Pro (128 GB) - White Titanium']/ancestor::div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
//System.out.println(element.getText());
driver.findElement(By.xpath("//button[@id='a-autoid-6-announce']")).click();
Thread.sleep(10000);
//ChromeOptions ops=new ChromeOptions();
//ops.addArguments("--disable-notificationbs");
JavascriptExecutor jse=(JavascriptExecutor)driver;
jse.executeScript("window.scrollBy(0,300)");
Thread.sleep(7000);

//WebElement cart=driver.findElement(By.xpath("//span[@class='nav-cart-icon nav-sprite']"));
//cart.click();
WebDriverWait wait = new WebDriverWait(driver, null); 
WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='nav-cart-icon nav-sprite']")));
element.click();

}
	}
