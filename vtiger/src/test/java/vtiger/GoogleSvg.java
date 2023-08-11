package vtiger;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSvg {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//div[@class='gb_g']")).click();
		Thread.sleep(2000);
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//span[text()='YouTube']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("tere parche",Keys.ENTER);
		

	}

}
