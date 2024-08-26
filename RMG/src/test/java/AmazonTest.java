//import java.time.Duration;
//import java.util.List;
//import java.util.Set;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.sikuli.api.robot.Key;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class AmazonTest {
//
//	public static void main(String[] args) throws InterruptedException {
//
//		WebDriverManager.chromedriver().setup();
//
//		ChromeOptions ops = new ChromeOptions();
//		ops.addArguments("--remote-allow-origins=*");
//		ops.addArguments("--disable-notifications"); // Corrected argument
//		WebDriver driver = new ChromeDriver(ops);
//
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.get("http://www.amazon.in");
//
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone15", Keys.ENTER);
//		// driver.findElement(By.id("nav-search-submit-button")).click();
//
//		// Click on the first iPhone 15 product in the search results
//		driver.findElement(By.xpath("//span[text()='Apple iPhone 15 (128 GB) - Black']")).click();
//		Set<String> allId = driver.getWindowHandles();
//		for (String id : allId) {
//
//			driver.switchTo().window(id);
//			if (driver.getTitle().contains("Apple iPhone 15")) {
//				break;
//			}
//		}
//
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,500)");
//
//		// List all the colors available for the iPhone 15
//		List<WebElement> colorList = driver.findElements(By.xpath("//img[@class='imgSwatch']"));
//		for (WebElement color : colorList) {
//			System.out.println(color.getAttribute("alt"));
//		}
//
//		// Close the browser
//		driver.quit();*/
//		
//		
//		
//		
//		
//		
//	}
//}
