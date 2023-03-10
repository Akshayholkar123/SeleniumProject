package DataDrivenPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataProvider {
static WebDriver driver;
@Test
@BeforeMethod
public void setup() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	driver.get("http://127.0.0.1/login.do;jsessionid=1l4514s15e7b2");
Thread.sleep(2000);
	}
	//two dimentional array
@org.testng.annotations.DataProvider
public Object[][] dataProviderActitime()
{
	Object[][] data=new Object[5][2];
	data[0][0]="admin";
	data[0][1]="man";

	data[1][0]="admin123";
	data[1][1]="admin";

	data[2][0]="admin12";
	data[2][1]="manager12";

	data[3][0]="ad";
	data[3][1]="manager123";

	data[4][0]="admin";
	data[4][1]="admin123";

	
	return data;
}
@Test(dataProvider = "dataProviderActitime")
public void testInValidActi(String username,String password)
{
	driver.findElement(By.name("username")).sendKeys(username);
	driver.findElement(By.name("pwd")).sendKeys(password);
	driver.findElement(By.id("loginButton")).click();


}

@AfterMethod
public void tearDown()
{	
driver.quit();
}
}
