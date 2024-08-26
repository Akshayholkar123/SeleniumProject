import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoQS {

	public static void main(String[] args) throws InterruptedException
	{
		//		https://demoapps.qspiders.com/ui/browser/Login
		//			https://demoapps.qspiders.com/ui/browser/SignUp
		//			https://demoapps.qspiders.com/ui/browser/SignUpPage



		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/browser/multipleWindow?sublist=2");
		driver.findElement(By.xpath("//button[@id='browserButton3']")).click();
		Set<String> wh = driver.getWindowHandles();
		for(String win:wh)
		{
			driver.switchTo().window(win);
			String url=(driver.getCurrentUrl());

			if(url.equals("https://demoapps.qspiders.com/ui/browser/Login"))
			{
				driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Akshay");
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("973038485@Aa");
				driver.findElement(By.xpath("//button[text()='Login']")).click();
             
				String url1=driver.getCurrentUrl();
				System.out.println(url1);
				Thread.sleep(4000);

				driver.close();


			}



			if(url.equals("https://demoapps.qspiders.com/ui/browser/SignUp"))
			{
				driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Akshay");
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys("aholkar01@gmail.com");
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("973038485@Aa");
				driver.findElement(By.xpath("//button[text()='Sign Up']")).click();


				String url1=driver.getCurrentUrl();
				System.out.println(url1);
				Thread.sleep(4000);
				driver.close();

			}
			if(url.equals("https://demoapps.qspiders.com/ui/browser/SignUpPage"))
			{
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys("a@gmail.com");
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("973038485@Aa");
				driver.findElement(By.xpath("//input[@id='confirm-password']")).sendKeys("973038485@Aa");
				driver.findElement(By.xpath("//button[text()='Sign Up']")).click();

				String url1=driver.getCurrentUrl();
				System.out.println(url1);
				Thread.sleep(4000);

				driver.quit();


			}


		}
	}
}
