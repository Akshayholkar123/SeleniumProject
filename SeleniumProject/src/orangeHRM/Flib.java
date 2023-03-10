package orangeHRM;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Flib {
	public void readExcelData(String excelPath,String SheetName,int rowCount,int cellCount) throws EncryptedDocumentException, IOException	
	{
		FileInputStream fis =new FileInputStream(excelPath);
	Workbook wb = WorkbookFactory.create(fis);
Sheet sh	=wb.getSheet(SheetName);
Row row=sh.getRow(rowCount);
Cell cell=row.getCell(cellCount);
cell.getRichStringCellValue();
		
	}
	public void writeDatainExcel(String excelPath,String SheetName,int rowCount,int cellCount,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream(excelPath);
	Workbook wb = WorkbookFactory.create(fis);
Sheet sh	=wb.getSheet(SheetName);
Row row=sh.getRow(rowCount);
Cell cell=row.createCell(cellCount);
cell.setCellValue(data);
FileOutputStream fos =new FileOutputStream(excelPath);
wb.write(fos);
	}
	public String readPropertyData(String propPath,String key) throws IOException 
	{
		FileInputStream fis=new FileInputStream(propPath);
		Properties prop=new Properties();
		prop.load(fis);
		String value=prop.getProperty(key);
		return value;
	}
	public int getRowCount(String excelPath,String SheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream(excelPath);
	Workbook wb = WorkbookFactory.create(fis);
Sheet sh	=wb.getSheet(SheetName);
int rc=sh.getLastRowNum();
return rc;


		
		
		
	}
}

