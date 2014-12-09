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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GmailActivation extends com.carelink360Package1.CompumatriceActivation
{
 
	@BeforeTest
	  public void beforeTest() throws InvalidFormatException, IOException, InterruptedException
	  {
		start("https://www.gmail.com");
	  }
	@Test
  public void GamilActivationmethod(String username,String lettersId) throws InterruptedException, InvalidFormatException, IOException 
  {
	/*  File file = new File("E://selenium-jar/chromedriverwin32/chromedriver.exe");
      System.setProperty("webdriver.chrome.driver", file.getAbsolutePath() );
      WebDriver driver= new ChromeDriver();
	  WebDriverWait wait = new WebDriverWait(driver, 300);
	  driver.get("https://www.gmail.com");*/
		start("https://www.gmail.com");
		driver.findElement(By.id("Email")).sendKeys(username);
	  Scanner scn = new Scanner(System.in);
	  System.out.println("enter password");
	  String password=scn.next();
		
		driver.findElement(By.id("Passwd")).sendKeys(password);
		driver.findElement(By.id("signIn")).click();
		driver.manage().window().maximize();
		System.out.println("login suceessfull");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@title='Sent Mail']")));
		Thread.sleep(10000);
		String clickSearch=".//*[@id='gbqfb']";
		driver.findElement(By.xpath(clickSearch)).click();
		String searchvalue="//form[@id='gbqf']/fieldset[2]/div/div/div[2]/table/tbody/tr/td/table/tbody/tr/td/div/input[1]";
		driver.findElement(By.xpath(searchvalue)).sendKeys(lettersId);
		driver.findElement(By.xpath(clickSearch)).click();
		Thread.sleep(10000);
		List<WebElement> mails= driver.findElements(By.xpath(".//div[@class='ae4 UI UJ']//span[contains(text(),'" + lettersId + "')]"));
		 
		  Thread.sleep(15000);
		    for(WebElement e1:mails )
		    {
		    	System.out.println("in form loop of letters");
		    	System.out.println(e1.getText());
		    	e1.click();
		    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='amn']")));
		    	break;
		    }
		
		    driver.findElement(By.xpath(".//div[@class='nH']//a[contains(text(),'https://admindev')]")).click();
		   
  }
	//@AfterTest
	  public void afterTest() 
	{
		driver.close();
	  }
}
