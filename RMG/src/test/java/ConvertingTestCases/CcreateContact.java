package ConvertingTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CcreateContact {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver=null;
		FileInputStream fis=new FileInputStream("./src/test/resources/DataRMG/commonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String browser=prop.getProperty("browser");
	    String url=prop.getProperty("url");
		String Usn=prop.getProperty("usn");
		String pass=prop.getProperty("pass");
//========================================================================================================
		FileInputStream fis1=new FileInputStream("./src/test/resources/DataRMG/dataforRMG.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("convert");

        String lastName=sh.getRow(7).getCell(3).getStringCellValue();
        
        String mobileNumber=sh.getRow(7).getCell(4).getStringCellValue();
        
        String orgName=sh.getRow(4).getCell(4).getStringCellValue();

		if(browser.equalsIgnoreCase("firefox")) {
			
		//System.setProperty("webdriver.gecko.driver","./src/test/resources/drivers/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		if(browser.equalsIgnoreCase("chrome"))
		{			
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		}	
		driver.get(url);

		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		//---------------------------------------------------------------------------------------
		username.sendKeys(Usn);
		//-----------------------------------------------------------------------------
		password.sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
//click on contact tab========================================
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		driver.findElement(By.id("mobile")).sendKeys(mobileNumber);
        driver.findElement(By.id("mouseArea_Organization Name")).sendKeys(orgName);
        driver.findElement(By.id("mouseArea_Organization Name")).sendKeys("NASA");

        driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
        driver.findElement(By.xpath("//tr[@class='slvtColData']")).click();
      
        
       driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	System.out.println("pass");
	}

}
