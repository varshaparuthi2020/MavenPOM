package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import util.ExtentManager;

public class Facebook_LoginTest_usingreadconfig extends BaseTest{
	LoginPage lp = new LoginPage(driver);


	@Test

	public void loginpage() throws Exception{
report=ExtentManager.getInstance();

test=report.startTest("Test login started with config file");
		//driver.navigate().to("https://www.facebook.com");
		lp = PageFactory.initElements(driver, LoginPage.class);

		lp.setusername(uname);
		logger.info("UserName value passed");
		Testinfo("Username entered");
		
		lp.setpassword(pass);
		logger.info("Password value passed");
		Testinfo("Password entered");
		
		
		lp.clickbutton();
		logger.info("Click on submit btn");
		
		Testinfo("Click on login btn");
		Thread.sleep(20);
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equalsIgnoreCase("Facebook – log in or sign up")){
			System.out.println("Title is getting printed successfully!!!");
			takeScreenshot("Screenshot done of fb login!!");
			logger.info("test case done passed");
			Testpass("Sreenshot taken of login page");
		}

	}

	@AfterTest

	public void teardown(){

		driver.close();
		System.out.println("Test login done");
	}

}
