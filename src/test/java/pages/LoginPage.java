package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	  final  WebDriver driver;
	 public LoginPage(WebDriver driver)
		{
			//driver=rdriver;
		 
		 this.driver= driver;
		 
			//PageFactory.initElements(driver,this);
		}
	@FindBy(xpath="//input[@id='email']")
	@CacheLookup
WebElement elm;
	
	
	@FindBy(xpath="//input[@id='pass']")
	@CacheLookup
 WebElement pwd;
	
	
	@FindBy(id = "u_0_b")
	@CacheLookup
 WebElement btn;
	
	
	
	public  void setusername(String username){
	
		elm.sendKeys(username);
	}
	
	public  void setpassword(String password){
		
		pwd.sendKeys(password);
		
	}

	public  void clickbutton(){
		btn.click();
	}

}
