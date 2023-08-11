package vtiger;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import vtigerGeneric_Utility.ExcelUtility;
import vtigerGeneric_Utility.WebDriverUtility;

public class FlipKartAddtocart {

	public static void main(String[] args) throws Throwable
	{
		//WebDriver driver=new EdgeDriver();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		try
		{
			driver.findElement(By.xpath("//button[text()='✕']")).click();
		}
		catch(Exception e)
		{
			System.out.println("");
		}
		WebElement fasion=driver.findElement(By.xpath("//img[@alt='Fashion']"));
		
		WebDriverUtility wu=new WebDriverUtility();
		wu.mouseHover(driver, fasion);
		driver.findElement(By.linkText("Men Footwear")).click();
		try
		{
		driver.findElement(By.xpath("//div[text()='Footup']/following-sibling::a[text()='3 Pairs| EVA| Ultralightweight| Premium| Comfort| All S...']")).click();
		String mainid=driver.getWindowHandle();
		Set<String> allid=driver.getWindowHandles();
		
		for(String id:allid)
		{
			if(!(id.equals(mainid)))
			{
				driver.switchTo().window(id);
			}
		}
		String price=driver.findElement(By.xpath
				("//span[text()='3 Pairs| EVA| Ultralightweight| Premium| Comfort| All Seasons Trendy|Slippers Slippers']"
						+ "/ancestor::div[@class='aMaAEs']/descendant::div[contains(@class,'jeq')]")).getText();
		ExcelUtility eu=new ExcelUtility();
		eu.updateExcelData("Sheet1", 5, 0, price);
		String pr=eu.getExcelData("Sheet1", 5, 0);
		System.out.println(pr);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@id='swatch-0-size']/a")).click();
		Actions act=new Actions(driver);
		//act.scrollByAmount(0, 2000);
		act.keyDown(Keys.ARROW_DOWN).perform();
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		}
		catch(Exception e)
		{
			System.out.println("product not found");
		}
 
	}

}
