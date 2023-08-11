package vtiger;

import org.testng.annotations.Test;

public class TestNGfeature_Practice {

	
		@Test(priority=0,invocationCount=2)
		public void create() 
		{
			System.out.println("created");
		}
		@Test(priority= -1,invocationCount=1,dependsOnMethods="create",alwaysRun=true,enabled=false)
		public void updated()
		{
			System.out.println("updated");
		}
		@Test(priority=2,alwaysRun=false)
		public void delete() 
		{
			System.out.println("deleted");
		}



	}


