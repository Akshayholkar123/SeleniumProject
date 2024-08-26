import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HyrTutorial {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
driver.findElement(By.xpath("(//div[@class='container']/descendant::input[@name='name'])[1]")).sendKeys("Akshay");
driver.findElement(By.xpath("//label[contains(.,'First Name')]/following-sibling::*[position()=2]")).sendKeys("Akshay");

//driver.findElement(By.xpath("(//div[@class='container']/descendant::input[@name='name'])[2]")).sendKeys("Holkar");

driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("ah@gmail.com");
driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("12345opi");

driver.findElement(By.xpath("//label[.='Password']/parent::div/following-sibling::input")).sendKeys("12345opi");

	
	}

}
