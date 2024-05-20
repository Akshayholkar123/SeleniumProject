package TestNGTest;

//import org.apache.poi.poifs.crypt.temp.AesZipFileZipEntrySource;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	
	@Test(dataProvider="getData")
	public void createContactTest(String firstName,String lastName)
	{
		System.out.println("FirstName : "+firstName +"LastName : "+lastName);
	}
	@DataProvider
	public Object[][] getData(){
	 Object[][] data =new Object[3][2];
	 data[0][0]="Akshay";
	 data[0][1]="Holkar";
	 
	 data[1][0]="Akshay";
	 data[1][1]="H";

	 data[2][0]="Akki";
	 data[2][1]="Holkar";

	 
	 
	return data;
}
}