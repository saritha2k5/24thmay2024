package com.google.pac;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class TC0018_DataDriven_PageFactory {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void login(String username, String password) throws InterruptedException {
	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	 //driver.findElement(By.name("username")).sendKeys(username);
	 //driver.findElement(By.name("password")).sendKeys(password);
	 //driver.findElement(By.xpath("//button[@type='submit']")).click();
	// Boolean searchdispalyed=driver.findElement(By.xpath("//input[@placeholder='Search']")).isDisplayed();
	 ExtentReports extent=new ExtentReports();
	 ExtentSparkReporter spark=new ExtentSparkReporter("./reports/"+"ohrm_report.html");
	 extent.attachReporter(spark);
	 ExtentTest test=extent.createTest("Launch Browser, login orangehrm and verify the home page is displayed");
	  
	 orangehrm_pagefactory obj1=PageFactory.initElements(driver, orangehrm_pagefactory.class);
	  obj1.enterusername(username);
	  obj1.enterpassword(password);
	  obj1.clicksubmit();
	  Thread.sleep(3000);
	  TakesScreenshot ts=(TakesScreenshot)driver;
	   File sourcefile=ts.getScreenshotAs(OutputType.FILE);
	  File destfile=new File("./screenshots1/"+"orangehrm_home.jpg");
	  try
	  {
		FileUtils.copyFile(sourcefile, destfile)  ;
		}catch(Exception e)
	  {
		  e.printStackTrace();
		 }
	  
	  	  
	  
	   Boolean searchdispalyed=obj1.searchdisplay();
	   Assert.assertEquals(searchdispalyed, true);
	 if (searchdispalyed.equals(true))
	 {
		 test.pass("Orange HRM home page is displayed");
		 test.addScreenCaptureFromPath("\\Saritha\\Saritha\\Batch1\\Aug16thSelenium\\screenshots1\\orangehrm_home.jpg");
		 System.out.println("Login Successfull");
	 }
	 else
	 {
		 System.out.println("Login unsuccessfull");
		 test.fail("Orange HRM home page is not displayed");
	 }
	 
	 extent.flush();
		  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  @DataProvider
  public String[][] dp() throws IOException {
	  String[][] data=new String[3][2];

	  File file1=new File("C:\\Saritha\\Saritha\\Batch1\\Aug16thSelenium\\inputdata.xlsx");
	  FileInputStream fis=new FileInputStream(file1);
	  XSSFWorkbook workbook=new XSSFWorkbook(fis);
	  XSSFSheet sheet=workbook.getSheetAt(0);
	  int rowcount=sheet.getPhysicalNumberOfRows();
	  System.out.println("row count:"+rowcount);
	  for(int i=0;i<rowcount;i++)
	  {
		  
		  data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
		  
		  data[i][1]=sheet.getRow(i).getCell(1).getStringCellValue();
	  }
	     
	  
	  return data;
    
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
