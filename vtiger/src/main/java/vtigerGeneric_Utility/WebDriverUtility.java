package vtigerGeneric_Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility 
{
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximise(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void wait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void visibilityofElement(WebDriver driver,WebElement element)
	{
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void elementtobeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void alertPresent(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.alertIsPresent());
	}
	public void titleContains(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.titleContains(title));
	}
	public void selectDropdown(WebElement element,int index)
	{
		Select se=new Select(element);
		se.selectByIndex(index);
	}
	public void selectDropdown(WebElement element,String value)
	{
		Select se=new Select(element);
		se.selectByValue(value);
	}
	public void selectDropdown(String text,WebElement element)
	{
		Select se=new Select(element);
		se.selectByVisibleText(text);
	}
	public void mouseHover(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void rightclick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void doubleclick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void scrollThePagetoElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrolly(0,"+y+")", element );
	}
	public void frame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void frame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void frame(WebDriver driver,String nameorid)
	{
		driver.switchTo().frame(nameorid);
	}
	public void parentFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent(); 
	}
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public String getTextAlert(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * 
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws IOException
	 */
	public String screenShot(WebDriver driver,String screenshotname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		LocalDateTime local=LocalDateTime.now();
		String dt=local.toString().replace("-", "_").replace(":","_");
		File dest=new File("./Screenshot/"+screenshotname+dt+".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath();//Extent report
	}

}
