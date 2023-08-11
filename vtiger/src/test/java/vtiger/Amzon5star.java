package vtiger;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import vtigerGeneric_Utility.WebDriverUtility;

public class Amzon5star {

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		/*ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(opt);*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> products=driver.findElements(By.xpath("//span[@aria-label='4.0 out of 5 stars']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::h2"));
		for(WebElement p:products)
		{
			System.out.println(p.getText());
		}
		WebDriverUtility wu=new WebDriverUtility();
		String gpage = wu.screenShot(driver, "verify");
		System.out.println(gpage);
	}

}
