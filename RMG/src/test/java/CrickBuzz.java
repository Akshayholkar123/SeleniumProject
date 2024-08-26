import java.time.Duration;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class CrickBuzz {

	public static void main(String[] args) {

		WebDriver driver=new EdgeDriver();

	
		//WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
            driver.get("https://www.cricbuzz.com/cricket-stats/icc-rankings/men/batting");


            List<WebElement> rows = driver.findElements(By.xpath("//a[@class='text-hvr-underline text-bold cb-font-16']"));
            List<WebElement> rating = driver.findElements(By.xpath("//div[@class='cb-col cb-col-17 cb-rank-tbl pull-right']"));

            for (int i = 0; i <99; i++) {
                String row = rows.get(i).getText();
                String rate=rating.get(i).getText();
               System.out.println(row + " - " +rate);
            }
            driver.quit();
            
	}   
            

}





















