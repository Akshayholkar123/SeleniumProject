import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QScenario {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Akshay Holkar");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("aholkar01@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("9730384985@Aa");
		driver.findElement(By.xpath("//*[name()='svg' and .='Show Password']")).click();



	}

}
