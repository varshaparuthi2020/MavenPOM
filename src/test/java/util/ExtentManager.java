package util;

import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	
	
	private static ExtentReports report = null; 

	public static ExtentReports getInstance(){
	if (report == null){
		
		Date d = new Date();
		String timestamp= d.toString().replace(" ", "_").replace(":", "_");
		report= new ExtentReports(System.getProperty("user.dir")+"\\Reports_rep_"+timestamp+".html");
		
	}
	return report;}
	}
