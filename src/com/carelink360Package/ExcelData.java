package com.carelink360Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelData
{
	
	String getExceldata(String xpath,String sheet,int rownum,int celnum) throws InvalidFormatException, IOException
  {
	  FileInputStream file = new FileInputStream(xpath);   
	  WorkbookFactory wbf=new WorkbookFactory();
	  Workbook wb=wbf.create(file);
	  Sheet st=wb.getSheet("Sheet1");
	 // return st.getRow(rownum).getCell(celnum);
	  return "";
	
	  
  }
  String setExceldata(String xpath,String sheet,int rownum,int celnum) throws InvalidFormatException, IOException
  {
	  FileInputStream file = new FileInputStream(xpath);   
	  WorkbookFactory wbf=new WorkbookFactory();
	  Workbook wb=wbf.create(file);
	  return " ";
  }
  int getRowCount(String xpath,String sheet) throws InvalidFormatException, IOException
  {
	  FileInputStream file = new FileInputStream(xpath);   
	  WorkbookFactory wbf=new WorkbookFactory();
	  Workbook wb=wbf.create(file);
	  return 1;
  }
  
  
}

