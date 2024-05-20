package generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverCommonLib1 extends BaseTest
{
	public String getTitleOfThePage(String PageName)
	{
		String actualTitle=driver.getTitle();
		return actualTitle;
	}
	public void selectOptionsOfDropDown(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
		}
	public void selectOptionsOfDropDown(WebElement element,String value) 
	{
		Select sel=new Select (element);
		sel.selectByValue(value);
	}
	public void selectOptionOfDropDown(String text,WebElement element) 
	{
		Select sel=new Select (element);
		sel.selectByVisibleText(text);
	}
	public void switchToFrame(int index) 
	{
		driver.switchTo().frame(index);
		
	}
	public void switchToFrame(String nameOrd) 
	{
		driver.switchTo().frame(nameOrd);		
	}
	public void switchToFrame(WebElement frameElement) 
	{
		driver.switchTo().frame(frameElement);
			}
	public void rightClick(WebElement targetElement)
	{
		Actions act=new Actions(driver);
		act.contextClick(targetElement).perform();
		}
	
		public void doubleclickOnWebElement(WebElement targetElement) 
		{
			Actions act=new Actions(driver);
			act.doubleClick(targetElement).perform();
		}
		public void mouseHover(WebElement targetElement)
		{
			Actions act=new Actions(driver);
			act.moveToElement(targetElement).perform();
	    }
		public void dragandDropWebElement(WebElement src,WebElement trg)
		{
			Actions act=new Actions(driver);
			act.dragAndDrop(src, trg).perform();
		}
		public void scrollDown(int pixels)
		{
			JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+pixels+")");
		}
		public void scrollup(int pixels)
		{
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,"+(-pixels)+")");
		}
		public void scrollLeft(int pixels)
		{
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("window.scrolBy("+(-pixels)+",0)");
			}
		public void scrollRight(int pixels)
		{
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("window.scrolBy("+pixels+",0)");
		}
		public void scrollUpToParticularElement(WebElement element)
		{
			Point point = element.getLocation();
			int xaxisdist=point.getX();
			int yaxisdist=point.getY();
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy("+xaxisdist+","+yaxisdist+")");
		}
		
		public void hitEnterbutton() throws AWTException {
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
		}
		public void generatePrintPopUp() throws AWTException 
		{
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_P);			
			robot.keyRelease(KeyEvent.VK_P);
			robot.keyRelease(KeyEvent.VK_CONTROL);

		}
		public void copy() throws AWTException {
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_C);
		}
public void printAllOptionsOfDropDown(WebElement element)
{
	Select sel=new Select(element);
	List<WebElement> allOps = sel.getOptions();
	for(WebElement we:allOps)
	{
		String text=we.getText();
		System.out.println(text);
	}
	}
		public void printPop() throws AWTException
		{
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_P);
			robot.keyRelease(KeyEvent.VK_P);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
		}
	
	
	
}
	
