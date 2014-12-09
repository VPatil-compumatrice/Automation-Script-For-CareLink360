package com.carelink360Package1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class CompumatriceActivation extends com.carelink360Package.StartUp
{
  
  @BeforeTest
  public void beforeTest() throws InvalidFormatException, IOException, InterruptedException
  {
	  start("https://outlook.office365.com");
  }
  @Test
  public void CompumatriceActivationmethod(String username,String lettersId) throws InterruptedException 
  {
	/*  File file = new File("E://selenium-jar/chromedriverwin32/chromedriver.exe");
      System.setProperty("webdriver.chrome.driver", file.getAbsolutePath() );
      WebDriver driver= new ChromeDriver();
	  WebDriverWait wait = new WebDriverWait(driver, 300);
	  driver.get("https://outlook.office365.com");*/
	   Scanner scn= new Scanner(System.in); 
	  driver.findElement(By.xpath("id('cred_userid_inputtext')")).sendKeys(username);
	  Thread.sleep(4000);
	  System.out.println("Enter password: ");
	  String password=scn.next();
	  WebElement pass=driver.findElement(By.xpath("//input[@id='cred_password_inputtext']"));
	  pass.sendKeys(password);
	  Thread.sleep(4000);
	  driver.findElement(By.id("cred_sign_in_button")).click();
	  Thread.sleep(4000);
	  driver.findElement(By.id("cred_sign_in_button")).click();
	  Thread.sleep(4000);
     List <WebElement> count1 = driver.findElements(By.xpath("//div[@autoid='_lv_i']/div[contains(@id,'_ariaId')]"));
     System.out.println("Number of mails from outlook:"+ count1.size());
	  
	
	  Thread.sleep(4000);
	  WebElement clickevent=driver.findElement(By.xpath("//div[@class='_n_x2']"));
	   clickevent.click();
	   Thread.sleep(2000);
	  WebElement inputstr=driver.findElement(By.xpath("//div[@class='_n_x2']/div/div/form/div/input"));
	  inputstr.sendKeys(" "+lettersId);
	  Thread.sleep(2000);
	  
	  WebElement search=driver.findElement(By.xpath("//div[@class='_n_x2']/div/div/button[@class='_n_A searchImgWidth o365button']"));
	   search.click();
	   Thread.sleep(4000);
	   List <WebElement> count2 = driver.findElements(By.xpath("//div[@autoid='_lv_i']/div[contains(@id,'_ariaId')]"));
		  System.out.println("Number of mails after search:"+ count2.size());
		 driver.findElement(By.xpath("//a[contains(.,'https://admindev')]")).click();
  }

 // @AfterTest
  public void afterTest()
  {
	  driver.close();
  }

}
