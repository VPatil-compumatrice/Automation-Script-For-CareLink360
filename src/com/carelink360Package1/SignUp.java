package com.carelink360Package1;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;





public class SignUp extends com.carelink360Package.StartUp
{
	
@BeforeTest
public void beforeTest() throws IOException, InterruptedException, InvalidFormatException 
{
		start("https://cm-dev5.cloudapp.net/#/");//start method to open browser
}
 @Test
 public void signuptest() throws InvalidFormatException, IOException, InterruptedException
 {
	   
	    String FNcellvalue="",LNcellvalue="",Emailcellvalue="",PSWcellvalue="",RPSWcellvalue="",ORGcellvalue="";
	    Thread.sleep(4000);
	    //Verifying after entering url sign up page is opeing or not
	  	Assert.assertTrue(driver.getTitle().equals("Sign Up"), "This is not Carelink360 Sign Up page");
		
	  	int rct=SignUpmanualorg.getLastRowNum();//taking last row number for SignUpmanualorg excel sheet
		System.out.println(rct);
	    for (int i=1; i<=rct; i++) //loop for getting all rows from excel sheet 
		{  
	    	 int j=0;
  		    
		
		     WebElement FN=driver.findElement(By.xpath(obj.getProperty("SignUp_FirstName")));  
		     WebElement LN=driver.findElement(By.xpath(obj.getProperty("SignUp_LastName"))); 
		     WebElement Email=driver.findElement(By.xpath(obj.getProperty("SignUp_EmailAddress")));
		     WebElement PSW=driver.findElement(By.xpath(obj.getProperty("SignUp_Password")));
		     WebElement RPSW=driver.findElement(By.xpath(obj.getProperty("SignUp_ConfirmPassword")));
		     WebElement ORG=driver.findElement(By.xpath(obj.getProperty("SignUp_Organization")));
		     
		     String FNameregex = "[a-zA-Z]+\\.?";
		     String LNameregex = "[a-zA-Z]+\\.?";
		     String eidregex = "^[_A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+(\\.[A-Za-z]{2,}|com|compumatrice)$";
		     String pswregx="(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z])";
		    	 
		     int count=0; //set count for checking valid and invalid data
		     try
		     {
		        //For First Name
		        try
		    	{
		    	   //checking cell value
		    	   FNcellvalue=excelvalidation(SignUpmanualorg.getRow(i).getCell(j)); //taking value from excel sheet and checking for numeric ,null,or string
		    	   FN.sendKeys(FNcellvalue);  
		    	           
		    	   if(FNcellvalue.matches(FNameregex)==false) //checking with regular exp
		           {
					  if(FN.getCssValue("border-color").equals("rgb(255, 0, 0)")==true) //checking highlight in red color
					  {
						 ((JavascriptExecutor)driver).executeScript("alert('invalid first name');"); //showing alert
						  Thread.sleep(3000);
						  driver.switchTo().alert().accept();
						  System.out.println("invalid first Name: "+ FNcellvalue);
						  count=count+1;
					   }
					   else
					   {
					       System.out.println("For invalid data first name textbox not highlighted in red color");
					   }
					 }
		    		 else
		    		 {
		    			 FN.clear();
		    			 FN.sendKeys(FNcellvalue);
		    		 }
		          }
		    	  catch(NullPointerException ex)  //handling null value
		    	   {
		    		  FN.sendKeys("");
		    		  FN.clear();
		    		  if(FN.getCssValue("border-color").equals("rgb(255, 0, 0)")==true) //checking highlight in red color
					  {
					       ((JavascriptExecutor)driver).executeScript("alert('First Name is Empty');");
					        Thread.sleep(3000);
					         driver.switchTo().alert().accept();
					         System.out.println("empty first name");
					         count=count+1;
					  }
		    		  else
		    		  {
		    		    System.out.println("For empty data first name textbox not highlighted in red color");
		    		  }
		    	    }
		        //For Last Name
			        try
			        {
		               LNcellvalue = excelvalidation(SignUpmanualorg.getRow(i).getCell(j+1)); //taking value from excel sheet and checking for numeric ,null,or string
		               LN.sendKeys(LNcellvalue);
		               if(LNcellvalue.matches(LNameregex)==false)//checking with regular exp
		               {
		                   if(LN.getCssValue("border-color").equals("rgb(255, 0, 0)")==true)//checking highlight in red color
					        {
				    	          ((JavascriptExecutor)driver).executeScript("alert('invalid Last name');");
				    	          Thread.sleep(3000);
				    	          driver.switchTo().alert().accept();
			        	          System.out.println("invalid Last name: "+ LNcellvalue);
				    	           count=count+1;
					         }
		                	 else
		                	 {
		                		System.out.println("For empty data last name textbox not highlighted in red color");
		                	 }
			             }
		                 else
		                 {
		                	    LN.clear();;
		                	    LN.sendKeys(LNcellvalue);
		                 }
			          }
			          catch(NullPointerException ex)//handling null value from excel sheet
			          {
			        	  LN.sendKeys("");
		    		      LN.clear();
		    		      if(LN.getCssValue("border-color").equals("rgb(255, 0, 0)")==true) //checking highlight in red color 
					      {
				    	      ((JavascriptExecutor)driver).executeScript("alert('Last name is empty');"); //Showing alert
				    	      Thread.sleep(3000);
				    	      driver.switchTo().alert().accept();
			        	      System.out.println("empty last name");
				    	      count=count+1;
					      }
		    		      else
		    		      {
		    		    	   System.out.println("For empty data last name textbox not highlighted in red color");
		    		      }
				       }
			         //For Email
				     Emailcellvalue=excelvalidation(SignUpmanualorg.getRow(i).getCell(j+2));//taking value from excel sheet and checking for numeric ,null,or string
				     
				     //handling for null value from excel sheet
				     if(Emailcellvalue.equals(""))
				    {
				    	Email.sendKeys("");
		    		    Email.clear();	
		    		    if(Email.getCssValue("border-color").equals("rgb(255, 0, 0)")==true) //checking highlight in red color 
				         {   
					          ((JavascriptExecutor)driver).executeScript("alert('Email is empty');");
					           Thread.sleep(3000);
					           driver.switchTo().alert().accept();
					           System.out.println("Email is empty");
					           count=count+1;
				         }
		    		    else
		    		    {
		    		    	System.out.println("For empty data email textbox not highlighted in red color");
		    		    }
		    		    
		    		  }
				     
				      Email.sendKeys(Emailcellvalue);
			          if(Emailcellvalue.matches(eidregex)==false)//checking with regular exp
			          {
			        	if(Email.getCssValue("border-color").equals("rgb(255, 0, 0)")==true) //checking highlight in red color 
				         {	
			    	       ((JavascriptExecutor)driver).executeScript("alert('invalid Email');");
			    	       Thread.sleep(3000);
			    	       driver.switchTo().alert().accept();
			    	       System.out.println("invalid Email: " + Emailcellvalue);
			    	           count=count+1;
				         }
			        	else
			        	{
			        		System.out.println("For invalid data email textbox not highlighted in red color");
			        	}
				
			          }
			          else
			          {
			             Email.clear();
			             Email.sendKeys(Emailcellvalue);
			          }
			      
			          //For Password
				      PSWcellvalue=excelvalidation(SignUpmanualorg.getRow(i).getCell(j+3)); //taking value from excel sheet and checking for numeric ,null,or string
				      //handling null value from excel sheet
		              if(PSWcellvalue.equals(""))
		              {
		        	      PSW.sendKeys("");
	    		          PSW.clear(); 
	    		           if(PSW.getCssValue("border-color").equals("rgb(255, 0, 0)")==true) //checking highlight in red color 
				           {	
		        	          ((JavascriptExecutor)driver).executeScript("alert('Password is empty');");
		        	          Thread.sleep(3000);
		        	          driver.switchTo().alert().accept();
		        	          System.out.println("Password is empty");
				           }
	    		           else
	    		           {
	    		    	       System.out.println("For empty data email textbox not highlighted in red color");  
	    		           }
		        	    
		               }
		               PSW.sendKeys(PSWcellvalue);
		               if((PSWcellvalue.matches(pswregx))==false) //checking with regular exp
		               {		
		        	      if(PSW.getCssValue("border-color").equals("rgb(255, 0, 0)")==true) //checking highlight in red color 
				          { 
		        	          ((JavascriptExecutor)driver).executeScript("alert('invalid Password');");
		        	           Thread.sleep(3000);
		        	           driver.switchTo().alert().accept();
		        	           System.out.println("invalid password: "+ PSWcellvalue);
				          }
		        	      else
		        	      {
		        		     System.out.println("For invalid data email textbox not highlighted in red color");
		        	      }
		               }
		               else
		               {
		        	        PSW.clear();
		        	        PSW.sendKeys(PSWcellvalue);
		               }
		          //For Confirm password
		               
		              RPSWcellvalue=excelvalidation(SignUpmanualorg.getRow(i).getCell(j+4));//taking value from excel sheet and checking for numeric ,null,or string
		              if(RPSWcellvalue.equals(""))//Handling null value
	    		      {
		               	RPSW.sendKeys("");
	    		        RPSW.clear();
	    		        if(RPSW.getCssValue("border-color").equals("rgb(255, 0, 0)")==true) //checking highlight in red color 
				        { 
	    	                   ((JavascriptExecutor)driver).executeScript("alert('Confirm Password is empty');");
	    	                   Thread.sleep(3000);
	    	                   driver.switchTo().alert().accept();
	    	                   System.out.println("Confirm Password is empty");
	    	                   count=count+1;
				         }
	    		         else
	    		         {
	    		    	    System.out.println("For empty data email textbox not highlighted in red color");
	    		         }
	    	          }
		              RPSW.sendKeys(RPSWcellvalue);
		              if(RPSWcellvalue.equals(PSWcellvalue)==false) //checking with regular exp
		              {
		    	          if(RPSW.getCssValue("border-color").equals("rgb(255, 0, 0)")==true) //checking highlight in red color 
			              {
		    	        	  ((JavascriptExecutor)driver).executeScript("alert('invalid Confirm Password');");
		    	        	  Thread.sleep(3000);
		    	        	  driver.switchTo().alert().accept();
		    	        	  System.out.println("invalid Confirm Password: "+ RPSWcellvalue);
		    	        	  count=count+1;
			              }
		    	          else
		    	          {
		    	        	  System.out.println("For invalid data email textbox not highlighted in red color"); 
		    	          }
		              }
		         //For Organization
		              
		              ORGcellvalue=excelvalidation(SignUpmanualorg.getRow(i).getCell(j+5));//taking value from excel sheet and checking for numeric ,null,or string
		              if(ORGcellvalue.equals(""))//Handling for null value
		              {
		            	  ORG.sendKeys("");
		            	  ORG.clear();
		            	  if(ORG.getCssValue("border-color").equals("rgb(255, 0, 0)")==true) //checking highlight in red color 
		            	  { 
		            		  ((JavascriptExecutor)driver).executeScript("alert('organization is empty');");
		            		  Thread.sleep(3000);
		            		  driver.switchTo().alert().accept();
		            		  System.out.println("organization is empty");
		            		  count=count+1;
		            	  }
		            	  else
		            	  {
		            		  System.out.println("For empty data email textbox not highlighted in red color");  
		            	  }
	    	       
		              }
		              ORG.sendKeys(ORGcellvalue);
		 
		     	}
		     	catch(NullPointerException ex)
		     	{
		    		 System.out.println("Some fields are empty");
		     	}
		     	catch(UnhandledAlertException e1)
		    	{
		    		System.out.println("unhandled alert exception"); 
		    	}
		    	Thread.sleep(8000);
		    	
		    	Row row=SignUpmanualorg.getRow(i);
		    	Cell invalidcell=row.createCell(j+6);
		    	//If count is not equal to 1 data is invalid
		    	if(count!=0)
		    	{
		    		invalidcell.setCellValue("invalid");//printing invalid data in ecel sheet
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
		    		driver.get("https://cm-dev5.cloudapp.net/#/");//if data is invalid page will refresh
		
		    	}
		    	else
		    	{
		    		invalidcell.setCellValue("valid");//print valid in excel sheet
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
			        //Click on Signup if data is valid
		    		driver.findElement(By.xpath(obj.getProperty("SignUp_Button"))).click(); 
		    		Thread.sleep(5000);
		    		//wait untill success message will visible
		    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.getProperty("SignUp_SuccessMsg"))));
		     
		        //---------------------------Activate link--& sending data in login sheet----------------------------------
		    		
		    		//if email id contains compumatrice will call method from StartUp class
		    		if(SignUpmanualorg.getRow(i).getCell(j+2).getStringCellValue().contains("compumatrice")==true)
		    		{
		    			compumatriceactivatelink(SignUpmanualorg.getRow(i).getCell(j+2).getStringCellValue(),"Welcome to Carelink360 by");
		    		}
		    		//if email  id contains gmail will call method from StartUp class
		    		else
		    		{
		    			//if in gmail email contains "+" sign
		    			if(SignUpmanualorg.getRow(i).getCell(j+2).getStringCellValue().contains("+")==true)
		    			{
		    				String[] result=SignUpmanualorg.getRow(i).getCell(j+2).getStringCellValue().split("\\+");
		    				gmailactivatelink(result[0],"Welcome to Carelink360 by");
		    			}
		    			else
		    			{
		    				gmailactivatelink(SignUpmanualorg.getRow(i).getCell(j+2).getStringCellValue(),"Welcome to Carelink360 by");
		    			}
		    		}
		    		Thread.sleep(5000);
	            // After activation print email,password and organization on console
		    		System.out.println(SignUpmanualorg.getRow(i).getCell(j+2).getStringCellValue());
		    		System.out.println(SignUpmanualorg.getRow(i).getCell(j+3).getStringCellValue());
		    		System.out.println(SignUpmanualorg.getRow(i).getCell(j+5).getStringCellValue());
		 		
		    		int logrow=Login.getLastRowNum(); //last row number from Login sheet
		    		System.out.println(logrow);
		    		Row row1=Login.createRow(logrow+1);
		 		
		    		//print email,password and organization in Login sheet
		    		Cell cell1=row1.createCell(j);
		    		cell1.setCellValue(SignUpmanualorg.getRow(i).getCell(j+2).getStringCellValue());
		 		
		    		Cell cell2=row1.createCell(j+1);
		    		cell2.setCellValue(SignUpmanualorg.getRow(i).getCell(j+3).getStringCellValue());
		 		
		    		Cell cell3=row1.createCell(j+2);
		    		cell3.setCellValue(SignUpmanualorg.getRow(i).getCell(j+5).getStringCellValue());
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
		    		System.out.println("Sign Up done");
		        //To get access on child window
		    		Iterator<String> itr=driver.getWindowHandles().iterator();
		    		String parent=itr.next();
		    		String child=itr.next();
		    		driver.close();
		    		driver.switchTo().window(child);
		         //login method call
		    		login();
		    		System.out.println("login done");
		 	
		    	}//end of else  
		
			}//end of for loop 
  
 }

 // @AfterTest
  public void afterTest()
  {
	 quit();
  }
 

}
