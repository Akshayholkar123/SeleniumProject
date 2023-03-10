package importantJavaPrograms;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


class ReaddataFromExcel 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=	new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("http://127.0.0.1/login.do;jsessionid=1l4514s15e7b2");
		Thread.sleep(3000);

		ReadData RD=new ReadData();
		String validusername=RD.readData("./data/testdata.xlsx","validdata" ,1, 0);
		String validpassword=RD.readData("./data/testdata.xlsx","validdata" ,1, 1);
		driver.findElement(By.name("username")).sendKeys(validusername);
		driver.findElement(By.name("pwd")).sendKeys(validpassword);
		driver.findElement(By.id("loginButton")).click();
		String title=driver.getTitle();
		System.out.println(title+" is the title of this page");
		Thread.sleep(2000);
		driver.close();

		
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
}
	
	
	
				
				
	
	}
