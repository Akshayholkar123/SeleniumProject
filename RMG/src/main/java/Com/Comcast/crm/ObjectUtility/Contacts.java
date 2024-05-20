package Com.Comcast.crm.ObjectUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts {
	public Contacts(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//img[@title='Create Contact...']") private WebElement createContact;


	public WebElement getCreateContact() {
		return createContact;
	}

}
