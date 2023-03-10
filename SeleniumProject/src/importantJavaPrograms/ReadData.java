package importantJavaPrograms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadData {

	public String readData(String excelpath,String sheetName,int rowCount,int cellCount ) throws EncryptedDocumentException, IOException {

		FileInputStream fis=new FileInputStream(excelpath);
 Workbook wb=WorkbookFactory.create(fis);
 Sheet sh = wb.getSheet(sheetName);
 Row row=sh.getRow(rowCount);
 Cell cell=row.getCell(cellCount);
 String data=cell.getStringCellValue();
 return data;
 //System.out.println(data);
 /*Cell cell=row.createCell(4);
 cell.setCellValue("akshay holkar");
 FileOutputStream fos=new FileOutputStream("./data/testdata.xlsx");
wb.write(fos);*/	
 
}
	

}
