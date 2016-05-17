package com.eric.test.app.connection;

//import java.util.*; 
import java.sql.*;

public class OpenDbConnection{
	public void openconnection(){
		try{
		 Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost/cmd","mysql","mysql");
		 System.out.println("DB connection successfull");
		 Statement myStmt= myconn.createStatement();
		}
	catch(Exception e)
		{
		 e.printStackTrace();
		}
	}
}