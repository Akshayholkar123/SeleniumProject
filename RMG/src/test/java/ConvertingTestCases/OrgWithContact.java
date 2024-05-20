package ConvertingTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.reporters.jq.Main;

class OrgWithContact{
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
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
		
		 driver.findElement(By.xpath("//a[.='Organizations' and @href=\"index.php?module=Accounts&action=index\"]")).click();
		 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		 
		    	String ranStr=UUID.randomUUID().toString();
     	//System.out.println(ranStr);
	   driver.findElement(By.name("accountname")).sendKeys("NASA"+ranStr);
	
		
       driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
Thread.sleep(1000);
       driver.findElement(By.xpath("(//a[.='Contacts'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Holkar011");
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		
		//now i have to wsitch to child window------------------------
		
         // switch to child window=========================
	Set	<String> set=driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	while(it.hasNext())
	{
		String wh=it.next();
		driver.switchTo().window(wh);
		String actUrl=driver.getCurrentUrl();
		if(actUrl.contains("module=Accounts&action"))
		{
			break;
		}
	}
	driver.findElement(By.id("search_txt")).sendKeys("Mindtree");
	driver.manage().window().maximize();
	driver.findElement(By.id("1")).click();
String LastName="Holkar011";
	Set	<String> set1=driver.getWindowHandles();
	Iterator<String> it1 = set1.iterator();

	while(it1.hasNext())
	{
		String wh=it1.next();
		driver.switchTo().window(wh);
		String actUrl=driver.getCurrentUrl();
		if(actUrl.contains("Contacts&actions"))
		{
			break;
		}
	}

	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	   String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	   String dispOrg=driver.findElement(By.id("mouseArea_Organization Name")).getText();
	   String orgname="Mindtree";
	   if(dispOrg.contains(orgname))
	   {
		   System.out.println(headerinfo);
		   System.out.println(dispOrg+" is created==pass"); 

	   }
	   else
	   {
		   System.out.println(dispOrg+" is not created==fail"); 

	   }

	String dispLastName=driver.findElement(By.id("mouseArea_Last Name")).getText();
	   if(dispLastName.contains(lastName))
	   {
		   System.out.println(headerinfo);
		   System.out.println(lastName+" is created==pass"); 

	   }
	   else
	   {
		   System.out.println(lastName+" is not created==fail"); 

	   }

	//System.out.println("pass");	
       driver.quit();
       // driver.findElement(By.xpath("//a[text()='Contacts' and @href='index.php?module=Contacts&action=index')")).click();
		//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();


		//driver.findElement(By.id("mobile")).sendKeys(mobileNumber);
		
		
		
	}
}