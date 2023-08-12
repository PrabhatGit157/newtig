package vtigerGeneric_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import objectRepositary.HomePage;
import objectRepositary.LoginPage;

public class BaseClass 
{
	public JavaUtility ju=new JavaUtility();
	public FileUtility fu=new FileUtility();
	public ExcelUtility eu=new ExcelUtility();
	public WebDriverUtility wu=new WebDriverUtility();
	public static WebDriver sdriver;
	public WebDriver driver;
	
	
	@BeforeSuite(groups= {"smoke","regrassion"})
	public void BSconfig()
	{
		System.out.println("database connecting");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups= {"smoke","regrassion"})
	public void BCconfig() throws Throwable  
	//public void BCconfig(String BROWSER) throws Throwable        //for cross browsing
	{
		//String BROWSER=fu.getProerties("browser");             //for batch and group execution
		String BROWSER=System.getProerties("browser");
		//String BROWSER=System.getProperty("browser");            //for mvn runtime provider
		//runtime polymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			System.out.println(BROWSER+" launched");
			
		}
		
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			System.out.println(BROWSER+" launched");
		}
		else
		{
			System.out.println("given browser is not available ");
		}
		sdriver=driver;
		wu.maximise(driver);
		//Thread.sleep(1000);
		wu.wait(driver); 
		//String URL=fu.getProerties("url");
		String URL=System.getProerties("url");
		driver.get(URL);
		
		
	}
	@BeforeMethod(groups= {"smoke","regrassion"})
	public void BMconfig() throws Throwable
	{
		
		String UN=fu.getProerties("username");
		String PW=fu.getProerties("password");
		LoginPage lp=new LoginPage(driver);
		lp.login(UN, PW);
		System.out.println("log into the app");
	}
	
	@AfterMethod(groups= {"smoke","regrassion"})
	public void AMconfig() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.Logout(driver);
		System.out.println("logout from app");
	}
	
	//@AfterTest
	@AfterClass(groups= {"smoke","regrassion"})
	public void ACconfig()
	{
		driver.quit();
		System.out.println("close the Browser");
	}
	
	@AfterSuite(groups= {"smoke","regrassion"})
	public void ASconfig()
	{
		System.out.println("close DB connection");
	}
	

}

