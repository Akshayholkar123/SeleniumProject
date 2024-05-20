package Com.Comcast.Generic.WebDriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
//	public WebDriver driver;
	public void implicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchToNewTab(WebDriver driver, String partial_url) {
		// switch to child window=========================
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String wh = it.next();
			driver.switchTo().window(wh);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(partial_url)) {
				break;
			}
		}
	}

	public void switchToWindowTitle(WebDriver driver, String partialTitle) {
		// switch to child window=========================
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String wh = it.next();
			driver.switchTo().window(wh);
			String actUrl = driver.getTitle();
			if (actUrl.contains(partialTitle)) {
				break;
			}
		}
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);

	}

	public void switchToFrame(WebDriver driver, String NameOrId) {
		driver.switchTo().frame(NameOrId);
	}

	public void switchToFrame(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public void switchToAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertToDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public Object handledDD(WebElement element) {
		Select sel=new Select(element);
		
	return sel;
	}
	public Object actions(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		
	return act;
	}


	public void selectDropdown(WebElement element, String Visibletext) {
		Select sel = new Select(element);
		sel.selectByVisibleText(Visibletext);
	}

	public void selectDropdown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void selectDropdown(String value, WebElement element) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public void mouseover(WebDriver driver, WebElement elemnet) {
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}

	public void doubleClick(WebDriver driver, WebElement elemnet) {
		Actions act = new Actions(driver);
		act.doubleClick(elemnet).perform();
	}

	public void contextClick(WebDriver driver, WebElement elemnet) {
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement src, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}

	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();

	}

	public void scrollDown(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 100);"); // Scroll down by 100 pixels

	}

	public void scrollUp(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-100);"); // Scroll down by 100 pixels

	}
//	 public void waitUntilElementToBeClickable(WebElement element)
//	 {
//		 button = WebDriverWait(driver, 10).until(
//				    EC.element_to_be_clickable((element));
//				
//
//
//	 }

}
