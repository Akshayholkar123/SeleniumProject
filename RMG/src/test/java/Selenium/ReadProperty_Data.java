package Selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Com.Comcast.crm.GenricCommFilesUtility.FileUtility;

public class ReadProperty_Data {

	public static void main(String[] args) throws IOException, InterruptedException  {
		//parameterized mtd for readData from properties file
		FileUtility ft=new FileUtility();
		String browser=ft.getDataFromPropertyFile("browser");
		
		
		
if(browser.equalsIgnoreCase("firefox")) {
	
WebDriver driver=new FirefoxDriver();
driver.manage().window().maximize();
driver.get("http://localhost:8888/");
WebElement username = driver.findElement(By.name("user_name"));
WebElement password = driver.findElement(By.name("user_password"));
username.sendKeys("admin");
password.sendKeys("admin");
driver.findElement(By.id("submitButton")).click();
driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[6]/a")).click();
//driver.quit();


}
else if	(browser.equalsIgnoreCase("chrome")) {
	
System.setProperty("webdriver.chrome.driver","./drivers/chrome_proxy.exe");
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("http://localhost:8888/");
WebElement username = driver.findElement(By.name("user_name"));
WebElement password = driver.findElement(By.name("user_password"));
username.sendKeys("admin");
password.sendKeys("admin");
driver.findElement(By.id("submitButton")).click();
driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[6]/a")).click();
driver.quit();



}
else if(browser.equalsIgnoreCase("ie")) {
	
System.setProperty("webdriver.ie.driver","./drivers/IEDriverServer.exe");
WebDriver driver=new InternetExplorerDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.get("http://localhost:8888/");
WebElement username = driver.findElement(By.name("user_name"));
WebElement password = driver.findElement(By.name("user_password"));
username.sendKeys("admin");
password.sendKeys("admin");
driver.findElement(By.id("submitButton")).click();
driver.findElement(By.xpath("//a[.='Organizations']")).click();

//driver.findElement(By.xpath("(//a[.='Organizations']/following::img)[14]")).click();
Thread.sleep(5000);
//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
driver.findElement(By.xpath("")).click();
//String text1=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//System.out.println(text1);//dvHeaderText
//driver.quit();

}




	}

}
