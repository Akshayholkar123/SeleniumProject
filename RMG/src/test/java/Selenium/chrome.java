package Selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class chrome {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		//System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeOptions ops=new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		
	WebDriver driver=new ChromeDriver(ops);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	FileInputStream fis=new FileInputStream("./src/test/resources/DataRMG/commonData.properties");
	Properties prop=new Properties();

	String url=prop.getProperty("url");
	driver.get(url);
	WebElement username = driver.findElement(By.name("user_name"));
	WebElement password = driver.findElement(By.name("user_password"));
	//---------------------------------------------------------------------------------------
	String Usn=prop.getProperty("usn");
	username.sendKeys(Usn);
	//-----------------------------------------------------------------------------
	String pass=prop.getProperty("pass");
	password.sendKeys(pass);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[6]/a")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
Random r=new Random();
int orgName =r.nextInt(100) ;
//String ranStr=UUID.randomUUID().toString();
//System.out.println(ranStr);
	driver.findElement(By.name("accountname")).sendKeys("org"+orgName);
WebElement but = driver.findElement(By.xpath("//input[@name='button']"));
but.click();
Thread.sleep(3000);
WebElement adm=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
Thread.sleep(3000);

Actions act=new Actions(driver);
act.moveToElement(adm).perform();
Thread.sleep(3000);
driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();

	}

}
