package DataDrivenPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeywordBaseTest {

	public static void main(String[] args) throws InterruptedException, IOException {
System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("http://127.0.0.1/login.do;jsessionid=1l4514s15e7b2");
Thread.sleep(3000);
KeyWordFlib flib=new KeyWordFlib();
String validusername=flib.readPropertyData("./data/config.properties","username");
driver.findElement(By.name("username")).sendKeys(validusername);
String validpassword=flib.readPropertyData("./data/config.properties", "password");
Thread.sleep(1000);

driver.findElement(By.name("pwd")).sendKeys(validpassword);
Thread.sleep(1000);

driver.findElement(By.id("LoginButton")).click();


	}

}
