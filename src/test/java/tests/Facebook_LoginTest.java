package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
public class Facebook_LoginTest{
	LoginPage lp = new LoginPage(driver);

	static WebDriver driver;
	@BeforeTest
	public void testsetup() {
	
	
	WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	
	driver.manage().window().maximize();
}
	
	
	@Test
	
	public void loginpage() throws InterruptedException, IOException{
		
	
		
	driver.navigate().to("https://www.facebook.com");
	lp = PageFactory.initElements(driver, LoginPage.class);
	
lp.setusername("varsha813@gmail.com");
	lp.setpassword("momdad");
	lp.clickbutton();
	Thread.sleep(20);
	String title = driver.getTitle();
	System.out.println(title);
	if(title.equalsIgnoreCase("Facebook – log in or sign up")){
		System.out.println("Title is getting printed successfully!!!");
	}
	}
	
	@AfterTest
	
	public void teardown(){
		
		driver.close();
		System.out.println("Test login done");
	}

}
