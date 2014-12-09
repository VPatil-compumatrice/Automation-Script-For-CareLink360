package com.carelink360Package;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class StartUp
{
	public static WebDriver driver;
	public static FileInputStream objfile=null,excelfile=null, propertyfile=null;
	public static FileOutputStream excelfile1=null;
	public static Properties obj=null;
	public static  Actions action;
	public static WebDriverWait wait; 
	public static Workbook wb;
	public static Sheet SignUpmanualorg=null,Login=null,AddUser=null,ValidUser=null,AddNewrecipient=null;
	static String cellvalue;
	  
	public static void start(String url) throws IOException, InvalidFormatException, InterruptedException
    {
    	//instance of chrome driver
    	 File file = new File("E:/selenium/Carelink360/selenium-jar/chromedriverwin32/chromedriver.exe");
         System.setProperty("webdriver.chrome.driver", file.getAbsolutePath() );
         driver= new ChromeDriver();
         Thread.sleep(3000);
         //instance of firefox driver
    	//driver= new FirefoxDriver();
         
         driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS); //implicit wait
    	 driver.manage().window().maximize(); //to maximize window
    	 
    	 driver.get(url); //sent URL to browser
    	 
    	 wait = new WebDriverWait(driver, 300); //created instance of WebDriverwait
    	 
 	     action=new Actions(driver); //created instance of Action class
 	     
 	     obj = new Properties();    //Created instance for Property File
 	     
 	     objfile = new FileInputStream("E:\\selenium\\Carelink360\\configFileforObjects\\AdminSignUp_Locators.properties"); //intialize instance of property file
 	     obj.load(objfile); //loaded property file
 	     
 	     excelfile=new FileInputStream("E:\\selenium\\Carelink360\\configFileforObjects\\Automation1.xlsx"); //Initialze instance of excel file
 	     
 	     wb=WorkbookFactory.create(excelfile); //created instance of WorkBookFactory
      
 	     //Required sheets from excel file
         SignUpmanualorg=wb.getSheet("SignUpmanualorg");
         Login= wb.getSheet("Login");
         AddUser=wb.getSheet("AddUser");
         ValidUser=wb.getSheet("ValidUser");
         AddNewrecipient=wb.getSheet("AddNewRecipient");
      }
      public void quit()
      {
   	     //Logout=driver.findElement(By.xpath(obj.getProperty("logout")));
   	     // Logout.click();
   	     driver.quit();
      }
      public static void login() throws InterruptedException
      {
    	  driver.get("https://cm-dev5.cloudapp.net/#/");
    	 
    	  WebElement Username=driver.findElement(By.xpath(obj.getProperty("Admin_EmailAddress"))); //username field
    	  WebElement AdPass=driver.findElement(By.xpath(obj.getProperty("Admin_Password"))); //password field
    	  
 	      int rowct=Login.getLastRowNum(); //Last Row Number from Login sheet
 	      int j=0;
 	      
 	      Username.sendKeys(Login.getRow(rowct).getCell(j).getStringCellValue());	//sending data from excel in Username 
 	      AdPass.sendKeys(Login.getRow(rowct).getCell(j+1).getStringCellValue());  //sending data from excel in Password
 	      Thread.sleep(3000);
 	      
 	       WebElement SignIn=driver.findElement(By.xpath(obj.getProperty("SignInButton")));
 	       SignIn.click();     //Clicking on  SignIn button
 	       Thread.sleep(4000);
 	        //Printing username ,password and organization name from excel sheet in console  
 	       System.out.println(Login.getRow(rowct).getCell(j).getStringCellValue());
 	       System.out.println(Login.getRow(rowct).getCell(j+1).getStringCellValue());
 	       System.out.println(Login.getRow(rowct).getCell(j+2).getStringCellValue());
 	       //try catch block for selecting organization
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
       }
      //Code for highlighting webelements
      public static  void HighLight (WebDriver driver, WebElement element) throws InterruptedException
      { 
   	    ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style',arguments[1]);",element,"border: 5px solid red;");
   	    Thread.sleep(2000);
   	    ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1]);",element,"");
      } 
    
    
    //method to check cell value from excel is numeric,characters or blank
	public static String excelvalidation(Cell cell) throws InvalidFormatException, IOException
	{
	   
		switch (cell.getCellType())
        {

		         case Cell.CELL_TYPE_NUMERIC:
                            int x=(int)cell.getNumericCellValue();
                            cellvalue=Integer.toString(x);
                	        
                            break;
                 case Cell.CELL_TYPE_STRING:
                             cellvalue=cell.getStringCellValue();
                              
	             case Cell.CELL_TYPE_BLANK:
                           
                             cellvalue = cell.getStringCellValue();
                             break;   

                 default:
        }
	    return cellvalue; 
	  } 
	//method for gmail activation link
	
    public static void gmailactivatelink(String username,String lettersId) throws InterruptedException
    {
	   
	     driver.get("https://www.gmail.com"); //sending gmail url to browser
	     
	     driver.findElement(By.id("Email")).sendKeys(username); //sending emailaddress to username field
	     //scanner class to take password from console
	     Scanner scn = new Scanner(System.in);
	     System.out.println("enter password");
	     String password=scn.next();
	     
	    driver.findElement(By.id("Passwd")).sendKeys(password); //sending password to password field
		driver.findElement(By.id("signIn")).click(); //click on SignIn
		
		driver.manage().window().maximize();
		System.out.println("login suceessfull");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@title='Sent Mail']"))); //wait utill Sent Mail not visible
		Thread.sleep(10000);
		//Search mail
		String clickSearch=".//*[@id='gbqfb']";
		driver.findElement(By.xpath(clickSearch)).click();
		String searchvalue="//form[@id='gbqf']/fieldset[2]/div/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/div/input[1]";
		driver.findElement(By.xpath(searchvalue)).sendKeys(lettersId);
		driver.findElement(By.xpath(clickSearch)).click();
	    Thread.sleep(10000);
	    
	    //click on first mail
		WebElement firstmail=driver.findElement(By.xpath(".//div[@class='ae4 UI UJ']//tr[1]"));
		firstmail.click();
		Thread.sleep(5000);
		
		//click on link from mail
		driver.findElement(By.xpath(".//div[@class='nH']//a[contains(text(),'https://cm-dev5')]")).click();
	  
     }
     public static void compumatriceactivatelink(String username,String lettersId) throws InterruptedException
     {
	  
	   driver.get("https://outlook.office365.com");  //sending gmail url to browser
	   driver.findElement(By.xpath("id('cred_userid_inputtext')")).sendKeys(username);//sending emailaddress to username field
	   
	   //scanner class to take password from console
	   Scanner scn= new Scanner(System.in); 
	   System.out.println("Enter password: ");
	   String password=scn.next();
	   
	  WebElement pass=driver.findElement(By.xpath("//input[@id='cred_password_inputtext']"));
	  pass.sendKeys(password);//sending password to password filed
	  Thread.sleep(4000);
	  //Clicking on SignIn button
	  driver.findElement(By.id("cred_sign_in_button")).click();
	  Thread.sleep(4000);
	  driver.findElement(By.id("cred_sign_in_button")).click();
	  Thread.sleep(4000);
	  //List for number of mails
      List <WebElement> count1 = driver.findElements(By.xpath("//div[@autoid='_lv_i']/div[contains(@id,'_ariaId')]"));
      System.out.println("Number of mails from outlook:"+ count1.size());
	   Thread.sleep(4000);
	   //For seraching mail 
	   WebElement clickevent=driver.findElement(By.xpath("//div[@class='_n_x2']"));
	   clickevent.click();
	   Thread.sleep(2000);
	   WebElement inputstr=driver.findElement(By.xpath("//div[@class='_n_x2']/div/div/form/div/input"));
	   inputstr.sendKeys(" "+lettersId);
	   Thread.sleep(10000);
	   WebElement search=driver.findElement(By.xpath("//div[@class='_n_x2']/div/div/button[@class='_n_A searchImgWidth o365button']"));
	   search.click();
	   Thread.sleep(10000);
	  /*WebElement firstmail=driver.findElement(By.xpath("//div[@class='_lv_21 scrollContainer']/div/div/div[1]/div[2]"));
	   action.moveToElement(firstmail);
	   WebElement chkbox=driver.findElement(By.xpath("//div[@class='_lv_21 scrollContainer']/div/div/div[1]/div[2]/div/button/span[1]"));
	   action.moveToElement(chkbox);
	   Thread.sleep(3000);
	   chkbox.click();*/
	   
	   //List for number mails after search
	   List <WebElement> count2 = driver.findElements(By.xpath("//div[@autoid='_lv_i']/div[contains(@id,'_ariaId')]"));
	   System.out.println("Number of mails after search:"+ count2.size());
	   Thread.sleep(9000);
	   //click on activation link
	   driver.findElement(By.xpath("//a[contains(.,'https://cm-dev5')]")).click();
	}
}
