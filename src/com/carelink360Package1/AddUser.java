package com.carelink360Package1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
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

public class AddUser extends com.carelink360Package.StartUp
{    
@BeforeTest
public void beforeTest() throws InvalidFormatException, IOException, InterruptedException 
{
	// start("https://cm-dev5.cloudapp.net/#/");
	//  login();
}
@Test
public void UserTest() throws InterruptedException, InvalidFormatException, IOException 
{
		Thread.sleep(3000);
	    System.out.println("in Add user");
	    int adduserrct=AddUser.getLastRowNum();//number of rows from AddUser
	    System.out.println(adduserrct);
	    for (int i=1; i<=adduserrct; i++)  //loop for all rows from AddUser Excel sheet
		{  
	    	
	    	//click on Admin,Add New User
	    	Thread.sleep(5000);
	    	driver.findElement(By.xpath("//li[@id='mnuAdmin']/a")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//li[@id='mnuAdmin']/ul/li[1]")).click();
		    Thread.sleep(2000);
		    
		    
		    String Ufncellvalue="", Ulncellvalue="", Urolecellvalue="", Udepartmentcellvalue="", Uphnocellvalue="", Uemailcellvalue="";
		    String Uaddresscellvalue="", Ucitycellvalue="", Ustatecellvalue="", Uzipcellvalue="";
		    WebElement Ufn, Uln,Urole,Udepartment,Uphno,Uemail,Uaddress,Ucity,Ustate,Uzip,Cancel;
		    
		    int j=0;
	    
		    Ufn=driver.findElement(By.xpath(obj.getProperty("UserFName")));
		    Uln =driver.findElement(By.xpath(obj.getProperty("UserLName")));
		    Urole =driver.findElement(By.name("Roles"));
		    Udepartment=driver.findElement(By.name("Departments"));
		    Uphno=driver.findElement(By.xpath("//div/input[@name='Phone']"));
		    Uemail= driver.findElement(By.xpath("//div/input[@name='email']"));
		    Uaddress=driver.findElement(By.xpath(obj.getProperty("User_Add")));
		    Ucity=driver.findElement(By.xpath("//div/input[@name='City']"));
		    Ustate=driver.findElement(By.name("States"));
		    Uzip=driver.findElement(By.xpath("//div/input[@name='Pin']"));
		    Cancel=driver.findElement(By.xpath("//button[text()=' Cancel ']"));
	   
	 
		    String UFNameregex = "[a-zA-Z]+\\.?";
		    String ULNameregex = "[a-zA-Z]+\\.?";
		    String Uphregex = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
		    String Ueidregex = "^[_A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+(\\.[A-Za-z]{2,}|com|net)$";
		    String Ucityregex = "[a-zA-Z]+\\.?";
		    String Uzipregex = "\\d{5}(-\\d{4})?";
		    
		    int count=0;
		    
		    //For First Name
		    try
		    {
	    	
		    	Ufncellvalue=excelvalidation(AddUser.getRow(i).getCell(j));//taking value from excel sheet and checking for numeric ,null,or string
		    	Ufn.sendKeys(Ufncellvalue);
		    	
		    	if(Ufncellvalue.matches(UFNameregex)==false) //checking with regular expression
		    	{
		    	    if(Ufn.getCssValue("border-color").equals("rgb(255, 0, 0)")==true) //checking highlight in red color
					{
		    	    	((JavascriptExecutor)driver).executeScript("alert('Invalid User First Name');");
		    	    	Thread.sleep(3000);
		    	    	driver.switchTo().alert().accept();
		    	    	System.out.println("Invalid User First Name: "+ Ufncellvalue);
		    	    	count=count+1;
					}
		    	    else
		    	    {
		    	    }
	    		}
		    	else
		    	{
		    		Ufn.clear();
		    		Ufn.sendKeys(Ufncellvalue);
		    	}
		    }
		    catch(NullPointerException ex) //handling null value from excel sheet
		    {
		    	Ufn.sendKeys("");
		    	Ufn.clear();
		    	if(Ufn.getCssValue("border-color").equals("rgb(255, 0, 0)")==true) //checking highlight in red color
				{
		    		((JavascriptExecutor)driver).executeScript("alert('User First Name is Empty');");
		    		Thread.sleep(3000);
		    		driver.switchTo().alert().accept();
		    		System.out.println("empty user  first name");
		    		count=count+1;
				}
		    	else
		    	{
		    	}
		    }
		    //For Last Name
		    try
		    {
		    	Ulncellvalue=excelvalidation(AddUser.getRow(i).getCell(j+1)); //taking value from excel sheet and checking for numeric ,null,or string
		    	Uln.sendKeys(Ulncellvalue);
		    	
		    	if(Ulncellvalue.matches(ULNameregex)==false)
		    	{
		    		if(Uln.getCssValue("border-color").equals("rgb(255, 0, 0)")==true) //checking highlight in red color
					{
		    			((JavascriptExecutor)driver).executeScript("alert('Invalid User Last Name');");
		    			Thread.sleep(3000);
		    			driver.switchTo().alert().accept();
		    			System.out.println("Invalid User Last Name: "+ Ulncellvalue);
		    			count=count+1;
					}
		    		else
		    		{
		    		}
		    	}
		    	else
		    	{
	    		Uln.clear();
	    		Uln.sendKeys(Ulncellvalue);
		    	}
		    }
		    catch(NullPointerException ex)  //handling null value from excel sheet
		    {
		    	Uln.sendKeys("");
		    	Uln.clear();
		    	if(Uln.getCssValue("border-color").equals("rgb(255, 0, 0)")==true) //checking highlight in red color
				{
		    		((JavascriptExecutor)driver).executeScript("alert('User Last Name is Empty');");
		    		Thread.sleep(3000);
		    		driver.switchTo().alert().accept();
		    		System.out.println("empty user last name");
		    		count=count+1;
				}
		    	else
		    	{
		        }
		    }
		    //For Role field
		    try
		    {
		    	Urolecellvalue=excelvalidation(AddUser.getRow(i).getCell(j+2));//taking value from excel sheet and checking for numeric ,null,or string
		    	Select slt=new Select(Urole);
		    	List<WebElement> roles=slt.getOptions();  //list for roles from dropdown
		    	int e1count=0;
		    	for(WebElement e1: roles)  //for each role 
		    	{
		    		if(e1.getText().equals(Urolecellvalue)) //checking role from excel is available in dropdown
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
		    		Thread.sleep(3000);
		    		slt.selectByVisibleText(Urolecellvalue);
			     }
		    	else
		    	{
		    		((JavascriptExecutor)driver).executeScript("alert('Role is invalid');");
		    		Thread.sleep(3000);
		    		driver.switchTo().alert().accept();
		    		System.out.println("Role invalid");
			     }
		    
		    }
		    catch(NullPointerException ex)//handling null value 
		    {
		    	((JavascriptExecutor)driver).executeScript("alert('Role is Empty');");
		    	Thread.sleep(3000);
		    	driver.switchTo().alert().accept();
		    	System.out.println("Role Empty");
		    }
		    
		    //For department
		    try
		    {
	
		    	Udepartmentcellvalue=excelvalidation(AddUser.getRow(i).getCell(j+3));//taking value from excel sheet and checking for numeric ,null,or string
		    	Select slt1=new Select(Udepartment);
		    	List<WebElement> departments=slt1.getOptions();  //list for all departments
		    	int e2count=0;
		    	for(WebElement e2:departments)
		    	{
		    		if(e2.getText().equals(Udepartmentcellvalue)==true) //checking department from excel is available in dropdown
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
			      
		    	}
		    }
		    catch(NullPointerException ex) //handling null values
		    {
		    	((JavascriptExecutor)driver).executeScript("alert('Department is empty');");
		    	Thread.sleep(3000);
		    	driver.switchTo().alert().accept();
		    	System.out.println("Department empty");
	      
		    }
	      //For Phone Number
		    try
		    {
		    	Uphnocellvalue=excelvalidation(AddUser.getRow(i).getCell(j+4));//taking value from excel sheet and checking for numeric ,null,or string
		    	System.out.println(Uphnocellvalue);
		    	Uphno.sendKeys(Uphnocellvalue);
		    	if(Uphnocellvalue.matches(Uphregex)==false)//checking regular expression 
		    	{
		    		if(Uphno.getCssValue("border-color").equals("rgb(255, 0, 0)")==true) //checking highlight in red color
					{
		    			((JavascriptExecutor)driver).executeScript("alert('Invalid Phone Number');");
		    			Thread.sleep(3000);
		    			driver.switchTo().alert().accept();
		    			System.out.println("Invalid Phone No: "+ Uphnocellvalue);
		    			count=count+1;
					}
		    		else
		    		{
		    		}
		    	}
		    	else
		    	{
		    		Uphno.clear();
		    		Uphno.sendKeys(Uphnocellvalue);
		    	}
		    }
		    catch(NullPointerException ex)//handling null value
		    {
		    	Uphno.sendKeys("");
		    	Uphno.clear();
		    	if(Uphno.getCssValue("border-color").equals("rgb(255, 0, 0)")==true) //checking highlight in red color
				{
		    		((JavascriptExecutor)driver).executeScript("alert('Phone Number is empty');");
		    		Thread.sleep(3000);
		    		driver.switchTo().alert().accept();
		    		System.out.println("empty phone number");
		    		count=count+1;
				}
		    	else
		    	{
		    	}
	        }
	       //for email address
	       Uemailcellvalue=excelvalidation(AddUser.getRow(i).getCell(j+5)); //taking value from excel sheet and checking for numeric ,null,or string
	      
	       if(Uemailcellvalue.equals("")) //handling null value from excel sheet
	       {
	    			Uemail.sendKeys("");
	    			Uemail.clear();
	    			if(Uemail.getCssValue("border-color").equals("rgb(255, 0, 0)")==true) //checking highlight in red color
					{
	    				((JavascriptExecutor)driver).executeScript("alert('Email Address is empty');");
	    				Thread.sleep(3000);
	    				driver.switchTo().alert().accept();
	    				System.out.println("empty Email Address");
	    				count=count+1;
					}
	    			else
	    			{
	    			}
	       }
	       else
	       {
	    	  Uemail.sendKeys(Uemailcellvalue);
	    	  if(Uemailcellvalue.matches(Ueidregex)==false) //checking with regular expression
	    	  {
	    		  if(Uemail.getCssValue("border-color").equals("rgb(255, 0, 0)")==true) //checking highlight in red color
					{
	    			  ((JavascriptExecutor)driver).executeScript("alert('Invalid Email Address');");
	    			  Thread.sleep(3000);
	    			  driver.switchTo().alert().accept();
	    			  System.out.println("Invalid Email Address: "+ Uemailcellvalue);
	    			  count=count+1;
					}
	    		  else
	    		  {
	    		  }
	    	  }
	    	  else
	    	  {
	    		Uemail.clear();
	    		Uemail.sendKeys(Uemailcellvalue);
	    	  }
	    	 
	       	}
	     //For Address 
	       try
	       {
	    	   Uaddresscellvalue=excelvalidation(AddUser.getRow(i).getCell(j+6)); //taking value from excel sheet and checking for numeric ,null,or string
	    	   Uaddress.sendKeys(Uaddresscellvalue);
		    	
	       }
	       catch(NullPointerException ex) //handling null value
	    	{
	    	   		Uaddress.sendKeys("");
			       	Uaddress.clear();
			       ((JavascriptExecutor)driver).executeScript("alert('User Address Empty');");
			       Thread.sleep(3000);
			       driver.switchTo().alert().accept();
			       System.out.println("empty user address name");
	    	}
	       //For City
		   try
		   {
			   Ucitycellvalue=excelvalidation(AddUser.getRow(i).getCell(j+7));//taking value from excel sheet and checking for numeric ,null,or string
			   Ucity.sendKeys(Ucitycellvalue);
		   
			   if(Ucitycellvalue.matches(Ucityregex)==false) //Checking regular expression
		    	  {
				   		((JavascriptExecutor)driver).executeScript("alert('Invalid City');");
				   		Thread.sleep(3000);
				   		driver.switchTo().alert().accept();
				   		System.out.println("Invalid Citys: "+ Ucitycellvalue);
				       
		    	  }
		    	  else
		    	  {
		    		Ucity.clear();
		    		Ucity.sendKeys(Ucitycellvalue);
		    	  }
		   }
		   catch(NullPointerException ex)  //Handling null value
		   {
					 ((JavascriptExecutor)driver).executeScript("alert('Cityis empty');");
				       Thread.sleep(3000);
				       driver.switchTo().alert().accept();
				       System.out.println("State is empty");
				       
		   }
		  try
		  {
			    	Ustatecellvalue=excelvalidation(AddUser.getRow(i).getCell(j+8)); //taking value from excel sheet and checking for numeric ,null,or string
			    	Select slt2=new Select(Ustate);
				    List<WebElement> states=slt2.getOptions(); //list for all states from dropdown
				    int e3count=0;
				    for(WebElement e3:states)
				    {
				       if(e3.getText().equals(Ustatecellvalue)) //checking data from excel sheet is available in dropdown
				       {
				    	   e3count=1;
				       }
				       else
				       {
				       }
				    }
				    if(e3count==1)
				    {
				    	Ustate.click();
				    	Thread.sleep(2000);
				    	slt2.selectByVisibleText(Ustatecellvalue);
				    	
				    }
				    else
				    {
				    	((JavascriptExecutor)driver).executeScript("alert('State is invalid');");
					       Thread.sleep(3000);
					       driver.switchTo().alert().accept();
					       System.out.println("State is invalid");
					        
				    }
		  }
		  catch(NullPointerException ex)//handling null value
		  {
			  ((JavascriptExecutor)driver).executeScript("alert('State is empty');");
		       Thread.sleep(3000);
		       driver.switchTo().alert().accept();
		       System.out.println("State is empty");
		  }
		  //For Zip Value
		  try
		  {
				    	Uzipcellvalue=excelvalidation(AddUser.getRow(i).getCell(j+9));//taking value from excel sheet and checking for numeric ,null,or string
				    	Uzip.sendKeys(Uzipcellvalue);
				    	if(Uzipcellvalue.matches(Uzipregex)==false) //checking with regaular expression
				    	{
				    		 ((JavascriptExecutor)driver).executeScript("alert('Invalid ZIP Code');");
						       Thread.sleep(3000);
						       driver.switchTo().alert().accept();
						       System.out.println("Invalid ZIP Code: "+ Uzipcellvalue);
						   
				    	}
				    	else
				    	{
				    		Uzip.clear();
				    		Uzip.sendKeys(Uzipcellvalue);
				    	}
		  }
		  catch(NullPointerException ex)//handling null value
		  {
			  	((JavascriptExecutor)driver).executeScript("alert('Empty ZIP Code');");
		       Thread.sleep(3000);
		       driver.switchTo().alert().accept();
		  }
		  
		  driver.findElement(By.xpath("//div/button[2]")).click();  //click on "Save" button
		  Thread.sleep(5000);
		  Row row = AddUser.getRow(i);
		  Cell invalidcell=row.createCell(j+10);
		  int rwct=ValidUser.getLastRowNum();
		  System.out.println(rwct);
		  Row row1=ValidUser.createRow(rwct+1);
		  Cell cell1=row1.createCell(j);
		  Cell cell2=row1.createCell(j+1);
		  Cell cell3=row1.createCell(j+2);
		  Cell cell4=row1.createCell(j+3);
		  Cell cell5=row1.createCell(j+4);
		  Cell cell6=row1.createCell(j+5);
		  Cell cell7=row1.createCell(j+6);
		  Cell cell8=row1.createCell(j+7);
		  Cell cell9=row1.createCell(j+8);
		  Cell cell10=row1.createCell(j+9);	
		  
		  if(count!=0) //checking data in invalid
	      {
			invalidcell.setCellValue("invalid"); //printing invalid in excel sheet for invalid data
			Cancel.click();
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
		  //checking for user already exists
		   else if(driver.findElement(By.xpath(obj.getProperty("useraddedsuccessmsg"))).getText().equals("User Already Exists"))
		   {
				invalidcell.setCellValue("Already Exists");//printing already exist in excel sheet
		    	Cancel.click();
		   }
		  //checking for valid 
		   else
		   {
			   invalidcell.setCellValue("valid"); //printing invalid in excel sheet
			   cell1.setCellValue(Ufncellvalue);
			   cell2.setCellValue(Ulncellvalue);
			   cell3.setCellValue(Urolecellvalue);
			   cell4.setCellValue(Udepartmentcellvalue);
			   cell5.setCellValue(Uphnocellvalue);
			   cell6.setCellValue(Uemailcellvalue);
			   cell7.setCellValue(Uaddresscellvalue);
			   cell8.setCellValue(Ucitycellvalue);
			   cell9.setCellValue(Ustatecellvalue);
			   cell10.setCellValue(Uzipcellvalue); 		   
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
			   //wait
			   
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.getProperty("useraddedsuccessmsg"))));
			   Thread.sleep(3000);
			   
			   //for compumatrice email address will call method from StartUp class
			   if(AddUser.getRow(i).getCell(j+5).getStringCellValue().contains("compumatrice")==true)
			   {
				   compumatriceactivatelink(AddUser.getRow(i).getCell(j+5).getStringCellValue(),"Welcome to Carelink360 by");
	           }
			   //For gmail email address will call method from StartUp class
	           else
	           {
	        	   //For Email with + sign
	        	   if(AddUser.getRow(i).getCell(j+5).getStringCellValue().contains("+")==true)
	        	  {
	        		  String[] result=AddUser.getRow(i).getCell(j+5).getStringCellValue().split("\\+");
	        		  gmailactivatelink(result[0],"Welcome to Carelink360 by");
	        	  }
	        	  else
	        	  {
	        		  gmailactivatelink(AddUser.getRow(i).getCell(j+5).getStringCellValue(),"Welcome to Carelink360 by");
	        	  }
	        	  
	           }
		 	  	Thread.sleep(8000);
		 	  	
		 	  	//To get access of child window
		 	  	Iterator<String> itr1=driver.getWindowHandles().iterator();
		 	  	String parent1=itr1.next();
		 	  	String child1=itr1.next();
		 	  	driver.close();
		 	  	driver.switchTo().window(child1);
		 	  	
		 	  	
		 	  	login();
			
	      }  //end of else	
					 
	   }//end of for loop
	   
  }
 
  //@AfterTest
  public void afterTest()
  {
	  quit();
  }

}
