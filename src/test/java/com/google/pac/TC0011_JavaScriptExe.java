package com.google.pac;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC0011_JavaScriptExe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		WebElement ele=driver.findElement(By.name("q"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		ele.sendKeys("Selenium Latest Version");
		WebElement ele1=driver.findElement(By.name("btnK"));
		js.executeScript("arguments[0].click()", ele1);
		
	}

}
