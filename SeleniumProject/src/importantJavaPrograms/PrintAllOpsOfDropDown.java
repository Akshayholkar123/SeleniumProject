package importantJavaPrograms;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PrintAllOpsOfDropDown 
{ 
	public void printAllOptionsofDropdown(WebElement element)
	{
		Select sel=new Select(element);
		List<WebElement> allops=sel.getOptions();
	for(WebElement we:allops) 
	{
		String text =we.getText();
		System.out.println(text);
	}
		
	}

}
