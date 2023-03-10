package keywordDrivenFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeForInvalidLogin {

	public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("http://127.0.0.1/login.do;jsessionid=1l4514s15e7b2");

	}

}
