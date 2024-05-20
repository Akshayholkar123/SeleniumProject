package Com.Comcast.Generic.DataBaseUtility;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtilty {
	Connection conn;
	public void getDBConnection(String url,String usn,String pass) throws SQLException{
	try {
		Driver diverRef=new Driver();
		DriverManager.registerDriver(diverRef);
	    conn = DriverManager.getConnection(url,usn,pass);
	}
	catch (Exception e) {}
	
	
}
		
	public ResultSet executeSelectQuery(String query) throws SQLException
	
	{
		ResultSet set=null;
		try {
		Statement stat = conn.createStatement();
		set = stat.executeQuery(query);
	}catch(Exception e) {}
		return set;
	}
	public int executeNonSelectQuery(String query) throws SQLException
	{
		int i=0;
		try{Statement stat = conn.createStatement();
		i= stat.executeUpdate(query);
		
		} catch(Exception e) {}
		return i;
	}
	
	
	public void getDBConnection() throws SQLException{
	try {
		Driver diverRef=new Driver();
		DriverManager.registerDriver(diverRef);
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	}
	catch (Exception e) {}
	
	
}
	
	public void closeDB() throws SQLException
	{
		conn.close();
	}
	
	

}
