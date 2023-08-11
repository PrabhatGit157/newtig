package vtigerGeneric_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility
{
	public String getProerties(String key) throws Throwable
	{
		
	FileInputStream fis=new FileInputStream(Ipathconstant.propertyfilepath);
    Properties pro=new Properties();
    pro.load(fis);
    String value=pro.getProperty(key);
	return value;
	}
	
}
