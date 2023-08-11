package objectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerGeneric_Utility.WebDriverUtility;

public class HomePage 
{
	@FindBy(linkText="Organizations") public WebElement orglink;
	
	@FindBy(linkText="Contacts") public WebElement contactlink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") public WebElement Admintrator;
	
	@FindBy(linkText="Sign Out") public WebElement signoutbutton;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Orgclick()
	{
		orglink.click();
	}
	
	public void Contactclick()
	{
		contactlink.click();
	}
	
	public void Logout(WebDriver driver) throws Throwable
	{
		//WebDriverUtility wu=new WebDriverUtility();
		//wu.mouseHover(driver, Admintrator);
		
		Actions act=new Actions(driver);
		Thread.sleep(1000);
        act.moveToElement(Admintrator).perform();
        Thread.sleep(1000);
		signoutbutton.click();
	}

}
