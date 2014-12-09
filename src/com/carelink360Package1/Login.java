package com.carelink360Package1;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.carelink360Package.*;

public class Login extends com.carelink360Package.StartUp
{
	//@BeforeTest
	  public void beforeTest() throws InvalidFormatException, IOException, InterruptedException 
	{
		start("https://cm-dev5.cloudapp.net:8443/#/");
		
	  }

  @Test
  public void f() throws InterruptedException 
  {
	  
	  System.out.println("Welcome login");
	  Thread.sleep(5000);
	  
    Iterator<String> itr=driver.getWindowHandles().iterator();
      String parent=itr.next();
      String child=itr.next();
      driver.switchTo().window(child); 
	  
      driver.get("https://cm-dev5.cloudapp.net:8443/#/");
      Thread.sleep(4000);
      WebElement Username=driver.findElement(By.xpath(obj.getProperty("Admin_EmailAddress")));
  	
	   WebElement AdPass=driver.findElement(By.xpath(obj.getProperty("Admin_Password")));
	   int rowct=Login.getLastRowNum();
	   System.out.println("login count : " +rowct);
	   int j=0;
	   Username.sendKeys(Login.getRow(rowct).getCell(j).getStringCellValue());	
	   AdPass.sendKeys("a");
	   AdPass.clear();
	   AdPass.sendKeys(Login.getRow(rowct).getCell(j+1).getStringCellValue());
	   Thread.sleep(3000);
	   WebElement SignIn=driver.findElement(By.xpath(obj.getProperty("SignInButton")));
	   SignIn.click();
	   Thread.sleep(4000);
	   try
	   {
		   String org=Login.getRow(rowct).getCell(j+2).getStringCellValue();
		   
				  
		 driver.findElement(By.xpath("//html/body/div[4]/div/div/div[2]/ul/li/label/input[@value='"+org+"']")).click();
		 Thread.sleep(4000);
		 driver.findElement(By.xpath(obj.getProperty("Org_OkButton"))).click();
		 }
		 catch(Throwable t)
		 {
		 System.out.println("organization is empty");
		 }
	     Thread.sleep(10000);
	     
	   //  WebElement Logout=driver.findElement(By.xpath(obj.getProperty("Logout")));
	  //   Logout.click();
	  //   Thread.sleep(4000);
	     System.out.println("Login done");
  }
 
  @AfterTest
  public void afterTest() 
  {
  }

}
