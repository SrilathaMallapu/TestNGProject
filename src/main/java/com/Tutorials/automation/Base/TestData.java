package com.Tutorials.automation.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(indices= {1,2})
      public Object[][] supplydata()throws Exception
      {
	FileInputStream fis = null;
	
	File Test=new File("C:\\Automation_scripts\\TeamMember2\\TestNGProject\\src\\main\\Resources\\TestData\\TestData.xlsx");
	try
	{
 fis=new FileInputStream(Test);
	}catch(Exception e)
	{
		e.getStackTrace();
	}
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet =workbook.getSheet("LoginTest");
	int row=sheet.getLastRowNum();
	int cols=sheet.getRow(0).getLastCellNum();
	Object[][] Logindata=new Object[3][3];
	/*System.out.println(row);
	System.out.println(cols);*/
	
	for(int i=1;i<=row;i++)
	{
		XSSFRow row1=sheet.getRow(i);
		for(int j=0;j<cols;j++)
		{
		XSSFCell celldata=row1.getCell(j);
			CellType celltyp=celldata.getCellType();
			switch(celltyp)
			{
			case STRING:
				System.out.print(celldata.getStringCellValue()+" ");
				Logindata[i][j]=celldata;
	              break;
			/*case NUMERIC:
				System.out.print(celldata.getNumericCellValue()+"");
				Logindata[i][j]=celldata;
				break;*/
			}
			
		}
		System.out.println();
	}
	
	//System.out.println("This is the result for the stored array");
	//System.out.println();
	
	//Iterator<Row> itr=sheet.getRow();
	/*for(Object[] innerdata:Logindata)
	{
		for(Object data:innerdata)
		{
		
		System.out.print(data+" ");
		}
		System.out.println();
	}*/
	return Logindata;
	}
	
}
	
	
	