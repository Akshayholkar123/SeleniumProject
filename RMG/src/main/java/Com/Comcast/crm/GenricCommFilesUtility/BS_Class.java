package Com.Comcast.crm.GenricCommFilesUtility;

import java.io.File;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import Com.Comcast.Generic.DataBaseUtility.DataBaseUtilty;
import Com.Comcast.Generic.WebDriverUtility.UtilityClassObj;
import Com.Comcast.Generic.WebDriverUtility.WebDriverUtility;
import Com.Comcast.crm.ObjectUtility.HomePage;
import Com.Comcast.crm.ObjectUtility.LoginPage;

public class BS_Class{
//original
	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	DataBaseUtilty dLib = new DataBaseUtilty();

	public static WebDriver driver=null;
	public static WebDriver sdriver=null;

    
	@BeforeSuite(groups = { "smoke", "regression" })
	public void connectToDB() throws SQLException {
		// dLib.getDBConnection();
		System.out.println("-- connected to DB --");

	}

  // @Parameters("Browser")
	@BeforeClass(groups = { "smoke", "regression" })
	public void launchBrowser() throws Throwable {
        String browser =fLib.getDataFromPropertyFile("browser");
		
    	//String browser=Browser;
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		
		wLib.maximizeBrowser(driver);}
		else if  (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if  (browser.equalsIgnoreCase("edge")) {
			driver = new InternetExplorerDriver();
		}
		wLib.maximizeBrowser(driver);
         sdriver=driver;
         UtilityClassObj uco=new UtilityClassObj();
         uco.setdriver(driver);
	}

	@BeforeMethod(groups = { "smoke", "regression" })
	public void loginToApp() throws Throwable {
		String URL = fLib.getDataFromPropertyFile("url");
		String UN = fLib.getDataFromPropertyFile("usn");
		String PWD = fLib.getDataFromPropertyFile("pass");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver, URL, UN, PWD);
	}

	@AfterMethod(groups = {"smoke", "regression"})
	public void logoutFromApp() {
		HomePage hp = new HomePage(driver);
		hp.LogOutMethod(driver);
	}

	@AfterClass(groups = { "smoke", "regression" })
	public void closeBrowser() {
		driver.quit();
	}

	@AfterSuite(groups = { "smoke", "regression" })
	public void DisconnectFromDB() throws SQLException {
		// dLib.closeDB();
System.out.println("close db");
	}


}
