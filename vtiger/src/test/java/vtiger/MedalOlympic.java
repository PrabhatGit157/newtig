package vtiger;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MedalOlympic {

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.findElement(By.xpath("//button[text()='No, manage settings']")).click();
		driver.findElement(By.xpath("//button[text()='Reject All']")).click();
		Thread.sleep(2000);
		 java.util.List<WebElement> country = driver.findElements(By.xpath("(//span[@data-cy='country-name'])[position()<5]"));
		  java.util.List<WebElement> gold = driver.findElements(By.xpath("(//div[@title='Gold']/span)[position()<5]"));
		  java.util.List<WebElement> silver = driver.findElements(By.xpath("(//div[@title='Silver']/span)[position()<5]"));
		  java.util.List<WebElement> bronze = driver.findElements(By.xpath("(//div[@title='Bronze']/span)[position()<5]"));
		  java.util.List<WebElement> allMedal = driver.findElements(By.xpath("(//div[@title='']/span)[position()<5]"));
		 for(int i=0;i<country.size();i++)
		{
			
			String c = country.get(i).getText();
			String g = gold.get(i).getText();
			String s = silver.get(i).getText();
			String b = bronze.get(i).getText();
			String a = allMedal.get(i).getText();
			System.out.println(c+" "+g+" "+s+" "+b+" "+a);
			
		}

	}

}
