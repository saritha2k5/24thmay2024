package com.google.pac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC0012_Mousehover {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.linkText("All")).click();
		Thread.sleep(2000);
		
		WebElement ele=driver.findElement(By.linkText("New Releases"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(2000);
		ele.click();
		
		
				
		
	}

}
