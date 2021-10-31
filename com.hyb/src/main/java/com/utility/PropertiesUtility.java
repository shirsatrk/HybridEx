package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

	FileInputStream fis;
	
	public String readProperties(String key) {
		Properties prop = new Properties();
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
			 prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!prop.getProperty(key).equals(null))
		{return prop.getProperty(key);
		}
		else {
			return "Property valus not found for "+ key;
		}
	}
	
	
	
	
}
