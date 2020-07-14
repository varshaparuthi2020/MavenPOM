package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadusingRobotclass {

	WebDriver driver;
	
	@Test
public void uploadfile() throws InterruptedException, IOException{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		driver.get("https://www.monsterindia.com/seeker/profile");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.findElement(By.xpath("//input[@id='signInName']")).sendKeys("varsha.paruthi2020@gmail.com");
	
		
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("June@2020");
		
		 driver.findElement(By.xpath("//input[@id='signInbtn']")).click();;
	
		
		
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(30);
		
		//driver.switchTo().frame("google_osd_static_frame");
		Thread.sleep(5);
		
		Actions act=new Actions(driver);
		WebElement golfClub=driver.findElement(By.xpath("//span[@class='profile-img-holder']"));
		act.moveToElement(golfClub).perform();
		WebElement sublink=driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		sublink.click();
		
	
	System.out.println("FRst time:"+driver.getCurrentUrl());
			
		driver.findElement(By.xpath("//i[@class='mqfi-upload']")).click();
		Thread.sleep(15);
		
		
		//driver.findElement(By.xpath("//a[contains(text(),'or select file to upload')]")).click();
	//Actions act1= new Actions(driver);
		WebElement upl=	driver.findElement(By.xpath("//input[@id='resume']"));
		
		
		
	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", upl);
		//upl.submit();
	//act.moveToElement(upl).build().perform();
		System.out.println("done till file");
		Runtime.getRuntime().exec("C:\\Varsha\\FileUpload.exe");
		
		System.out.println(upl.getText());
		Thread.sleep(30);
		
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Save')]")));
		element.click();*/
		driver.findElement(By.xpath("//div[@id='uploadResumeModel']//div[@id='modalDescription']//div//button[@class='btn wt-100 pt10 pb10 no-radius'][contains(text(),'Save')]")).click();
	
		
		
		System.out.println(driver.getTitle());
		System.out.println("hello its done : "+driver.getCurrentUrl());
	
	}
	
	

}
