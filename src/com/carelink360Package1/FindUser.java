package com.carelink360Package1;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class FindUser extends com.carelink360Package.StartUp
{
	
String UserfnNamecellvalue="",UserlnNamecellvalue="",Useremailcellvalue="",Userphnocellvalue="";
@BeforeTest
public void beforeTest() throws InvalidFormatException, IOException, InterruptedException 
{
	  start("https://cm-dev5.cloudapp.net");
	  login();
	  
}
 
//To validate Find Menu tab 
@Test(priority = 1)
public void FindTextTest() throws InterruptedException, InvalidFormatException, IOException
{
	     WebElement  FindSerachimg=driver.findElement(By.xpath(obj.getProperty("FindSerachimg")));    
	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.getProperty("FindSerachimg"))));
	     Assert.assertTrue(FindSerachimg.isDisplayed(), "Search image should be displayed");
	     WebElement Findmenubutton=driver.findElement(By.xpath(obj.getProperty("Findmenubutton")));
	     Assert.assertTrue(Findmenubutton.isDisplayed(), "Find menu button should be displayed");
	     WebElement Find=driver.findElement(By.xpath(obj.getProperty("Find")));
	     Assert.assertTrue(Find.isDisplayed(), "Find WebElement should be display");
		 Assert.assertTrue(Find.getText().equals("Find"), "Find WebElement should contain text 'Find' ");
		 HighLight(driver,Find);
		 Find.click();
}
//To validate Provider / User tab
@Test(priority = 2)
public void FindProviderUserTest() throws InterruptedException
{
	     WebElement FindProviderUser=driver.findElement(By.xpath(obj.getProperty("FindUser")));
		 Assert.assertTrue(FindProviderUser.isDisplayed(), "Provider / User WebElement should be display");
		 Assert.assertTrue(FindProviderUser.getText().equals("Provider / User"),"Provider / User WebElement should have text 'Provider / User'" );
		 HighLight(driver,FindProviderUser);
		 FindProviderUser.click();
  }
//To validate after clicking on Provider / User,Search Provider / User page displaying
@Test(priority = 3)
public void FindProviderPageUserTest() throws InterruptedException
{
	Thread.sleep(3000);
	Assert.assertTrue(driver.getTitle().equals("Search Provider / User"), "Search Provider / User page should be open");
}
//To validate Search Image
@Test(priority = 4)
public void FindImgTest() throws InterruptedException
{
	  Thread.sleep(3000);
	  WebElement findimg=driver.findElement(By.xpath(obj.getProperty("findimg")));
      Assert.assertTrue(findimg.isDisplayed(), "Find Image should be display"); 
    //  HighLight(driver,findimg);
		 
} 
//Validate Find Provider / User text
@Test(priority = 5)
public void FindUserTextTest() throws InterruptedException
{
	  WebElement FindUsertext=driver.findElement(By.xpath(obj.getProperty("findusertext")));
	  Assert.assertTrue(FindUsertext.isDisplayed(), "Find Provider/User WebElement should be display ");
	  Assert.assertTrue(FindUsertext.getText().equals("Find Provider/ User"), "Find Provider/ User WebElement should display text 'Find Provider/ User'");
	  HighLight(driver,FindUsertext);
}
//To validate Search box
@Test(priority = 6)
public void FindUserSearchTest() throws InterruptedException
{
	  WebElement UserSearch=driver.findElement(By.xpath(obj.getProperty("UserSerach")));
	  Assert.assertTrue(UserSearch.isDisplayed(), "Search box is not displaying");
	  HighLight(driver,UserSearch);
}
//To validate User create link
/*@Test(priority = 7)
public void UserCreateTest() throws InterruptedException
{
	WebElement UserCreatelink=driver.findElement(By.xpath(obj.getProperty("UserCreatelink")));
	Assert.assertTrue(UserCreatelink.isDisplayed(), "User creation link should be display");
	HighLight(driver,UserCreatelink);
	WebElement ClickHere=driver.findElement(By.xpath(obj.getProperty("ClickHere")));
	HighLight(driver,ClickHere);
	ClickHere.click();
	Thread.sleep(3000);
	Assert.assertTrue(driver.getTitle().equals("AddUser"), "Add User page should get display");
	//To click on Find
	WebElement Find=driver.findElement(By.xpath(obj.getProperty("Find")));
    Assert.assertTrue(Find.isDisplayed(), "Find WebElement should be display");
    Assert.assertTrue(Find.getText().equals("Find"), "Find WebElement should contain text 'Find' ");
	HighLight(driver,Find);
	Find.click();
	//To click on Provider/user tab
	WebElement FindProviderUser=driver.findElement(By.xpath(obj.getProperty("FindUser")));
	Assert.assertTrue(FindProviderUser.isDisplayed(), "Provider / User WebElement should be display");
	Assert.assertTrue(FindProviderUser.getText().equals("Provider / User"),"Provider / User WebElement should have text 'Provider / User'" );
	HighLight(driver,FindProviderUser);
	FindProviderUser.click();
} */

@Test(priority = 8)
  public void FindUsertest() throws InterruptedException, InvalidFormatException, IOException
  {
	  int adduserrct=ValidUser.getLastRowNum();
	  System.out.println(adduserrct);
	  for (int i=1; i<=adduserrct; i++)
		{ 
		  	int j=0;
		  	//excel values for email,firstname,lastname and phone no
		  	Useremailcellvalue=excelvalidation(ValidUser.getRow(i).getCell(j+5));
		  	UserfnNamecellvalue=excelvalidation(ValidUser.getRow(i).getCell(j));
			UserlnNamecellvalue=excelvalidation(ValidUser.getRow(i).getCell(j+1));
			Userphnocellvalue=excelvalidation(ValidUser.getRow(i).getCell(j+4));
			
			//Serach by email
		    WebElement UserSearch=driver.findElement(By.xpath(obj.getProperty("UserSerach")));
		 	UserSearch.sendKeys(Useremailcellvalue);
		 	UserSearch.sendKeys(Keys.ENTER);
		    Thread.sleep(4000);
		    Assert.assertTrue(driver.getTitle().equals("User Details"), "User Details page should get display");
		    
		    //Validate First Name and Last Name
		 	WebElement UserName=driver.findElement(By.xpath(obj.getProperty("UserName")));
		 	Assert.assertTrue(UserName.getText().equals(UserfnNamecellvalue+" "+UserlnNamecellvalue),"User name is wrong");
		    HighLight(driver,UserName);
		    //Validate Search box
		    WebElement UserSearch1=driver.findElement(By.xpath(obj.getProperty("UserSerach")));
		    Assert.assertTrue(UserSearch1.isDisplayed(), "User Search box should get displayed");
		    HighLight(driver,UserSearch1);
		  /*  System.out.println(UserSearch1.getText());
		    System.out.println(Useremailcellvalue);
	        Assert.assertTrue(UserSearch1.getText().equals(Useremailcellvalue), "Same email address should be display");
	        HighLight(driver,UserSearch1);*/
		    
		    //Validate Paersonal Details and Edit button
		    WebElement PearsonalDeatails=driver.findElement(By.xpath(obj.getProperty("PearsonalDeatails")));
		    Assert.assertTrue(PearsonalDeatails.isDisplayed(), "Pearsonal Details webelement should be displayed");
		    Assert.assertTrue(PearsonalDeatails.getText().equals("Personal Details"), "Personal Details text should get displayed");
		    HighLight(driver,PearsonalDeatails);
		    WebElement UEditButton1=driver.findElement(By.xpath(obj.getProperty("UEditButton1")));
		    Assert.assertTrue(UEditButton1.isDisplayed(), "Edit button should get displayed");
		    HighLight(driver,UEditButton1);
		    WebElement UEditButton1pencil=driver.findElement(By.xpath(obj.getProperty("UEditButton1pencil")));
		    Assert.assertTrue(UEditButton1pencil.isDisplayed(), "Pencil icon should get display");
		    HighLight(driver,UEditButton1pencil);
		    
		    //Validate First Name
		    WebElement UPDFirstName=driver.findElement(By.xpath(obj.getProperty("UPDFirstName")));
		    Assert.assertTrue(UPDFirstName.isDisplayed(), "First Name textbox should available");
			Assert.assertFalse(UPDFirstName.isEnabled(),"First Name textbox should be disabled");	
			Assert.assertTrue(UPDFirstName.getAttribute("value").equals(UserfnNamecellvalue), "Valid First Name should be displayed");
			HighLight(driver,UPDFirstName);
			
			//Validate Last Name
			WebElement UPDLastName=driver.findElement(By.xpath(obj.getProperty("UPDLastName")));
		    Assert.assertTrue(UPDLastName.isDisplayed(), "Last Name textbox should available");
			Assert.assertFalse(UPDLastName.isEnabled(),"Last Name textbox should be disabled");	
			Assert.assertTrue(UPDLastName.getAttribute("value").equals(UserlnNamecellvalue), "Valid Last Name should be displayed");
			HighLight(driver,UPDLastName);
			
			//Validate Phone  NUmber
			WebElement UPDPhoneNo=driver.findElement(By.xpath(obj.getProperty("UPDPhoneNo")));
		    Assert.assertTrue(UPDPhoneNo.isDisplayed(), "Phone Number textbox should available");
			Assert.assertFalse(UPDPhoneNo.isEnabled(),"Phone Number textboxshould be disabled");	
		//	Assert.assertTrue(UPDPhoneNo.getAttribute("value").equals(Userphnocellvalue), "Valid Phone Number should be displayed"); 
			HighLight(driver,UPDPhoneNo);
			
			//Validate Email  
			WebElement UPDEmail=driver.findElement(By.xpath(obj.getProperty("UPDEmail")));
		    Assert.assertTrue(UPDEmail.isDisplayed(), "Email textbox should available");
			Assert.assertFalse(UPDEmail.isEnabled(),"Emailtestbox should be disabled");	
			Assert.assertTrue(UPDEmail.getAttribute("value").equals(Useremailcellvalue), "Valid Email should be displayed");
			HighLight(driver,UPDEmail);
			
			//Validate Save Button  
			WebElement UPDSave=driver.findElement(By.xpath(obj.getProperty("UPDSave")));
		    Assert.assertTrue(UPDSave.isDisplayed(), "Save Changes button  should available");
			Assert.assertFalse(UPDSave.isEnabled(),"Save Changesbutton should be disabled");	
			Assert.assertTrue(UPDSave.getAttribute("value").equals("Save Changes"), "Button should have text Save Changes");
			HighLight(driver,UPDSave);
			
			//Click on edit button
			UEditButton1.click();
			Assert.assertTrue(UPDFirstName.isEnabled(), "First Name textbox should be enable");
			HighLight(driver,UPDFirstName);
			Assert.assertTrue(UPDLastName.isEnabled(), "Last Name textbox should be enable");
			HighLight(driver,UPDLastName);
			Assert.assertTrue(UPDPhoneNo.isEnabled(), "Phone Number textbox should be enable");
			HighLight(driver,UPDPhoneNo);
		} 
  }

  @AfterTest
  public void afterTest() {
  }

}
