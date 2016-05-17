package com.eric.test.app.connection;
import java.util.Properties;
import java.io.*;

public class UserConnection {
	
	String url,user,password;
	Properties prop=new Properties();
	
	public String UserConnURL(InputStream in){
		
		try{
			prop.load(in);
			url=prop.getProperty("url");
			}	
	catch(Exception e)
			{
		
			}
	return url;
	}
	public String UserConnUsername(InputStream in)
	{
		try{
			prop.load(in);
			user=prop.getProperty("username");
			}
			catch(Exception e)
			{
		
			}
	return user;
	}
	
	public String UserConnPassword(InputStream in)
	{
		try{
			prop.load(in);
			password=prop.getProperty("password");
			}
	
			catch(Exception e)
			{	
		
			}
	return user;
	}      
		
}
	
	

