package vtiger;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class FetchCSV {

	public static void main(String[] args) throws Throwable
	{
		String cell[];
		try
		{
			//to read the data from csv file
			FileReader fr=new FileReader("./src/test/resources/datacsv.csv");
			CSVReader reader=new CSVReader(fr);
			
			//navigate to each cell data
			while((cell=reader.readNext())!=null)
			{
				String keyword=cell[0];
				System.err.println(keyword);
			}
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
