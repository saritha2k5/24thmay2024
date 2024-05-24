package com.google.pac;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
public class NewTest {
  @Test(dataProvider = "dp")
  public void f(String uname, String pword) {
	  System.out.println("This is the Test");
	 System.out.println("a value is:"+uname); 
	 System.out.println("b value is:"+pword);
	 
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver = new ChromeDriver();
	 driver.get("https://demo.opencart.com/");
	 driver.findElement(By.linkText("My Account")).click();
	 
	 driver.findElement(By.linkText("Login")).click();
	 driver.findElement(By.id("input-email")).sendKeys(uname);
	 driver.findElement(By.id("input-password")).sendKeys(pword);
	 driver.findElement(By.xpath("//button[@type='submit']")).click();
	 
	
	
	 
	 
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println("Before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
  }


  @DataProvider
  public Object[][] dp() throws IOException {
	  
	  XSSFWorkbook wbook=new XSSFWorkbook("C:\\Saritha\\Saritha\\Batch1\\Aug16thSelenium\\opencart.xlsx");
	  XSSFSheet sheet=wbook.getSheetAt(0);
	  int rowcount=sheet.getLastRowNum();
	 
	  String username=sheet.getRow(0).getCell(0).getStringCellValue();
	  String password=sheet.getRow(0).getCell(1).getStringCellValue();
	  
    return new Object[][] {
     	
      new Object[] { username, password }
    }    
      
      
    
    
  }
  @BeforeClass
  public void beforeClass() {
	  
	  System.out.println("Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test");
  }

  @AfterTest
  public void afterTest() {

	  System.out.println("After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  
	  System.out.println("After Suite");
  }

}
