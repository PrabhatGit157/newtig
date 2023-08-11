package vtiger;

import org.testng.annotations.DataProvider;

public class DataProvide 
{
	@DataProvider
	public Object[][] vehcile()
	{
		
	
	Object[][] obj=new Object[3][5];
	
	obj[0][0]="Audi";
	obj[0][1]="1cr";
	obj[0][2]=3.5f;
	obj[0][3]="petrol";
	obj[0][4]=30000;
	
	obj[1][0]="BMW";
	obj[1][1]="1.3cr";
	obj[1][2]=4.5f;
	obj[1][3]="diesel";
	obj[1][4]=20000;
	
	obj[2][0]="Maserati";
	obj[2][1]="2cr";
	obj[2][2]=4.2f;
	obj[2][3]="petrol";
	obj[2][4]=1000;
	
	return obj;
	}
	
}
