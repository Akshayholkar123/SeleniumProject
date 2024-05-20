package TestNGTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataProviderAmazonTest {
	public static void main(String[] args) {
		getProductInfoTest();	
	}
	
	public static void getProductInfoTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/s?k=iphone&crid=K3CQXX0Y8B83&sprefix=iphone%2Caps%2C253&ref=nb_sb_noss_1");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
	}
}