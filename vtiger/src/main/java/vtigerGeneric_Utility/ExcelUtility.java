package vtigerGeneric_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtility 
{
	public void updateExcelData(String sheet,int row,int cell,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream(Ipathconstant.excelfilepath);
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheet).createRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(Ipathconstant.excelfilepath);
		wb.write(fos);
		wb.close();
		
	}
	public String getExcelData(String sheet,int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis=new FileInputStream(Ipathconstant.excelfilepath);
		Workbook wb=WorkbookFactory.create(fis); 
		DataFormatter format=new DataFormatter();
		String Exceldata=format.formatCellValue(wb.getSheet(sheet).getRow(rowNum).getCell(cellNum));
		return Exceldata;
	}
	
	@DataProvider
	public Object[][] getMultiple() throws Throwable
	{
		FileInputStream fis=new FileInputStream(Ipathconstant.excelfilepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet3");
		int lastRow=sh.getLastRowNum()+1;
		int lastCell=sh.getRow(0).getLastCellNum();
		Object[][]  obj=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}

}
