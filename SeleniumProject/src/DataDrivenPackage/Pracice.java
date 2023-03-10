package DataDrivenPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;


public class Pracice {
	// throws EncryptedDocumentException, IOException, InterruptedException 
	@Test
	public void test() throws EncryptedDocumentException, IOException, InterruptedException
{
System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("http://127.0.0.1/login.do;jsessionid=1l4514s15e7b2");
Filb flib=new Filb();
int rc=flib.getRowCount("./data/testdata.xlsx","invaliddata")	;
System.out.println(rc);

for(int i=1;i<=rc;i++)
{	
String invalidusername=flib.invalidLoginData("./data/testdata.xlsx","invaliddata",i, 0);
driver.findElement(By.name("username")).sendKeys(invalidusername);
Thread.sleep(1000);

String invalidpassword=flib.invalidLoginData("./data/testdata.xlsx","invaliddata",i, 1);
driver.findElement(By.name("pwd")).sendKeys(invalidpassword);
Thread.sleep(1000);

driver.findElement(By.id("LoginButton")).click();
Thread.sleep(1000);

driver.findElement(By.name("username")).clear();

//flib.writeDataInExcel("./data/testdata.xlsx","invaliddata",4,6,"message send by akshay");
}

driver.close();
Reporter.log("invalidTest Succes");
	}
		
	}


