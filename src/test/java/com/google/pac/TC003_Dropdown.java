package com.google.pac;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_Dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/");
		driver.findElement(By.linkText("Desktops")).click();
		driver.findElement(By.linkText("Mac (1)")).click();
		driver.findElement(By.id("input-sort")).click();
		Select sort1=new Select(driver.findElement(By.id("input-sort")));
		List<WebElement> alloptions=sort1.getOptions();
		
		for(int i=0;i<=alloptions.size();i++)
			
		{
			System.out.println(alloptions.get(i).getText());
			
		}
		
		//sort1.selectByIndex(5);
		sort1.selectByVisibleText("Name (Z - A)");
		
		
	}

}
