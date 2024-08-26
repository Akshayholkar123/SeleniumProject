package Com.Comcast.crm.GenricCommFilesUtility;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import Com.Comcast.Generic.DataBaseUtility.DataBaseUtilty;
import Com.Comcast.Generic.WebDriverUtility.UtilityClassObj;
import Com.Comcast.Generic.WebDriverUtility.WebDriverUtility;
import Com.Comcast.crm.ObjectUtility.HomePage;
import Com.Comcast.crm.ObjectUtility.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BS_Class{
	//original
	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	DataBaseUtilty dLib = new DataBaseUtilty();

	public static WebDriver driver=null;
	public static WebDriver sdriver=null;


	@BeforeSuite(alwaysRun = true)
	public void connectToDB() throws SQLException {
		// dLib.getDBConnection();
		System.out.println("-- connected to DB --");

	}

	// @Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws Throwable {
		String browser =fLib.getDataFromPropertyFile("browser");
		System.out.println("batch maven practice");
		//String browser=System.getProperty("browser",fLib.getDataFromPropertyFile("browser"));
		// String Url=System.getProperty("url");
		String url=fLib.getDataFromPropertyFile("browser");
		//String Username=System.getProperty("username");

		//String Password=System.getProperty("password");

		//String browser=Browser;

		if (browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
			WebDriverManager.chromedriver().setup();

			ChromeOptions ops=new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(ops);

			wLib.maximizeBrowser(driver);}
		else if  (browser.equalsIgnoreCase("firefox")) {
			//.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver.exe");

			driver = new FirefoxDriver();
		}
		else if  (browser.equalsIgnoreCase("edge")) {
			driver = new InternetExplorerDriver();
		}
		wLib.maximizeBrowser(driver);        sdriver=driver;
		UtilityClassObj uco=new UtilityClassObj();
		uco.setdriver(driver);
	}

	@BeforeMethod(alwaysRun = true)
	public void loginToApp() throws Throwable {
		String u="http://localhost:8888";
		String URL = fLib.getDataFromPropertyFile("url");
		//String UN = fLib.getDataFromPropertyFile("usn");
		//String PWD = fLib.getDataFromPropertyFile("pass");
		LoginPage lp = new LoginPage(driver);
//		lp.loginToApp(driver, System.getProperty("url"), fLib.getDataFromPropertyFile("usn"),fLib.getDataFromPropertyFile("pass"));
		lp.loginToApp(driver,u, fLib.getDataFromPropertyFile("usn"),fLib.getDataFromPropertyFile("pass"));

		//lp.loginToApp(driver,URL, fLib.getDataFromPropertyFile("usn"),fLib.getDataFromPropertyFile("pass"));

	}

	@AfterMethod(alwaysRun = true)
	public void logoutFromApp() {
		HomePage hp = new HomePage(driver);
		hp.LogOutMethod(driver);
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void DisconnectFromDB() throws SQLException {
		// dLib.closeDB();
		System.out.println("close db");
	}


}
