import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Prokabaddi {

	public static void main(String[] args)
	{
		ChromeOptions op=new ChromeOptions();
        op.addArguments("use-fake-ui-for-media-stream");

		WebDriver driver=new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.prokabaddi.com/standings");
		List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"table-body\"]/descendant::div[@class=\"table-row-wrap\" and contains(.,'Jaipur Pink Panthers')]/descendant::div[@class=\"table-data points\"]"));




	}

}
