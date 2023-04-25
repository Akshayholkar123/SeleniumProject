package importantJavaPrograms;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDrop {

	public static void main(String[] args) throws InterruptedException {
System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
driver.get("https://www.opencart.com/index.php?route=account/register");
Thread.sleep(3000);

	WebElement drpcountry = driver.findElement(By.id("input-country"));
	Select sel=new Select(drpcountry);
	//sel.selectByVisibleText("Denmark");
	//sel.selectByValue("10");
	//sel.selectByIndex(13);
	List<WebElement> allops = sel.getOptions();
	for(WebElement option :allops) {
		if(option.getText().equals("Cuba"))
		{
			option.click();
		}
		
	}
	
	
	}

}
