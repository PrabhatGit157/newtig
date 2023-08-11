package vtiger;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public final class FlipkartSamsung {

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
			
			
			driver.findElement(By.name("q")).sendKeys("samsung s20");
			Thread.sleep(2000);
			List<WebElement> option=driver.findElements(By.xpath("//ul[contains(@class,'UFBk')]/li"));
			for(WebElement op:option)
			{
				String mob=op.getText();
				
				if(mob.equals("samsung s20"))
				{
					System.out.println(mob);
					op.click();
					break;
				}
				
			}

	}

}
