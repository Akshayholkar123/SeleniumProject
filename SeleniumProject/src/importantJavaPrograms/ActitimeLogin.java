package importantJavaPrograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ActitimeLogin {

	public static void main(String[] args) throws InterruptedException {
System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");//chrome key and holds chrome path
ChromeOptions ops=new ChromeOptions();
ops.addArguments("--remote-allow-origins=*");
WebDriver driver= new ChromeDriver(ops);
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
driver.get("http://laptop-o03f5p6f/login.do");
driver.findElement(By.name("username")).sendKeys("admin");
driver.findElement(By.name("pwd")).sendKeys("manager");
driver.findElement(By.id("loginButton")).click();
Thread.sleep(1000);
//WebElement element = driver.findElement(By.xpath("//*[@value='Create New Tasks']"));
//element.click();
Thread.sleep(1000);
driver.findElement(By.linkText("Reports")).click();
//driver.findElement(By.linkText("Users")).click();
driver.findElement(By.xpath("//*[@id=\"ext-comp-1006\"]/span")).click();
driver.findElement(By.xpath("//*[@id=\"reportName_4\"]")).click();
	}

}
