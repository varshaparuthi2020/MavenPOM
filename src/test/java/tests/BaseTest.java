package tests;


import java.io.File;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.ReadConfig;


public class BaseTest {

ReadConfig confread= new ReadConfig();
	
	public String url= confread.getURL();
	public String uname=confread.MethoduserName();
	public String pass=confread.MethoduserPassword();
	static WebDriver driver;
	
	 ExtentReports report = null;
	public ExtentTest test =null;
	
	public static Logger logger =null;
	@BeforeClass
	public void testsetup() {
logger=LogManager.getLogger(Facebook_LoginTest_usingreadconfig.class.getName());
DOMConfigurator.configure(System.getProperty("user.dir")+"\\log4j.xml");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		logger.info("Chrome is launched");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(url);
		logger.info("Base URL is launched");
	}
	
	public void takeScreenshot(String msg) throws Exception{
		Date d = new Date();
		String timestamp = d.toString().replace(" ", "_").replace(":", "_");
	
		TakesScreenshot ss= (TakesScreenshot)driver;
		File src =ss.getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir")+"\\Screenshots\\s_"+timestamp+".jpeg");
		FileUtils.copyFile(src, des);
		
		System.out.println("Screenshot done:-)");
		
	}
public void Testpass(String message){
	
	test.log(LogStatus.PASS, message);
}

public void Testfail(String message){
	
	test.log(LogStatus.FAIL, message);
}


public void Testinfo(String message){
	
	test.log(LogStatus.INFO, message);
}

}
