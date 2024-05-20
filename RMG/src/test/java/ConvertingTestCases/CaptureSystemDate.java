package ConvertingTestCases;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaptureSystemDate {

	public static void main(String[] args) throws IOException, InterruptedException {
		Date dateObj=new Date();
SimpleDateFormat simDate=new SimpleDateFormat("yyyy-MM-dd");
String actDate=simDate.format(dateObj);

Calendar cal=simDate.getCalendar();
cal.add(Calendar.DAY_OF_MONTH,30);
String lastDate=simDate.format(cal.getTime());
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

if(browser.equalsIgnoreCase("firefox")) {
	
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
String orgName=sh.getRow(4).getCell(4).getStringCellValue();
driver.findElement(By.id("mouseArea_Organization Name")).sendKeys("NASA");

driver.findElement(By.id("jscal_field_support_start_date")).clear();
driver.findElement(By.id("jscal_field_support_start_date")).sendKeys(actDate);
driver.findElement(By.id("jscal_field_support_end_date")).clear();
driver.findElement(By.name("support_end_date")).sendKeys(lastDate);
driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();

String actStartDate=driver.findElement(By.id("dtlview_Support Start Date")).getText();

String actEndDate=driver.findElement(By.id("dtlview_Support End Date")).getText();

System.out.println("Actual_End_Date "+actEndDate);
if(actDate.contains(actStartDate))
{
	   System.out.println(actDate+" is created==pass"); 

}
else
{
	   System.out.println(actDate+" is not created==fail"); 

}
System.out.println("LastDate "+lastDate);

if(actEndDate.contains(lastDate))
{
	   System.out.println(actEndDate+" is created==pass"); 

}
else
{
	   System.out.println(actEndDate+" is not created==fail"); 

}
//driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();

driver.quit();




	}

}
