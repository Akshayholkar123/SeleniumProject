package generic;


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
	//write data
	public class WriteDataInExcel {

		public static void main(String[] args) throws EncryptedDocumentException, IOException {
			FileInputStream fis = new FileInputStream("./data/testdata.xlsx");//getting the specified file for read operation
			Workbook wb = WorkbookFactory.create(fis);//it makes the file ready for read operation
			Sheet sh = wb.getSheet("validdata");//it specifies which sheet
			Row row = sh.getRow(1);//specifies the row 
			Cell cell = row.createCell(3);//specifies column
			
			cell.setCellValue("Akshay");//set the value
			
			FileOutputStream fos = new FileOutputStream("./data/testdata.xlsx");
			wb.write(fos);//write operation

		

	}
	

}
