package Com.Comcast.crm.GenricCommFilesUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	
public String getDataFromPropertyFile(String key) throws IOException
{
	FileInputStream fis=new FileInputStream("./src/main/resources/commonData.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String value=prop.getProperty(key);
	return value;
	
}


}