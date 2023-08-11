  package vtigerGeneric_Utility;

import java.util.Date;
import java.util.Random;


public class JavaUtility {
        
	/**
	 * this method is used to get random no
	 * @return
	 */
	 public int getRandom()
	 {
		 Random r=new Random();
		 int randomno = r.nextInt(1000);
		 return randomno;
	 }
		
	 public String currentDate()
	 {
		 Date d=new Date();
		 String dat=d.toString();
		 System.out.println(dat);
		 return dat;
	 }
	 /**
	  * by using this we can modify the current date
	  * @return
	  */
	 public String systemDate()
	 {
		 Date d=new Date();
		 String dt[]=d.toString().split(" ");
		 
		 String month=dt[1];
		 String day=dt[0];
		 String date=dt[2];
		 String year=dt[5];
		 String  currentdt=day+" "+month+" "+date+" "+year;
		 System.out.println(currentdt);
		 return currentdt;
		 
	 }
		

	

}
