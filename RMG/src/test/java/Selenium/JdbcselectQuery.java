package Selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;



public class JdbcselectQuery {

	public static void main(String[] args) throws SQLException {
		//step 1= load /reg DBDriver
		Driver ref=new Driver();
DriverManager.registerDriver(ref);
// step 2== Connect to dataBase
Connection conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
System.out.println("=====done=====");

    // step 3== create sql statement
  Statement stat = conn.createStatement();
  
  
    //steo 3=execute select query get result
    int result=stat.executeUpdate("insert into project values('TY_PROJ_2025','Akshay','03/05/2024','FB 09','on going','100');");
System.out.println(result);
System.out.println("pass");

conn.close();
	}

}
