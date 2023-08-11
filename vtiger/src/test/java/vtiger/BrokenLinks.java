package vtiger;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		ArrayList<String> brokenLinks = new ArrayList<String>();
		for (int i = 0; i < allLinks.size(); i++) {
			
			String links = allLinks.get(i).getAttribute("href");
			
		
		int statuscode=0;
		
		//create url object 
		
		try {
			
			URL url = new URL(links);
			URLConnection conn = url.openConnection();
			 HttpURLConnection urlc = (HttpURLConnection)conn;
			 statuscode=urlc.getResponseCode();
			 if(statuscode>=400) {
				 brokenLinks.add(links+" "+statuscode);
			 }
			
		} catch (Exception e) {
		   continue;
		   
		}
			
		System.out.println(brokenLinks);
		}

	}

}
