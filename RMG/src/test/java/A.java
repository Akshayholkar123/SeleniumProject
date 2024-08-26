import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class A {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

/*driver.get("https://www.amazon.in/s?k=iphone+15&crid=2ZCODIJTGCBSV&sprefix=iphone+15%2Caps%2C372&ref=nb_sb_ss_pltr-data-refreshed_1_9");

String mobile=driver.findElement(By.xpath("//span[text()='Apple iPhone 15 (128 GB) - Black']")).getText();


String text=driver.findElement(By.xpath("//span[text()='Apple iPhone 15 (128 GB) - Black']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price-whole']")).getText();
System.out.println(mobile+" ");
System.out.println(text);*/



/*driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
String s=driver.findElement(By.xpath("//tbody//tr[last()-1]//th")).getText();
System.out.println(s+" - ");
String text=driver.findElement(By.xpath("//div[@class='relative top-4 pb-5 pt-3']//tr[3]/td[last()]")).getText();

	System.out.print(text);*/


driver.get("https://www.redbus.in/");
driver.findElement(By.id("src")).sendKeys("bangalore");
WebElement ban=driver.findElement(By.xpath("//text[text()='Bangalore']"));
Actions act=new Actions(driver);
act.moveToElement(ban).perform();
ban.click();
driver.findElement(By.id("dest")).sendKeys("Pune");
WebElement pune=driver.findElement(By.xpath("//text[text()='Pune']"));
act.moveToElement(pune).perform();
pune.click();

//26/07/24 click

driver.findElement(By.xpath("//div[@class='DayTiles__CalendarDaysBlock-sc-1xum02u-0 isgDNj']//span[text()='26']")).click();


driver.findElement(By.xpath("//button[@id='search_button']")).click();

driver.findElement(By.xpath("//div[@id='mBWrapper']//li[@id='17559446']")).click();


	}

}
