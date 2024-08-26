import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CrickKedda {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();

		
		//WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
            driver.get("https://www.sportskeeda.com/go/womens-t20-asia-cup/points-table");
            List<WebElement> ele = driver.findElements(By.xpath("//div[@data-group-title='Group A']/descendant::tbody/tr[*]/td[*]"));

for(WebElement data:ele)
{
	System.out.println(data.getText());
}
	}

}
