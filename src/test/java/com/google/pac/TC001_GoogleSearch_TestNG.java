package com.google.pac;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TC001_GoogleSearch_TestNG {
	WebDriver driver;
	@BeforeMethod
	public void launch()
	{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	}
	@AfterMethod
	public void quitbrowser()
	{
		driver.quit();
	}
	@Test
	public void googlesearch() throws InterruptedException
	{
	driver.manage().window().maximize();
	driver.get("https://www.google.com/");
	WebElement ele=driver.findElement(By.name("q"));
	Assert.assertEquals(true, ele.isDisplayed());
	ele.sendKeys("Selenium Latest Version");
	ele.clear();
	ele.sendKeys("Automation Testing");
	ele.submit();
	System.out.println("The Title is:"+driver.getTitle());
	Assert.assertEquals("Automation Testing - Google Search", driver.getTitle());
	driver.navigate().to("https://www.yahoo.com/");
	System.out.println("The URL is:"+driver.getCurrentUrl());
	System.out.println("The Title is:"+driver.getTitle());
	//System.out.println("Page Source:"+driver.getPageSource());
	driver.navigate().refresh();
	Thread.sleep(3000);
	driver.navigate().back();
	Thread.sleep(3000);
	System.out.println("The Title after back:"+driver.getTitle());
	Thread.sleep(3000);
	driver.navigate().forward();
	System.out.println("The Title after forward:"+driver.getTitle());
	
	
	//driver.quit();
	
	
	
	
	
		
	}

}
