package DataDrivenPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import generic.Flib;

public class Test implements IAutoConstant {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
Flib flib=new Flib();
flib.writeExcelData(excelPath,"invaliddata", 5,5,"sumit");
	}

}
