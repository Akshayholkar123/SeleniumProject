package Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PayTM {
	
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver(); 
	
ChromeOptions ops=new ChromeOptions();
ops.addArguments("--remote-allow-origins=*");//ops.addArguments("--remote-allow-origins=*");
Actions act=new Actions(driver);

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//driver.get("http://www.amazon.in");
	driver.get("https://tickets.paytm.com/flights/?utm_source=Google-ads&utm_medium=cpc&utm_campaign=G_Web_Search_Flight_Paytm-Brand&utm_content=Paytm_Flights&gad_source=1&gclid=CjwKCAjw7s20BhBFEiwABVIMrRny6QpVxEuujHgokt67wwm0tSKkc8HCeDAbPPkVUkeYdUAcli5yUBoCMXgQAvD_BwE");    
   driver.findElement(By.xpath("//label[@id='rt']")).click();
	driver.findElement(By.xpath("//span[@id='departureDate']")).click();
	WebElement departureDate=driver.findElement(By.xpath("(//div[@class='calendar__day']/following::div[text()='16'])[1]"));
	act.moveToElement(departureDate);
	departureDate.click();
	
	
	driver.findElement(By.xpath("//span[@id='endDate']")).click();
	
	WebElement reurnDate=driver.findElement(By.xpath("(//div[@class='calendar__day']/following::div[text()='20'])[1]"));

	reurnDate.click();
	
	driver.findElement(By.xpath("//span[@id='numPax']")).click();
	
	
	
	
	WebElement ele=driver.findElement(By.xpath("//div[text()='Children']/ancestor::div[@class='pL5lX _2ZktR']//img[@alt='add-icon']"));
act.moveToElement(ele);
ele.click();

driver.findElement(By.xpath("//button[@id='flightSearch']")).click();














//(//img[@src="//travel-assets-akamai.paytm.com/travel/mweb-flights/assets/680aef98.png"])[2]
}

}
