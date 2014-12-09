package com.carelink360Package1;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class demo {
  @Test
  public void f()
  {
	  /*File file = new File("E://selenium-jar/chromedriverwin32/chromedriver.exe");
      System.setProperty("webdriver.chrome.driver", file.getAbsolutePath() );
       WebDriver driver= new ChromeDriver();
   	//driver= new FirefoxDriver();
       driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
   	   driver.manage().window().maximize();
   	   driver.get("https://admindev.carelink360.com/#/");
   	 System.out.println(driver.getTitle());*/
	  String example = "vpvandana76@gmail.com";
	  String example1=example.substring(example.lastIndexOf("+") );
	  String[] result = example.split("\\@");
	
	//System.out.println(example1);
	for(int i=0;i<=result.length;i++)
	{
		  System.out.println(result[i]);
		 
	}
	    
   	  
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
