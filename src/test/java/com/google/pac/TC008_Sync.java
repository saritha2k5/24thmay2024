package com.google.pac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC008_Sync {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		
		WebElement ele=driver.findElement(By.name("q1"));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
		ele.sendKeys("Selenium Latest Version");
		ele.submit();
		driver.close();

	}

}
