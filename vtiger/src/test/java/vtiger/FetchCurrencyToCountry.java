package vtiger;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchCurrencyToCountry {

	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		List<WebElement> currency = driver.findElements(By.xpath("//table[@id='countries']/tbody/tr[*]/td[4]"));
		List<WebElement> country=driver.findElements(By.xpath("//table[@id='countries']/tbody/tr[*]/td[2]"));
		//for(WebElement cr:currency)
		for(int i=0;i<currency.size();i++)
		{
			String crr=currency.get(i).getText();
			if(crr.contains("Dollar"))
			{
				 
				 System.out.println(country.get(i).getText());
			}
		}

	}

}
