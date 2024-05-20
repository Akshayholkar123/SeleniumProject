package Selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class TestNG_XML {

	
	@Test
	public void test(XmlTest test) throws IOException,FileNotFoundException, InterruptedException {
		
		String browser=test.getParameter("browser");
		String url=test.getParameter("url");
		String pass=test.getParameter("pass");
		String usn=test.getParameter("usn");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		driver.get(url);
		
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
	
		
		username.sendKeys(usn);		
	
		password.sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		
		driver.quit();

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*FileInputStream fis=new FileInputStream("./src/test/resources/DataRMG/commonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("firefox")) {
			
		//System.setProperty("webdriver.gecko.driver","./src/test/resources/drivers/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://localhost:8888/");
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		username.sendKeys("admin");
		password.sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[6]/a")).click();
		
		
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[6]/a")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	Random r=new Random();
	int orgName =r.nextInt(100) ;
	//String ranStr=UUID.randomUUID().toString();
	//System.out.println(ranStr);
		driver.findElement(By.name("accountname")).sendKeys("org"+orgName);
	WebElement but = driver.findElement(By.xpath("//input[@name='button']"));
	but.click();
	
	/*WebElement adm=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Thread.sleep(3000);

	Actions act=new Actions(driver);
	act.moveToElement(adm).perform();

	driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();


		
		
		
		driver.quit();}*/

}}