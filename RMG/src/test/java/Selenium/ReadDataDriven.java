package Selenium;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;

import net.bytebuddy.utility.RandomString;

public class ReadDataDriven {	

		public static void main(String[] args) throws IOException, InterruptedException  {
	FileInputStream fis=new FileInputStream("./src/test/resources/DataRMG/commonData.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String browser=prop.getProperty("browser");
	if(browser.equalsIgnoreCase("firefox")) {
		
	//System.setProperty("webdriver.gecko.driver","./src/test/resources/drivers/geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*else if	(browser.equalsIgnoreCase("chrome")) {
		
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
	Thread.sleep(5000);
	driver.findElement(By.xpath("//a[.='Organizations']")).click();

	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	//driver.findElement(By.xpath("(//a[.='Organizations']/following::img)[14]")).click();
	Thread.sleep(5000);
	//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	//String text1=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	//System.out.println(text1);//dvHeaderText
	//driver.quit();*/

	



		}


}
