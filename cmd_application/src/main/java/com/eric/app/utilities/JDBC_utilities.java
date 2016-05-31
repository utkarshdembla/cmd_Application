package com.eric.app.utilities;

import java.util.*;

import com.eric.app.connection.UserConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;

public class JDBC_utilities{
	static Scanner sc=new Scanner(System.in);
	static UserConnection userConn= new UserConnection();
	
	private static Connection myconn;
	private static Statement myStmt;
	
	
	public static boolean createDBConnection(){
		String path,filename,file,url,user,password;
	
		
		System.out.println("Enter the path");
		path=sc.next();
		
		System.out.println("Enter the filename");
		filename=sc.next();
		
		file=path+"\\"+filename;
		
		if(file!=null)
		{
		
			InputStream input = null;
			try {
				input= new FileInputStream(file);
				url=userConn.UserConnURL(input);
				user=userConn.UserConnUsername(input);
				password=userConn.UserConnPassword(input);
				
				myconn = DriverManager.getConnection(url,user,password);
				if(myconn != null)
				{
					System.out.println("DB Connection created :");
					myStmt= myconn.createStatement();
					//String ans="DB Connection created";
					return true;
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
		
		return false;
	}
	
	public static void closeDBConnection() throws SQLException{
		
		if(myconn != null && !myconn.isClosed()){
			myconn.close();
			System.out.println("DB Connection closed");
		}
		
	}
	
	// Below we are executing the functionalities in the application
	
	public void createData(String query) throws SQLException {
		 myStmt.executeUpdate(query);
	}
	
	public ResultSet retrieveData(String query) throws SQLException {
		//Retrieving the information on the application itself
		ResultSet r=myStmt.executeQuery(query); 
		return r;
	}
	
	public void updateData(String query) throws SQLException {
		 myStmt.executeUpdate(query);
	}
	public void deleteData(String query) throws SQLException {
		 myStmt.executeUpdate(query);
	}
	
	
}