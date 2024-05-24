package com.google.pac;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004_Alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/alert");
		driver.findElement(By.id("accept")).click();
		Alert al=driver.switchTo().alert();
		System.out.println("Alert Message:"+al.getText());
		al.accept();
		driver.findElement(By.id("confirm")).click();
		Alert al1=driver.switchTo().alert();
		System.out.println("Alert Message:"+al1.getText());
		al1.dismiss();
		
		driver.findElement(By.id("prompt")).click();
		Alert al2=driver.switchTo().alert();
		al2.sendKeys("Hello");
		System.out.println("Alert Message:"+al2.getText());
		al2.accept();
		
		
		
		
		
		
		
		
	}

}
