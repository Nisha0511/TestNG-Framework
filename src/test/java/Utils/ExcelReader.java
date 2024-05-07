package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ProjectE2E.framework.Global;

public class ExcelReader {
	
	//read-file reader
	public static FileInputStream fis=null;
	
	//workbook-excelsheet-read
	
	public static XSSFWorkbook workbook=null;
	//sheet-read
	
	public static XSSFSheet sheet=null;
	
	//row
	public static XSSFRow row =null;
	
	//columnko read k lye
	public static XSSFCell cell=null;
	
	
	//Row read method
	public static int getRow(String TestCase, String TestDataPath) 
	{
		try {
			fis = new FileInputStream(TestDataPath);
			workbook = new XSSFWorkbook(fis);
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		int rowIndex=-1;
		
		sheet=workbook.getSheet("Login");
		//sheet=workbook.getSheetAt(0);
		
		for(rowIndex=1; rowIndex<=sheet.getLastRowNum(); rowIndex++)
		{
			row=sheet.getRow(rowIndex);
			if(row!=null)
			{
				Cell cell= row.getCell(0);
				
				if(cell!=null)
				{
					String cellValue=cell.getStringCellValue();
					
					if(cellValue.equalsIgnoreCase(TestCase))
					{
						break;
					}
					
				}
				
			
			}
			
			
			
			
		}
		return rowIndex;
	}
	
	public static String getCellData(String colname, int rownum, String TestDataPath)
	{
		

		try {
			fis = new FileInputStream(TestDataPath);
			workbook = new XSSFWorkbook(fis);
			int columnNum=-1;
			sheet=workbook.getSheet("Login");
			row=sheet.getRow(0);
			
			for(int i=0; i<row.getLastCellNum(); i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(colname.trim()))
				
					
					columnNum=i;
				
			}
			
				row=sheet.getRow(rownum);
				cell=row.getCell(columnNum)
					;
				
				return cell.getStringCellValue();
			
			
		}
		
		catch(Exception e)
		{
			
			e.printStackTrace();
			return "row or column doesn't exist";
		}
		
		
	}
	
	public static String getTestData(String TestCase,String colname, String TestDataPath)
	{
		
		String TCdata;
		int TCRow=getRow(TestCase, TestDataPath);
		
		if(TCRow!=-1)
		{
			TCdata=getCellData(colname,TCRow,Global.TestDataPath);
		}
		else {
			
			TCdata="test case No tFound In DataSheet";
			
		}
		return TCdata;
			
				
	}
	
	
	
	
	


}
