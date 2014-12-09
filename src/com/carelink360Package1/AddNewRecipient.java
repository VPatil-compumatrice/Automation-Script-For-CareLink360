package com.carelink360Package1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class AddNewRecipient extends com.carelink360Package.StartUp
{
 
  @BeforeTest
  public void beforeTest() throws InvalidFormatException, IOException, InterruptedException 
  {
	  start("https://cm-dev5.cloudapp.net:8443/#/");
	  login();
  }
  
  @Test
  public void AddRecipient() throws InvalidFormatException, IOException, InterruptedException 
  {
	   String Rfncellvalue="", Rlncellvalue="",  Rphnocellvalue="", Remailcellvalue="";
	    String Raddresscellvalue="", Rcitycellvalue="", Rstatecellvalue="", Rzipcellvalue="";
	    String Rbeaconcellvalue="",Ridcellvalue="";
	    
	    driver.findElement(By.xpath("//li[@id='mnuAdmin']/a")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//li[@id='mnuAdmin']/ul/li[2]")).click();
	    Thread.sleep(2000);
	    
	    int addrecrct=AddNewrecipient.getLastRowNum();
	    for (int i=1; i<=addrecrct; i++)
		{  
	    	
		    
		   
		     int j=0;
	    
	    WebElement Rfn=driver.findElement(By.xpath(obj.getProperty("FirstName")));
	    WebElement Rln=driver.findElement(By.xpath(obj.getProperty("LastName")));
	    
	    WebElement Rphno=driver.findElement(By.xpath(obj.getProperty("PhoneNo")));
	    WebElement Remail= driver.findElement(By.xpath(obj.getProperty("Email")));
	    WebElement Raddress=driver.findElement(By.xpath(obj.getProperty("Addr")));
	    WebElement Rcity=driver.findElement(By.xpath(obj.getProperty("Cty")));
	    WebElement Rstate=driver.findElement(By.xpath(obj.getProperty("State")));
	    WebElement Rzip=driver.findElement(By.xpath(obj.getProperty("Zip")));
	    
	//   WebElement Rbeacon=driver.findElement(By.xpath(obj.getProperty(key)));
	    WebElement Rid=driver.findElement(By.xpath(obj.getProperty("RecipientId")));
	    
	    WebElement RSave=  driver.findElement(By.xpath(obj.getProperty("RSave")));
	    WebElement RCancel=driver.findElement(By.xpath(obj.getProperty("RCancel")));
	   
	 
	    String RFNameregex = "[a-zA-Z]+\\.?";
	    String RLNameregex = "[a-zA-Z]+\\.?";
	    String Rphregex = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
	    String Reidregex = "^[_A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+(\\.[A-Za-z]{2,}|com|net)$";
	    String Rcityregex = "[a-zA-Z]+\\.?";
	    String Rzipregex = "\\d{5}(-\\d{4})?";
	     
	    
	    int count=0;
	    
	    try
	    {
	    	
	    	Rfncellvalue=excelvalidation(AddNewrecipient.getRow(i).getCell(j));
	    	Rfn.sendKeys(Rfncellvalue);
	    	if(Rfncellvalue.matches(RFNameregex)==false)
	    	{
	    		 ((JavascriptExecutor)driver).executeScript("alert('Invalid Recipient First Name');");
			       Thread.sleep(3000);
			       driver.switchTo().alert().accept();
			       System.out.println("Invalid User First Name: "+ Rfncellvalue);
			       count=count+1;
	    	}
	    	else
	    	{
	    		Rfn.clear();
	    		Rfn.sendKeys(Rfncellvalue);
	    	}
	     }
	     catch(NullPointerException ex)
	     {
	    	  Rfn.sendKeys("a");
		       Rfn.clear();
		       ((JavascriptExecutor)driver).executeScript("alert('Recipient First Name is Empty');");
		       Thread.sleep(3000);
		       driver.switchTo().alert().accept();
		       System.out.println("empty Recipient  first name");
		       count=count+1;
	      }
	    
	   try
	    {
	    	Rlncellvalue=excelvalidation(AddNewrecipient.getRow(i).getCell(j+1));
	    	Rln.sendKeys(Rlncellvalue);
	    	if(Rlncellvalue.matches(RLNameregex)==false)
	    	{
	    		 ((JavascriptExecutor)driver).executeScript("alert('Invalid User Last Name');");
			       Thread.sleep(3000);
			       driver.switchTo().alert().accept();
			       System.out.println("Invalid User Last Name: "+ Rlncellvalue);
			       count=count+1;
	    	}
	    	else
	    	{
	    		Rln.clear();
	    		Rln.sendKeys(Rlncellvalue);
	    	}
	     }
	     catch(NullPointerException ex)
	     {
	    	  Rln.sendKeys("a");
		       Rln.clear();
		       ((JavascriptExecutor)driver).executeScript("alert('User Last Name is Empty');");
		       Thread.sleep(3000);
		       driver.switchTo().alert().accept();
		       System.out.println("empty user last name");
		       count=count+1;
	      }
	/*    try
	      {
	    	Urolecellvalue=excelvalidation(AddUser.getRow(i).getCell(j+2));
	    	Select slt=new Select(Urole);
		    List<WebElement> roles=slt.getOptions();
		    int e1count=0;
		    for(WebElement e1: roles)
		    {
		    	if(e1.getText().equals(Urolecellvalue))
		    	{
		    		 e1count=1;
		    		 slt.selectByVisibleText(Urolecellvalue);
		    	}
		    	else
		    	{
		    	}
		    	
		    }
		    if(e1count==1)
		    {
		    	  Urole.click();
		    	  Thread.sleep(2000);
		    	 slt.selectByVisibleText(Urolecellvalue);
			        
		    }
		    else
		    {
		    	((JavascriptExecutor)driver).executeScript("alert('Role is invalid');");
			       Thread.sleep(3000);
			       driver.switchTo().alert().accept();
			       System.out.println("Role invalid");
			       count=count+1;
		    }
		    
	     }
	     catch(NullPointerException ex)
	     {
	    	 
		       ((JavascriptExecutor)driver).executeScript("alert('Role is Empty');");
		       Thread.sleep(3000);
		       driver.switchTo().alert().accept();
		       System.out.println("empty Role");
		       count=count+1;
	      }
	    try
	    {  
	    	Udepartmentcellvalue=excelvalidation(AddUser.getRow(i).getCell(j+3));
	    	Select slt1=new Select(Udepartment);
		    List<WebElement> departments=slt1.getOptions();
		    int e2count=0;
		    for(WebElement e2:departments)
		    {
		       if(e2.getText().equals(Udepartmentcellvalue)==true)
		       {
		    	   e2count=1;
		       }
		       else
		       {
		       }
		    }
		    if(e2count==1)
		    {
		    	Udepartment.click();
		    	Thread.sleep(2000);
		    	slt1.selectByVisibleText(Udepartmentcellvalue);
		    	
		    }
		    else
		    {
		    	((JavascriptExecutor)driver).executeScript("alert('Department is invalid');");
			       Thread.sleep(3000);
			       driver.switchTo().alert().accept();
			       System.out.println("Department invalid");
			       count=count+1;
		    } 
		    
	     }
	     catch(NullPointerException ex)
	     {
	    	 
		       ((JavascriptExecutor)driver).executeScript("alert('Department is Empty');");
		       Thread.sleep(3000);
		       driver.switchTo().alert().accept();
		       System.out.println("empty Department");
		       count=count+1;
	      }*/
	    try
	    {
	    	Rphnocellvalue=excelvalidation(AddNewrecipient.getRow(i).getCell(j+2));
	    	System.out.println(Rphnocellvalue);
	    	Rphno.sendKeys(Rphnocellvalue);
	    	if(Rphnocellvalue.matches(Rphregex)==false)
	    	{
	    		 ((JavascriptExecutor)driver).executeScript("alert('Invalid Phone Number');");
			       Thread.sleep(3000);
			       driver.switchTo().alert().accept();
			       System.out.println("Invalid Phone No: "+ Rphnocellvalue);
			       count=count+1;
	    	}
	    	else
	    	{
	    		Rphno.clear();
	    		Rphno.sendKeys(Rphnocellvalue);
	    	}
	     }
	     catch(NullPointerException ex)
	     {
	    	  Rphno.sendKeys("a");
		       Rphno.clear();
		       ((JavascriptExecutor)driver).executeScript("alert('Phone Number is empty');");
		       Thread.sleep(3000);
		       driver.switchTo().alert().accept();
		       System.out.println("empty phone number");
		       count=count+1;
	        }
	    
	    	Remailcellvalue=excelvalidation(AddNewrecipient.getRow(i).getCell(j+3));
	    	
	    	if(Remailcellvalue.equals(""))
	    	{
	    		Remail.sendKeys("a");
			       Remail.clear();
			       ((JavascriptExecutor)driver).executeScript("alert('Email Address is empty');");
			       Thread.sleep(3000);
			       driver.switchTo().alert().accept();
			       System.out.println("empty Email Address");
			       count=count+1;
	    	 }
	        else
	    	{
	    	  Remail.sendKeys(Remailcellvalue);
	    	  if(Remailcellvalue.matches(Reidregex)==false)
	    	  {
	    		 ((JavascriptExecutor)driver).executeScript("alert('Invalid Email Address');");
			       Thread.sleep(3000);
			       driver.switchTo().alert().accept();
			       System.out.println("Invalid Email Address: "+ Remailcellvalue);
			       count=count+1;
	    	  }
	    	  else
	    	  {
	    		Remail.clear();
	    		Remail.sendKeys(Remailcellvalue);
	    	  }
	    	 
	       }
	    	
		   Raddresscellvalue=excelvalidation(AddNewrecipient.getRow(i).getCell(j+4));
		   Raddress.sendKeys(Raddresscellvalue);
		    	if(Raddresscellvalue.equals(""))
		    	{
		    		 Raddress.sendKeys("a");
				       Raddress.clear();
				       ((JavascriptExecutor)driver).executeScript("alert('User Address Empty');");
				       Thread.sleep(3000);
				       driver.switchTo().alert().accept();
				       System.out.println("empty recipient address name");
				       count=count+1;
		    	}
		    	else
		    	{
		    		Raddress.sendKeys(Raddresscellvalue);
		    	} 
		   try
		   {
		   Rcitycellvalue=excelvalidation(AddNewrecipient.getRow(i).getCell(j+5));
		   Rcity.sendKeys(Rcitycellvalue);
		   
			   if(Rcitycellvalue.matches(Rcityregex)==false)
		    	  {
		    		 ((JavascriptExecutor)driver).executeScript("alert('Invalid City');");
				       Thread.sleep(3000);
				       driver.switchTo().alert().accept();
				       System.out.println("Invalid Citys: "+ Rcitycellvalue);
				       count=count+1;
		    	  }
		    	  else
		    	  {
		    		Rcity.clear();
		    		Rcity.sendKeys(Rcitycellvalue);
		    	  }
		   }		
		   catch(NullPointerException ex)
		   {
			   Rcity.sendKeys("a");
		       Rcity.clear();
		       ((JavascriptExecutor)driver).executeScript("alert('User City Empty');");
		       Thread.sleep(3000);
		       driver.switchTo().alert().accept();
		       System.out.println("empty user city name");
		       count=count+1;
		   }
		   
		   try
		   {
			    	Rstatecellvalue=excelvalidation(AddNewrecipient.getRow(i).getCell(j+6));
			    	Select slt2=new Select(Rstate);
				    List<WebElement> states=slt2.getOptions();
				    int e3count=0;
				    for(WebElement e3:states)
				    {
				       if(e3.getText().equals(Rstatecellvalue))
				       {
				    	   e3count=1;
				       }
				       else
				       {
				       }
				    }
				    if(e3count==1)
				    {
				    	Rstate.click();
				    	Thread.sleep(2000);
				    	slt2.selectByVisibleText(Rstatecellvalue);
				    	
				    }
				    else
				    {
				    	((JavascriptExecutor)driver).executeScript("alert('State is invalid');");
					       Thread.sleep(3000);
					       driver.switchTo().alert().accept();
					       System.out.println("State is invalid");
					       count=count+1;	 
				    }
				    
			    }
			     catch(NullPointerException ex)
			     {
			    	 
				       ((JavascriptExecutor)driver).executeScript("alert('State is Empty');");
				       Thread.sleep(3000);
				       driver.switchTo().alert().accept();
				       System.out.println("empty state");
				       count=count+1;
			      } 
		    	  
				    try
				    {
				    	Rzipcellvalue=excelvalidation(AddNewrecipient.getRow(i).getCell(j+7));
				    	Rzip.sendKeys(Rzipcellvalue);
				    	if(Rzipcellvalue.matches(Rzipregex)==false)
				    	{
				    		 ((JavascriptExecutor)driver).executeScript("alert('Invalid ZIP Code');");
						       Thread.sleep(3000);
						       driver.switchTo().alert().accept();
						       System.out.println("Invalid ZIP Code: "+ Rzipcellvalue);
						       count=count+1;
				    	}
				    	else
				    	{
				    		Rzip.clear();
				    		Rzip.sendKeys(Rzipcellvalue);
				    		
				    	}
				     }
				     catch(NullPointerException ex)
				     {
				    	  Rzip.sendKeys("a");
					       Rzip.clear();
					       ((JavascriptExecutor)driver).executeScript("alert('ZIP Code is empty');");
					       Thread.sleep(3000);
					       driver.switchTo().alert().accept();
					       System.out.println("empty ZIP code");
					       count=count+1;
				        } 
				    
				    WebElement getlatitude=driver.findElement(By.xpath(obj.getProperty("LatitudeLongitude")));
				    getlatitude.click();
				    Thread.sleep(8000);
				    
				    try
				    {
				    	
				    	Ridcellvalue=excelvalidation(AddNewrecipient.getRow(i).getCell(j+8));
				    	Rid.sendKeys(Ridcellvalue);
				    	/*if(Ridcellvalue.matches(Ridregex)==false)
				    	{
				    		 ((JavascriptExecutor)driver).executeScript("alert('Invalid Recipient ID');");
						       Thread.sleep(3000);
						       driver.switchTo().alert().accept();
						       System.out.println("Invalid Recipient ID: "+ Ridcellvalue);
						       count=count+1;
				    	}
				    	else
				    	{   
				    		Rid.clear();
				    		Rid.sendKeys(Ridcellvalue);
				         }*/
				     }
				     catch(NullPointerException ex)
				     {
				    	  Rid.sendKeys("a");
					       Rid.clear();
					       ((JavascriptExecutor)driver).executeScript("alert('Recipient ID is Empty');");
					       Thread.sleep(3000);
					       driver.switchTo().alert().accept();
					       System.out.println("empty Recipient ID");
					       count=count+1;
				      }
				 
				  RSave.click();
				  Thread.sleep(5000);
			  
	 Row row = AddNewrecipient.getRow(i);
	 Cell invalidcell=row.createCell(j+9);
	if(count!=0)
	{
					   
					   invalidcell.setCellValue("invalid");
					   RCancel.click();
		try
		{
			excelfile1= new FileOutputStream("E:\\selenium\\Carelink360\\configFileforObjects\\Automation1.xlsx");
		      wb.write(excelfile1);
		      excelfile1.close();
		     }
		  catch(Throwable t )
		     {
			  System.out.println("File not found");
		     }	 			
					  
			        
	   }
	 else
	   {
		   invalidcell.setCellValue("valid");
		  
		   
		   try
		     {
	 			excelfile1= new FileOutputStream("E:\\selenium\\Carelink360\\configFileforObjects\\Automation1.xlsx");
		      wb.write(excelfile1);
		      excelfile1.close();
		     }
		  catch(Throwable t )
		     {
			  System.out.println("File not found");
		     }		  
			
	      }  //end of else	    
	   }//end of for loop  
	    
	    
	     
  }

  @AfterTest
  public void afterTest() {
  }

}
