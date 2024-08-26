import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonePract {

	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone 15"+Keys.ENTER);
		driver.findElement(By.xpath("//span[@class='rush-component s-latency-cf-section']//h2[text()='Results']/ancestor::span[@class='rush-component s-latency-cf-section']/descendant::button[1]")).click();

	}

}
