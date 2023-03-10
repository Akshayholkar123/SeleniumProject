package dataDrivenpackage1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Flib flib=new Flib();
	String	username1=flib.readPropertyData("./data/config.properties","usernam");
		
		String password1=flib.readPropertyData("./data/config.properties","passwor");
		
		driver.findElement(By.name("username")).sendKeys(username1);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();


	}

}
