 package Selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class UnitTestingJdBc {
@Test
public void checkData() throws SQLException
{
	Connection conn=null;
	try {
	Driver driverRef=new Driver();
	
		DriverManager.registerDriver(driverRef);
	 
	
	
	  conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
System.out.println("=======DONE==========");

Statement st=conn.createStatement();
ResultSet set=st.executeQuery("select * from project");
while(set.next())
{
System.out.println(set.getString(1)+"  "+ set.getString(2));
}}
catch (Exception e) {
	System.out.println("handled");}

finally {
	conn.close();
System.out.println("connection closed");
}}}
