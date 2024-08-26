import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LensCart {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.lenskart.com/");
		WebElement ele=driver.findElement(By.id("lrd9"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		ele.click();
		System.out.println("=====pass====");
		driver.findElement(By.xpath("//div[text()='Bangalore']")).click();
		driver.quit();


	}

}
