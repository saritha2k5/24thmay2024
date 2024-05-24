package com.google.pac;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005_Windowhandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/windows");
		System.out.println("Firstwindow:"+driver.getWindowHandle());
		driver.findElement(By.id("home")).click();
		System.out.println("window after click on home:"+driver.getWindowHandle());
		
		
		List<String> l1=new ArrayList<String>(driver.getWindowHandles());
		
		System.out.println(l1.size());
		
		driver.switchTo().window(l1.get(1));
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(l1.get(0));
		
		System.out.println(driver.getCurrentUrl());
		
		

	}

}
