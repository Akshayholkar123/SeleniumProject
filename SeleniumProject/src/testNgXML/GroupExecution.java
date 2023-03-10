package testNgXML;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class GroupExecution {
	@Test(groups="FUNCTIONAL")
	public void ft1()
	{
		Reporter.log("ft1",true);
	}
	@Test(groups="FUNCTIONAL")
	public void ft2()
	{
		Reporter.log("ft3",true);
	}
	@Test(groups="SMOKE")
	public void st1()
	{
		Reporter.log("ST1",true);
	}
	@Test(groups="INTEGRATION")
	public void it1()
	{
		Reporter.log("IT1",true);
	}
	@Test(groups="INTEGRATION")
	public void IT2()
	{
		Reporter.log("IT1",true);
	}
	@Test(groups="SMOKE")
	public void st2()
	{
		Reporter.log("st3",true);
	}
	@Test(groups="FUNCTIONAL")
	public void ft3()
	{
		Reporter.log("ft3",true);
	}

}
