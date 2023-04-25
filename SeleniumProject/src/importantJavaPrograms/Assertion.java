package importantJavaPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion 
{
	protected static WebDriver driver;
	@Test
	public void assertion() 
	{
		/*Assert.assertTrue(true);
		Assert.assertEquals("wellcome","Wellcome");
		Assert.assertEquals("passed","passed");
		System.out.println(" sucessfuly passed");*/


		/*WebElement usernameTextField=driver.findElement(By.name("username"));
		WebElement passwordTextbox=driver.findElement(By.name("username"));

		Assert.assertTrue(usernameTextField.isDisplayed());
		usernameTextField.sendKeys("Admin");
		
		Assert.assertTrue(passwordTextbox.isDisplayed());
		String expectedTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle,driver.getTitle());
		Assert.assertFalse(usernameTextField.isDisplayed());*/
SoftAssert soft=new SoftAssert();


	}

}
