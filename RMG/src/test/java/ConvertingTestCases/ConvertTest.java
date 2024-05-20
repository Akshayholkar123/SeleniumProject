package ConvertingTestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Com.Comcast.Generic.WebDriverUtility.JavaUtility;
import Com.Comcast.crm.GenricCommFilesUtility.ExcelUtility;
import Com.Comcast.crm.GenricCommFilesUtility.FileUtility;

public class ConvertTest {

	public static void main(String[] args) throws IOException,FileNotFoundException {
		WebDriver driver=null;
		FileInputStream fis=new FileInputStream("./src/test/resources/DataRMG/commonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		
		//parameterized mtd for readData from properties file
		FileUtility ft=new FileUtility();
		String browser=ft.getDataFromPropertyFile("browser");
	    String url=ft.getDataFromPropertyFile("url");
		String Usn=ft.getDataFromPropertyFile("usn");
		String pass=ft.getDataFromPropertyFile("pass");
//parameterized mtd for readData from properties file	---------------------------
		
		ExcelUtility excel=new ExcelUtility();
		String orgName=excel.getDataFromExcel("orgcondition",4,2);
	    JavaUtility ju=new JavaUtility();
	    //get random numfrom JavaUtility
	   int rannum = ju.getRandomNumber();	

	String orgName1=orgName+rannum;
	String todaysDate=ju.getSystemDate();
	System.out.println(todaysDate);
	
	String TodaysDate=ju.getReqDate(30);
	String reqDate=ju.getReqDate(30);
	
	
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
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[6]/a")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
     	//String ranStr=UUID.randomUUID().toString();
     	//System.out.println(ranStr);
	     WebElement name = driver.findElement(By.name("accountname"));
		name.sendKeys(orgName1);
		
		
    	driver.findElement(By.xpath("//input[@name='button']")).click();
	    
	   String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	   if(headerinfo.contains(orgName1))
	   {
		   System.out.println(headerinfo);
		   System.out.println(orgName1+" is created==pass"); 

	   }
	   else
	   {
		   System.out.println(orgName+" is not created==fail"); 

	   }
	   String actorgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
	   if(actorgName.equals(orgName1))
	   {
		   System.out.println(actorgName+" is created==pass"); 

	   }
	   else
	   {
		   System.out.println(actorgName+" is not created==fail"); 

	   }

	   	   
	    System.out.println("Last Done");
	    driver.quit();


	}

}
