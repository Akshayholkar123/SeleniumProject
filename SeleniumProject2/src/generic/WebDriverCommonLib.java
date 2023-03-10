package generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class WebDriverCommonLib extends BaseTest {
	public void verifyTitle(String pageName, String excpectedTitle)
	{
		String titleofThePage=driver.getTitle();
		Reporter.log("title of the "+pageName+"is "+titleofThePage);
		if (titleofThePage.equals(excpectedTitle)) {
			Reporter.log("title of the "+pageName+"is matched ");
		}
		else {
			Reporter.log("title of the "+pageName+"is not  matched ");

		}
	}
	public void selecttheOptionOfDropdown(WebElement element,int index) 
	{
		Select sel=new Select(element);
		sel.selectByIndex(0);

	}
	public void selecttheOptionOfDropdown(WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	public void selecttheOptionOfDropdown1(String text,WebElement element) 
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);

	}
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	public void switchToFrame(WebElement framelement) {
		driver.switchTo().frame(framelement);
	}
	public void rightClick(WebElement targetElement)
	{
		Actions act=new Actions(driver);
		act.contextClick(targetElement).perform();

	}
	public void mouseHover(WebElement targetElement)
	{
		Actions act=new Actions(driver);
		act.moveToElement(targetElement).perform();
	}
	public void doubleClickonwebelement(WebElement targetelement) {
		Actions act=new Actions(driver);
		act.doubleClick(targetelement).perform();
	}
	public void dragAndDrop(WebElement src,WebElement target) {
		Actions act=new Actions(driver);
		act.dragAndDrop(src,target).perform();			
	}
	public void scrollDown(int pixels) 
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,(pixels))");
	}
	public void scrollUp(int pixels) 
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,(-pixels)");
	}
	public void scrollRight(int pixels) 
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+(pixels)+",0)");
	}
	public void scrollLeft(int pixels) 
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+(-pixels)+",0)");
	}
	public void scrollUpToParticularWebElement(WebElement element)

	{
		Point loc=element.getLocation();
		int xaxis =loc.getX();
		int yaxis =loc.getY();

		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+xaxis+"),("+yaxis+")");
	}
	public void hitEnterButton() throws AWTException
	{
		Robot robot=new Robot() ;
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
	public void copy() throws AWTException 
	{
		Robot robot=new Robot() ;
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	public void paste() throws AWTException
	{
		Robot robot=new Robot() ;
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);		
	}
	public void acceptAlert()
	{
		Alert al=driver.switchTo().alert();
		al.accept();
	}
	public void printAllOps(WebElement element) {
		Select sel=new Select(element);
		List<WebElement> allops = sel.getOptions();
		for(WebElement ao:allops) {
			String text=ao.getText();
			System.out.println(text);
			
		}
		
	}
}