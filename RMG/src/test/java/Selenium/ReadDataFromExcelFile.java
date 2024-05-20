package Selenium;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException,FileNotFoundException{
FileInputStream fis=new FileInputStream("./src/test/resources/DataRMG/dataforRMG.xlsx");
Workbook wb=WorkbookFactory.create(fis);
Sheet sh=wb.getSheet("Vtiger");
int rc=sh.getLastRowNum();
for(int i=0;i<=rc;i++) {
Row row=sh.getRow(i);
//Cell cell=row.getCell(1);
String data=row.getCell(0).toString();
String  data2=row.getCell(1).toString();
String  data1=row.getCell(2).toString();
System.out.println(data+"\t"+"   " +data1+"\t"+data2);
	wb.close();
}
//write data on excel file=============================================
/*FileInputStream fis=new FileInputStream("./src/test/resources/DataRMG/dataforRMG.xlsx");
Workbook wb=WorkbookFactory.create(fis);
Sheet sh=wb.getSheet("Vtiger");
Row row=sh.getRow(4);
for(int i=4;i<=4;i++){
Cell cell=row.createCell(0);
cell.setCellValue("RedMi");
Cell cell1=row.createCell(1);
cell1.setCellValue("150");
Cell cell22=row.createCell(2);
cell.setCellValue("20000");

FileOutputStream fos=new FileOutputStream("./src/test/resources/DataRMG/dataforRMG.xlsx");
wb.write(fos);
	wb.close();}
	System.out.println("executed succesfully");
	}*/
	}
}
