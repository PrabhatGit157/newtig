package vtiger;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartMobile {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		WebElement popup=driver.findElement(By.xpath("//button[text()='✕']"));
		if(popup.isEnabled())
		{
			popup.click();
		}
		else {
			
		}
			
			Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Mobiles']")).click();
		WebElement realme=driver.findElement(By.xpath("//div[text()='realme']"));
		Actions act=new Actions(driver);
		act.moveToElement(realme);
		realme.click();
		driver.findElement(By.xpath("//div[text()='realme C55 (Rainforest, 128 GB)']")).click();
		String mainid=driver.getWindowHandle();
		Set<String> allid=driver.getWindowHandles();
		
		for(String id:allid)
			{
			if(!(id.equals(mainid)))
			{
				driver.switchTo().window(id);
			}
			}
		driver.findElement(By.xpath("//label[text()='Compare']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='COMPARE']")).click();
		

	}

}
