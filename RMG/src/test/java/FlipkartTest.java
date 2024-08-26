import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;




import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartTest {

	public static void main(String[] args)
	{
		/*WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		WebElement ele=driver.findElement(By.xpath("//a[@title='Cart' and @class='_1krdK5 _3jeYYh']"));
	Actions act=new Actions(driver);
	//act.moveToElement(ele).perform();
	ele.click();
	System.out.println("=====pass====");
	driver.quit();*/
		
		
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//span[text()='Fashion']"));
		act.moveToElement(ele).perform();
		List<WebElement> element = driver.findElements(By.xpath("//a[@class='_3490ry' and contains(.,'Men')]"));
//		System.out.println("Number of Men's Top Wear = "+element.size());
		for(WebElement e:element)
		{
			System.out.println(e.getText());
		}
		driver.quit();	
	}

}
