package objectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(name="user_name") private WebElement username;
	
	@FindBy(name="user_password") private WebElement password;
	
	@FindBy(id="submitButton") private WebElement loginButton;
	
	//create a constructor to initialize the WebElement
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//create generic method for script
	public void login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
	}

}
