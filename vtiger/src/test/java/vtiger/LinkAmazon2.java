package vtiger;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import vtigerGeneric_Utility.ExcelUtility;

public class LinkAmazon2 {

	public static void main(String[] args) throws Throwable
	{
		
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.amazon.in/");
			 List<WebElement> links = driver.findElements(By.xpath("//a"));
			 for(int i=0;i<links.size();i++)
			
			 {
				 String li=links.get(i).getText();
				 
				
					 ExcelUtility eu=new ExcelUtility();
					 eu.updateExcelData("Sheet2", i, 0, li);
				 String link = eu.getExcelData("Sheet2", i, 0);
				 System.out.println(link);
			 }
			
         System.out.println("ok");
		}

}

