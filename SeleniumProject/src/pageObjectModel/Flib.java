package pageObjectModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Flib implements IAutoConstant {
	public String readExcelData(String excelPath,String sheetName,int rowCount,int cellCount) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis=new FileInputStream(excelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	Row row=sh.getRow(rowCount);
	Cell cell =row.getCell(cellCount);
	String value=cell.getStringCellValue();
	return value;
}
	public String readPropertyData(String propPath,String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(propPath);
		Properties prop=new Properties();
		prop.load(fis);
		String value=prop.getProperty(key);
		return value;
		
	}
	public int getLastRowNum1(String excelPath,String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(SheetName);
		int rc=sh.getLastRowNum();
		return rc;
	}
	public int getLastRowNum(String excelpath, String sheetName) {
		// TODO Auto-generated method stub
		return 0;
	}
}