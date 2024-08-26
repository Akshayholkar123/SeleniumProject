import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import io.github.bonigarcia.wdm.WebDriverManager;

public class ParisOlmpics {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://olympics.com/en/paris-2024/medals");
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

		Thread.sleep(3000);

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,4000)");
		
		Thread.sleep(5000);
		
		WebElement el = driver.findElement(By.xpath("//div[@data-viewport-type='window']/div/following::div/span[text()='India']/parent::div/child::span[@class='e1oix8v91 emotion-srm-1m7a47k']"));
		
		System.out.println(el.getText());
		
		Thread.sleep(5000);

		WebElement ele = driver.findElement(By.xpath("//div[@data-viewport-type='window']/div/following::div/span[text()='India']/parent::div[@class='emotion-srm-157if6k elhe7kv2']/parent::div[@class='emotion-srm-fvu3gb elhe7kv0']/child::span[@class='e1oix8v91 emotion-srm-5nhv3o']"));

System.out.println(ele.getText());
	}

}
