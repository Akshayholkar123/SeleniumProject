import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	driver.get("https://demoapps.qspiders.com/ui/frames?sublist=0");
	WebElement ele = driver.findElement(By.xpath("//iframe[@class='w-full h-96']"));
	Thread.sleep(2000);
	driver.switchTo().frame(ele);
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Akshay Holkar");


	}

}
