package DataDrivenPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//first github
public class Filb {

	public  String invalidLoginData(String excelPath,String sheetName,int rowCount,int cellCount) throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream(excelPath);
		Workbook wb=WorkbookFactory.create(fis);
        Sheet sh= wb.getSheet(sheetName);
        Row row= sh.getRow(rowCount);
        Cell cell=row.getCell(cellCount);
        String value=cell.getStringCellValue();
        return value;
      

	}
	public void writeDataInExcel(String excelPath,String sheetName,int rowCount,int cellCount,String data ) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowCount);
		Cell cell=row.createCell(cellCount);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(excelPath);
		wb.write(fos);
		
		
		
	}
	public int getRowCount(String excelPath,String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(sheetName);
		 int rc=sh.getLastRowNum();
		 return rc;
		
		
	}
	}
