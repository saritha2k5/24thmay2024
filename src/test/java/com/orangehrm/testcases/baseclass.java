package com.orangehrm.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.orangehrm.utilities.readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {
	public static WebDriver driver;
	readconfig rd=new readconfig();
	
	public String inputdata=rd.getexcelpath();
	public String ohrmurl=rd.getohrmurl();
@Parameters("browser")	
@BeforeClass
	public void setup(String br)
{	
	if(br.equals("chrome"))
	{
	WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	else if(br.equals("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		  driver=new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	else if(br.equals("edge"))
	{
		WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
}

@AfterClass
public void teardown()
{
	driver.quit();
}
	
	
}
