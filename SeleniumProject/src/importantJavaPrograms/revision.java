package importantJavaPrograms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class revision 
{
public static void main(String[] args) 
{
	int []a= {3,2,4,17,5,9,6};
	for(int i=0;i<=a.length;i++)
	{
		for(int j=0;j<=a.length;i++)
		{
			if(a[j]>a[j+1])
			{
				int temp=a[j];
				a[j]=a[j+1];
				a[j+1]=temp;
			}
		}
	}
	System.out.println(Arrays.toString(a));
}
public String readExcelData(String excelPath,String sheetName,int rowCount,int cellCount) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(excelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetName);
	Row row=sh.getRow(rowCount);
Cell cell=row.getCell(cellCount);
String data=cell.getStringCellValue();
return data;
}
public void writeExcelData(String excelPath,String sheetName,int rowCount,int cellCount,String data) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(excelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetName);
	Row row=sh.getRow(rowCount);
	Cell cell=row.getCell(cellCount);
	cell.setCellValue(data);
	
	FileOutputStream fos=new FileOutputStream(excelPath);
	wb.write(fos);
}
public int getRowCount(String excelPath,String sheetName) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(excelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetName);
	int rc=sh.getLastRowNum();
	return rc;
}
public String readPropertyData(String propPath,String key) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(propPath);
	Properties prop =new Properties();
	prop.load(fis);
	String value=prop.getProperty(key);
	return value;
}
}