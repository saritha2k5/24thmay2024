package com.google.pac;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class TC0018_DataDriven_xml {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void login(String username, String password) {
	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	 driver.findElement(By.name("username")).sendKeys(username);
	 driver.findElement(By.name("password")).sendKeys(password);
	 driver.findElement(By.xpath("//button[@type='submit']")).click();
	 Boolean searchdispalyed=driver.findElement(By.xpath("//input[@placeholder='Search']")).isDisplayed();
	 Assert.assertEquals(searchdispalyed, true);
	 if (searchdispalyed.equals(true))
	 {
		 System.out.println("Login Successfull");
	 }
	 else
	 {
		 System.out.println("Login unsuccessfull");
	 }
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
  public String[][] dp() throws IOException, ParserConfigurationException, SAXException {
	  String[][] data=new String[1][2];

	/*  File file1=new File("C:\\Saritha\\Saritha\\Batch1\\Aug16thSelenium\\inputdata.xlsx");
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
	  */   
	  
	  File xmlfile=new File("C:\\Saritha\\Saritha\\Batch1\\Aug16thSelenium\\logindata.xml");
	  DocumentBuilderFactory dbfactory=DocumentBuilderFactory.newInstance();
	  DocumentBuilder dbbuilder=dbfactory.newDocumentBuilder();
	  Document doc=dbbuilder.parse(xmlfile);
	  NodeList n1=doc.getChildNodes();
	  Node n=n1.item(0);
	  Element ele=(Element)n;
	  data[0][0]=ele.getElementsByTagName("username").item(0).getTextContent();
	  data[0][1]=ele.getElementsByTagName("password").item(0).getTextContent();
	  
	  
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
