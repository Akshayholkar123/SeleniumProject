package Selenium;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Comcast.crm.GenricCommFilesUtility.ExcelUtility;

public class ExcelFDataProvider {
	String sh=null;
@Test(dataProvider = "dataProvider")
	public void dataP(String brand ,String price) throws EncryptedDocumentException, IOException {
		dataProvider(sh);
        System.out.println("Brand: " + brand + ", Price: " + price);
		
	}
	
	
	
	
	
@DataProvider
public Object[][] dataProvider(String sh) throws EncryptedDocumentException, IOException
{
	ExcelUtility eu=new ExcelUtility();
	int rc=eu.getLastRowNum(sh);
	
	Object [][] data=new Object [rc][2];
	
	for(int i=0;i<rc;i++)
	{
	
		data[i][0]=eu.getDataFromExcel(sh,i+1,0);
		data[i][1]=eu.getDataFromExcel(sh,i+1,1);
	}
	return data;
	
}
	

}
