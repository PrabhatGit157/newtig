package organisationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import objectRepositary.CreateNewOrgPage;
import objectRepositary.HomePage;
import objectRepositary.OrganisatonsPage;
import vtigerGeneric_Utility.BaseClass;

@Listeners(vtigerGeneric_Utility.ListenerImplementation.class)
public class verifyuserCreateContactTest extends BaseClass
{
	@Test (groups="smoke", retryAnalyzer=vtigerGeneric_Utility.RetryAnalyser.class)
	public void createContact() throws Throwable 
	{
		
		HomePage hp=new HomePage(driver);
		hp.Contactclick();
		Reporter.log("contact link click");
		//driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		Random ran=new Random();
		int ranNum=ran.nextInt(1000);
	
		String cel = eu.getExcelData("Sheet1", 0, 0);
		String Exdata=cel+ranNum;
		driver.findElement(By.name("lastname")).sendKeys(Exdata);
		driver.findElement(By.cssSelector(".crmbutton.small.save")).click();
		//Assert.fail();   //for retryanalyser checking purpose
		
		String actdata = driver.findElement(By.className("dvHeaderText")).getText();
		if(actdata.contains(Exdata))
		{
			System.out.println("pass");	
		}
		else
		{
			System.out.println("fail");
		}
		//driver.findElement(By.xpath("//td[@class='genHeaderSmall']/following-sibling::td[1]")).click();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//hp.signoutLink(driver);
		//driver.findElement(By.linkText("Sign Out")).click();
	}
	@Test (groups="regrassion")
	public void Demo()
	{
		System.out.println("regional test");
	}


	
}
