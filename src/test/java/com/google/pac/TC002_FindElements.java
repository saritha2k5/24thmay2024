package com.google.pac;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_FindElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/");
		System.out.println(driver.findElement(By.linkText("My Account")).getText());
		driver.findElement(By.linkText("My Account")).click();
		System.out.println(driver.findElement(By.linkText("Register")).getAttribute("href"));
		driver.findElement(By.linkText("Register")).click();
		
		List<WebElement> l1=driver.findElements(By.cssSelector("input.form-control"));
		
		for(WebElement wl: l1)
		{
			System.out.println(wl.getAttribute("name"));
		}
		
			
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(10000);
		
		
		System.out.println("Yes radio button is diaplayed:"+driver.findElement(By.id("input-newsletter-yes")).isDisplayed());
		driver.findElement(By.id("input-newsletter-yes")).click();
		
		System.out.println(driver.findElement(By.id("input-newsletter-yes")).isSelected());
		System.out.println(driver.findElement(By.id("input-newsletter-no")).isSelected());
		driver.findElement(By.name("agree")).click();
		
		
		
		
	}

}
