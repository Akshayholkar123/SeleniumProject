package POMTesting;

//import org.apache.xmlbeans.impl.values.JavaUriHolder;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Com.Comcast.Generic.WebDriverUtility.JavaUtility;

public class TestRunner{
	@Test
	public void testRun()
	{
		JavaUtility ju=new JavaUtility();
		String date=ju.getReqDate(-30);
		Reporter.log(date,true);
	}

}
