package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ReadConfig {
	String testdata= System.getProperty("user.dir")+"//Testdata//FBTestdata.xlsx";
	FileInputStream fis;
	Properties prop;
	public ReadConfig() throws IOException{
File testdatapath= new File(testdata);

try {
 
	fis = new FileInputStream(testdatapath);

	 prop = new Properties();
	prop.load(fis);
	}
	catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		System.out.println(e.getCause());
		e.printStackTrace();
	}
	}
	
	public String getBrowser(){
		
		String browserName=prop.getProperty("browser"); 
		return browserName;
	}
	
public String getURL(){
		
		String url=prop.getProperty("url"); 
		return url;
	}
	
	
	
	public String MethoduserName(){
		
		String userName=prop.getProperty("username");
		return userName;
	}
public String MethoduserPassword(){
		
		String userPassword=prop.getProperty("password");
		return userPassword;
	}


}
