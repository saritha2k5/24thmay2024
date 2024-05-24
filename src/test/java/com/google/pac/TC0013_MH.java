package com.google.pac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC0013_MH {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
				Thread.sleep(10000);
		WebElement ele=driver.findElement(By.xpath("//span[text()='Electronics']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		WebElement ele1=driver.findElement(By.linkText("Cameras & Accessories"));
		Actions act1=new Actions(driver);
		act1.moveToElement(ele1).perform();
		driver.findElement(By.linkText("Drone")).click();
		
		
		
		
	}

}
