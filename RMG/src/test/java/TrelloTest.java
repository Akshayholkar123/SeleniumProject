import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.google.common.io.Files;


public class TrelloTest {
@Test
	public static void demoTest() throws IOException {
		//WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://trello.com/home");
		driver.findElement(By.xpath("//div[@class='Buttonsstyles__ButtonGroup-sc-1jwidxo-3 jnMZCI']/child::a[text()='Log in']")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("aholkar01@gmail.com");

		driver.findElement(By.xpath("//button[@id='login-submit']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("9730384985");
		driver.findElement(By.xpath("//button[@id='login-submit']")).click();

		driver.findElement(By.xpath("//p[text()='Create']")).click();

		WebElement ele=driver.findElement(By.xpath("//button[@data-testid='header-create-board-button']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		ele.click();

		driver.findElement(By.xpath("//input[@data-testid='create-board-title-input']")).sendKeys("Testing");

		Robot rb=new Robot();

		driver.findElement(By.xpath("//button[text()='Create']")).click();

		driver.findElement(By.xpath("//textarea[@data-testid='list-name-textarea']")).sendKeys("test");


		driver.findElement(By.xpath("//button[text()='Add list']")).click();

		driver.findElement(By.xpath("//textarea[@placeholder='Enter list title…']")).sendKeys("java");

		driver.findElement(By.xpath("//button[@data-testid='list-composer-add-list-button']")).click();

		driver.findElement(By.xpath("//textarea[@placeholder='Enter list title…']")).sendKeys("manual");
		rb.keyPress(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//textarea[@placeholder='Enter list title…']")).sendKeys("Automation");
		rb.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//span[@data-testid='CloseIcon']")).click();

		driver.findElement(By.xpath("(//button[@data-testid='list-add-card-button'])[1]")).click();

		driver.findElement(By.xpath("//textarea[@placeholder='Enter a name for this card…']")).sendKeys("oops");
		rb.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a name for this card…']")).sendKeys("STLC");
		rb.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a name for this card…']")).sendKeys("SDLC");
		rb.keyPress(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//textarea[@placeholder='Enter a name for this card…']")).sendKeys("collections");
		rb.keyPress(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//textarea[@placeholder='Enter a name for this card…']")).sendKeys("Test_plan");
		rb.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a name for this card…']")).sendKeys("Synchronization");
		rb.keyPress(KeyEvent.VK_ENTER);


		driver.findElement(By.xpath("//textarea[@placeholder='Enter a name for this card…']")).sendKeys("maven_profiling");
		rb.keyPress(KeyEvent.VK_ENTER);

		//driver.findElement(By.xpath("//button[@data-testid='list-card-composer-add-card-button']")).click();

		WebElement src1=driver.findElement(By.xpath("//a[text()='oops']"));
		WebElement dest1=driver.findElement(By.xpath("(//button[@data-testid='list-add-card-button'])[1]"));

		act.dragAndDrop(src1,dest1).perform();

		WebElement src2=driver.findElement(By.xpath("//a[text()='collections']"));
		WebElement dest2=driver.findElement(By.xpath("(//button[@data-testid='list-add-card-button'])[1]"));

		act.dragAndDrop(src2,dest2).perform();

		WebElement src3=driver.findElement(By.xpath("//a[text()='SDLC']"));
		WebElement dest3=driver.findElement(By.xpath("(//button[@data-testid='list-add-card-button'])[2]"));

		act.dragAndDrop(src3,dest3).perform();

		WebElement src4=driver.findElement(By.xpath("//a[text()='STLC']"));
		WebElement dest4=driver.findElement(By.xpath("(//button[@data-testid='list-add-card-button'])[2]"));

		act.dragAndDrop(src4,dest4).perform();


		WebElement src5=driver.findElement(By.xpath("//a[text()='Test_plan']"));
		WebElement dest5=driver.findElement(By.xpath("(//button[@data-testid='list-add-card-button'])[2]"));

		act.dragAndDrop(src5,dest5).perform();
		
		WebElement src=driver.findElement(By.xpath("//a[text()='Synchronization']"));
		WebElement dest=driver.findElement(By.xpath("(//button[@data-testid='list-add-card-button'])[3]"));

		act.dragAndDrop(src,dest).perform();


		WebElement src6=driver.findElement(By.xpath("//a[text()='maven_profiling']"));
		WebElement dest6=driver.findElement(By.xpath("(//button[@data-testid='list-add-card-button'])[3]"));

		act.dragAndDrop(src6,dest6).perform();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src0=ts.getScreenshotAs(OutputType.FILE);
		File dest0=new File("/.screenshots+"+"/trello"+".png");
       Files.copy(src0, dest0);		

       driver.quit();

	}

}
