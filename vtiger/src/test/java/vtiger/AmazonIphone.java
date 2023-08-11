package vtiger;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import vtigerGeneric_Utility.ExcelUtility;

public class AmazonIphone {

	public static void main(String[] args) throws Throwable
	{
		//WebDriverManager.ChromeDriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		Thread.sleep(1000);
		List<WebElement> iphoneSugg = driver.findElements(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
		for(WebElement is:iphoneSugg)
		{
			//driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ARROW_DOWN);
			String nam=is.getText();
			
			
			if(nam.equalsIgnoreCase("iphone 14"))
			{
				is.click();
				break;

			}
		}
		//driver.findElement(By.id("nav-search-submit-button")).click();
		
		String name = driver.findElement(By.xpath("//div[@class='a-section']"
				+ "[.//span[text()='Apple iPhone 14 (128 GB) - Blue']]//span[text()='Apple iPhone 14 (128 GB) - Blue']")).getText();
		ExcelUtility eu=new ExcelUtility();
		eu.updateExcelData("Sheet1", 3, 5, name);
		String ip=eu.getExcelData("Sheet1", 3, 5);
		System.out.println(ip);

	}

}
