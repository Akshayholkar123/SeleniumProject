 import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinks {
	public static void main(String[] args) {
		WebDriver driver = new HtmlUnitDriver();

		driver.get("https://www.flipkart.com/");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());

		for (WebElement link : links) {
			String url = link.getAttribute("href");

			if (url != null && !url.isEmpty()) {
				try {
					HttpURLConnection connection = (HttpURLConnection) (new URL(url)).openConnection();
					connection.setRequestMethod("HEAD");//no need?  
					connection.connect();                //no need?

					int responseCode = connection.getResponseCode();

					if (responseCode >= 400) {
						System.out.println("Broken link found: " + url);
					} else {
						//System.out.println("Valid link: " + url);
						
					}
				} catch (Exception e) {
					System.out.println("Error checking link: " + url);
					e.printStackTrace();
				}
			}
		}

		driver.quit();
	}
}
