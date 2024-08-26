

		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;

		import java.net.HttpURLConnection;
		import java.net.URL;
		import java.util.List;

		public class BrokenImages {
		    public static void main(String[] args) {

		        WebDriver driver = new ChromeDriver();

		        driver.get("https://demoapps.qspiders.com/ui?scenario=1");

		        List<WebElement> images = driver.findElements(By.tagName("img"));

		        for (WebElement img : images) {
		            String imgUrl = img.getAttribute("src");

		            try {
		                HttpURLConnection connection = (HttpURLConnection) (new URL(imgUrl)).openConnection();
		                connection.setRequestMethod("HEAD");
		                connection.connect();

		                int responseCode = connection.getResponseCode();

		                if (responseCode >= 400) {
		                    System.out.println("Broken image found: " + imgUrl);
		                } else {
		                    System.out.println("Valid image: " + imgUrl);
		                }
		            } catch (Exception e) {
		                System.out.println("Error checking image: " + imgUrl);
		                e.printStackTrace();
		            }
		        }

		        driver.quit();
		   

	}

}
