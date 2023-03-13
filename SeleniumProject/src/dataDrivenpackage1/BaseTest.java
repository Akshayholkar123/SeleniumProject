package dataDrivenpackage1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.selenium.dev/documentation/webdriver/elements/");

        driver.quit();
    }
}
