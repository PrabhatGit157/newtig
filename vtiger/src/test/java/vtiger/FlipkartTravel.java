package vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartTravel {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//img[@alt='Travel']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(@for,'ROUND_TRIP')]/div[contains(@class,'XFPmK')]")).click();
		driver.findElement(By.xpath("//input[contains(@name,'departcity')]")).sendKeys("xyz");
		driver.findElement(By.xpath("//input[contains(@name,'arrivalcity')]")).sendKeys("xyz");
		driver.findElement(By.xpath("//div[@class='zzPDhz _1Jqgld']/input[contains(@name,'datefrom')]")).click();
		


	}

}
