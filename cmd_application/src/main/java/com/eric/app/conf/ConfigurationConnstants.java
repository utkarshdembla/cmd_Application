package com.eric.app.conf;

import java.util.Properties;

public class ConfigurationConnstants {

	private static Properties conf;
	
	public static String getDatabasePort(){
		
		return conf.getProperty("db-port");
		
	}
	
	public static void loadProperties(){
		
		if(conf != null){
			
			//TODO load ur pro file
		}
	}
	
}
