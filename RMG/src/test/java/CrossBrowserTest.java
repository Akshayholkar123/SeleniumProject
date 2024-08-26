//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class CrossBrowserTest {
//    public static void main(String[] args) throws MalformedURLException {
//        // Hub URL
//        String hubUrl = "http://localhost:4444/wd/hub";
//
//        // Desired Capabilities for Chrome
   //     DesiredCapabilities chromeCapabilities = DesiredCapabilities.Chrome();
//        chromeCapabilities.setCapability("browserName", "chrome");
//        chromeCapabilities.setCapability("platform", "WINDOWS");
//
//        // Desired Capabilities for Firefox
  //     DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();
//        firefoxCapabilities.setCapability("browserName", "firefox");
//        firefoxCapabilities.setCapability("platform", "WINDOWS");
//
//        // Initializing WebDriver with Chrome Capabilities
//        WebDriver chromeDriver = new RemoteWebDriver(new URL(hubUrl), chromeCapabilities);
//        chromeDriver.get("https://www.example.com");
//
//        // Initializing WebDriver with Firefox Capabilities
//        WebDriver firefoxDriver = new RemoteWebDriver(new URL(hubUrl), firefoxCapabilities);
//        firefoxDriver.get("https://www.example.com");
//
//        // Perform your test actions here
//
//        // Quit drivers
//        chromeDriver.quit();
//        firefoxDriver.quit();
//    }
//}
