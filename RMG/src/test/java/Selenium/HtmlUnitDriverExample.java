package Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverExample {
    public static void main(String[] args) {
        // Initialize HtmlUnitDriver
        WebDriver driver = new HtmlUnitDriver();

        try {
            // Open a webpage
            driver.get("https://www.amazone.com");

            // Print the title of the page
            String title = driver.getTitle();
            System.out.println("Page title is: " + title);
        } finally {
            // Close the browser
            driver.quit();
            System.out.println("==executed===");
        }
    }
}
