package vtiger;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonS20 {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung s20");
		Thread.sleep(1000);
		//List<WebElement> phone=driver.findElements(By.xpath("//div[@class='two-pane-results-container']"));
		List<WebElement> phone=driver.findElements(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
		
		for(WebElement ph:phone)
		{
			String model=ph.getText();
			//System.out.println(model);
			if(model.equals("samsung s20"))
					{
				ph.click();
				break;
				
					}
		}

	}

}
