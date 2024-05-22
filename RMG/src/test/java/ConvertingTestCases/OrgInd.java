package ConvertingTestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import org.openqa.selenium.support.ui.Select;

public class OrgInd {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		WebDriver driver = null;
		FileInputStream fis = new FileInputStream("./src/main/resources/commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		String Usn = prop.getProperty("usn");
		String pass = prop.getProperty("pass");
		// ========================================================================================================
		FileInputStream fis1 = new FileInputStream("./src/test/resources/DataRMG/dataforRMG.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("orgcondition");
		Row row = sh.getRow(4);
		Cell cell = row.getCell(2);
		Cell cell3 = row.getCell(3);
		Cell cell4 = row.getCell(4);

		Random r = new Random();
		CharSequence orgName = String.valueOf(r.nextInt(100));

		String orgName1 = cell.getStringCellValue() + orgName;
		String actindustry = cell3.getStringCellValue();
		String actType = cell4.getStringCellValue();

		if (browser.equalsIgnoreCase("firefox")) {

			// System.setProperty("webdriver.gecko.driver","./src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		}
		driver.get(url);

		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		// ---------------------------------------------------------------------------------------
		username.sendKeys(Usn);
		// -----------------------------------------------------------------------------
		password.sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[6]/a")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		// String ranStr=UUID.randomUUID().toString();
		// System.out.println(ranStr);
		WebElement name = driver.findElement(By.name("accountname"));
		name.sendKeys(orgName1);
		WebElement dropind = driver.findElement(By.name("industry"));
		Select sel = new Select(dropind);
		sel.selectByVisibleText(actindustry);
		// =============================================================
		WebElement drop2 = driver.findElement(By.name("accounttype"));
		Select sel2 = new Select(drop2);
		sel2.selectByVisibleText(actType);

		driver.findElement(By.xpath("//input[@name='button']")).click();

		// String headerinfo =
		// driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		String industry = driver.findElement(By.id("dtlview_Industry")).getText();

		// verify the the industry and type
		if (actindustry.equals(industry)) {
			System.out.println(industry + " is created==pass");

		} else {
			System.out.println(industry + " is not created==fail");

		}
		String Type = driver.findElement(By.id("dtlview_Type")).getText();

		if (Type.equals(actType)) {
			System.out.println(Type + " is created==pass");

		} else {
			System.out.println(Type + " is not created==fail");

		}

		System.out.println("Last Done");
		driver.quit();

	}

}
