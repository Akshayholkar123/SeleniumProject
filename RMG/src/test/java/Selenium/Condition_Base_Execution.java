package Selenium;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Condition_Base_Execution {

	public static void main(String[] args) throws EncryptedDocumentException, IOException,Throwable{
String ExpectedId="tc_02";
String data1="";
String data2="";
String data3="";
FileInputStream fis=new FileInputStream("./src/test/resources/DataRMG/dataforRMG.xlsx");
Workbook wb=WorkbookFactory.create(fis);
Sheet sh=wb.getSheet("condition");

int rc=sh.getLastRowNum();
for(int i=0;i<=rc;i++)
{
	String data="";
	try {
		data=sh.getRow(i).getCell(0).toString();
		if(data.equals(ExpectedId)) {
		data1=sh.getRow(i).getCell(1).toString();
		data2=sh.getRow(i).getCell(2).toString();
		data3=sh.getRow(i).getCell(3).toString();
	}
	}
       catch(Exception e) {}

}

System.out.println(data1);
System.out.println(data2);
System.out.println(data3);


wb.close();}
	
	
}
