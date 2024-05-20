package Selenium;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ThreeDArray {
	
	@Test(dataProvider = "getData")
	public void TRhreeDimationalArray(String name,String lastName, Long mobileNum) {
		System.out.println(name +"  "+lastName+"   "+mobileNum);
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object [][] data=new Object[2][3];
		
		data[0][0]="Akshay";
		data[0][1]="holkar";
		data[0][2]=9730384985l;
		
		data[1][0]="Akshay";
		data[1][1]="Holkar";
		data[1][2]=9322414016l;
		
		return data;
		
	}

}
