package Selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//|above API java.sql

import com.mysql.jdbc.Driver;

public class JavaDbConnection {

	public static void main(String[] args) throws SQLException {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
        //String url = "jdbc:mysql://localhost:3306/your_database_name";
		 Connection  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		 //Connection  conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
System.out.println("=======DONE==========");

Statement st=conn.createStatement();
 ResultSet set=st.executeQuery("select * from projects");
while(set.next())
{
	System.out.println(set.getString(1)+"  "+ set.getString(2));
}
 conn.close();
	}}

//dependencies.txt
//Displaying dependencies.txt.