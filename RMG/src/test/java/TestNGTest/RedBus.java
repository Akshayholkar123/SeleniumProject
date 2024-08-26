package TestNGTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RedBus {
	
	@Test
	public void redBus() throws InterruptedException
	{
		//WebDriverManager.chromedriver().setup();
		ChromeOptions ops=new ChromeOptions();
		WebDriver driver=new ChromeDriver(ops);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.redbus.in/");
	WebElement src=	driver.findElement(By.xpath("//input[@id='src']"));
	src.click();	src.sendKeys("ban");
	driver.findElement(By.xpath("//text[text()='Bangalore']")).click();

		WebElement dest=driver.findElement(By.xpath("//input[@id='dest']"));
		
		dest.click();
		dest.sendKeys("pun");
		driver.findElement(By.xpath("//text[text()='Pune']")).click();
	
	WebElement calender=driver.findElement(By.xpath("//span[@class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 fgdqFw']"));
	calender.click();
//	driver.findElement(By.xpath("//span[@class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 fgdqFw']"));
//	WebDriverWait wait=new WebDriverWait(driver, null);
	Thread.sleep(3000);
    ops.addArguments("--disable-notifications"); 

	driver.findElement(By.xpath("//button[@id='search_button']")).click();
	//WebElement elel=wait.until(ExpectedConditions.elementToBeClickable(ele));

		
		
	}

}
