package vtiger;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_practice 
{
	@DataProvider(name="dt")
	//@DataProvider
	public Object[][] mobiledata()
	{
		Object[][] obj=new Object[3][3];
		
		obj[0][0]="samsung";
		obj[0][1]=10000;
		obj[0][2]=3.2f;
		
		obj[1][0]="iphone";
		obj[1][1]=64003;
		obj[1][2]=4.5f;
		
		obj[2][0]="redmi";
		obj[2][1]=12000;
		obj[2][2]=4.2f;
		return obj;
	}
	@Test(dataProvider="dt")
	//@Test(dataProvider="mobiledata")
	public void getdata(String name,int price,float rating)
	{
		System.out.println("phone brand : "+name+", price : "+price+", rating : "+rating);
	}

}
