package objectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisatonsPage 
{
	@FindBy(xpath="//img[contains(@title,'Cr')]") private WebElement orgplusicon;
	
	public OrganisatonsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void NewOrganisationclick()
	{
		orgplusicon.click();
	}

}
