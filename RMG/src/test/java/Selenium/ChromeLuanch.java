package Selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ChromeLuanch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebDriver driver=new ChromeDriver();
		WebDriver driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.get("https://www.amazon.in");
String iphone15="iphone15";
WebElement activeElement = driver.switchTo().activeElement();
activeElement.sendKeys(iphone15);
	}

}
