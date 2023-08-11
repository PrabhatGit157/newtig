package customerContactTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import objectRepositary.CreateNewOrgPage;
import objectRepositary.HomePage;
import objectRepositary.OrganisatonsPage;
import vtigerGeneric_Utility.BaseClass;
import vtigerGeneric_Utility.ExcelUtility;

@Listeners(vtigerGeneric_Utility.ListenerImplementation.class)
public class CreateOrganisationTest extends BaseClass
{
	@Test(dataProviderClass=ExcelUtility.class,dataProvider="getMultiple",groups={"smoke" , "regrassion"})
	public void create(String org) throws Throwable
	{
		
		
		
		int random=ju.getRandom();    
		
		HomePage hp=new HomePage(driver);
		hp.Orgclick();
		
		OrganisatonsPage op=new OrganisatonsPage(driver);
		op.NewOrganisationclick();
		
		CreateNewOrgPage cnp=new CreateNewOrgPage(driver);
		
		//String ActualOrg=org+random;
		cnp.createOrg(org+random);
		
		

	}


}
