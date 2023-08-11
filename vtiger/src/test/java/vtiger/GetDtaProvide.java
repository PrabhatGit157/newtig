package vtiger;

import org.testng.annotations.Test;

public class GetDtaProvide 
{
	@Test(dataProviderClass=DataProvide.class,dataProvider="vehcile")
	public void Fetch(String car,String price,float rating,String type,int buyer)
	{
		System.out.println(car+"---."+price+"--->"+rating+"---->"+type+"---->"+buyer);
	}

}
