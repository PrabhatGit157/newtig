package vtiger;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OlympicMedal {

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver;
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.findElement(By.xpath("//button[text()='No, manage settings']")).click();
		driver.findElement(By.xpath("//button[text()='Reject All']")).click();
		Thread.sleep(2000);
		List<WebElement> country=driver.findElements(By.xpath("//span[@data-cy='country-name']"));
		 List<WebElement> goldm = driver.findElements(By.xpath("//div[@title='Gold']/span"));
		 List<WebElement> bronzem = driver.findElements(By.xpath("//div[@title='Bronze']/span"));
		{
			for(int i=0;i<country.size();i++)
			{
			String CountryName=country.get(i).getText();
			String gold=goldm.get(i).getText();
			String bronze=bronzem.get(i).getText();
			
			System.out.println(CountryName+" "+gold+" "+bronze);
		}
		
		//country  //div[contains(@class,'Tablestyles__CommonGrid-sc-xjyvs9-1 Tablestyles__Content-sc-xjyvs9-3 knZfST eVgKXR')]//span[contains(@class,'styles__CountryName-sc-fehzzg-6 jYXabZ')]
		//medal
		}

	}

}
