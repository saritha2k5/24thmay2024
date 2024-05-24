package com.google.pac;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class TC001_GoogleSearch {
	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.com/");
	WebElement ele=driver.findElement(By.name("q"));
	
	ele.sendKeys("Selenium Latest Version");
	ele.clear();
	ele.sendKeys("Automation Testing");
	ele.submit();
	System.out.println("The Title is:"+driver.getTitle());
	driver.navigate().to("https://www.yahoo.com/");
	System.out.println("The URL is:"+driver.getCurrentUrl());
	System.out.println("The Title is:"+driver.getTitle());
	System.out.println("Page Source:"+driver.getPageSource());
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
