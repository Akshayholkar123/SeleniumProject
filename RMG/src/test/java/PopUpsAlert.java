import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PopUpsAlert {

	public static void main(String[] args)
	{
		ChromeOptions op=new ChromeOptions();
        op.addArguments("use-fake-ui-for-media-stream");

		WebDriver driver=new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://webcamtests.com/check");
		driver.findElement(By.xpath("//button[@id='webcam-launcher']")).click();


	}

}
