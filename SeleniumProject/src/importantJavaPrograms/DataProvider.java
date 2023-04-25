package importantJavaPrograms;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataProvider {

	protected static WebDriver driver;
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(ops);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("http://laptop-o03f5p6f/login.jsp");
		Thread.sleep(3000);
	}
@AfterMethod
public void tearDown()
{
	driver.quit();
}
@Test(dataProvider ="dataProviderActitime")
public void inValidLoginToActitime(String username,String password)
{
driver.findElement(By.name("username")).sendKeys(username);
driver.findElement(By.name("pwd")).sendKeys(password);
driver.findElement(By.id("loginButton")).click();
}
@org.testng.annotations.DataProvider
public Object[][] dataProviderActitime()
{
Object[][] data=new Object[5][2];

data[0][0]="admin";
data[0][1]="adm";

data[1][0]="adn";
data[1][1]="adm";

data[2][0]="admin";
data[2][1]="manger123";

data[3][0]="manager";
data[3][1]="admin";

data[4][0]="admin";
data[4][1]="mgr";
return data;

}
}