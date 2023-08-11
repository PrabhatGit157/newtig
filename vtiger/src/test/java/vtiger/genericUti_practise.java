package vtiger;

import vtigerGeneric_Utility.ExcelUtility;

public class genericUti_practise {

	public static void main(String[] args) throws Throwable 
	{
		ExcelUtility eu=new ExcelUtility();
		String orgname=eu.getExcelData("Sheet1", 0, 0);
		System.out.println(orgname);

	}

}
