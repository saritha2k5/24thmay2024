package com.google.pac;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class orangehrm_pageobjects {
	WebDriver driver;
	By ohrmusername=By.name("username");
	By ohrmpassword=By.name("password");
	By ohrmsubmit=By.xpath("//button[@type='submit']");
	By ohrmsearch=By.xpath("//input[@placeholder='Search']");
	public orangehrm_pageobjects(WebDriver driver2) {
		
		this.driver=driver2;
		// TODO Auto-generated constructor stub
	}

	public void enterusername(String uname)
	{
		driver.findElement(ohrmusername).sendKeys(uname);
	}
	
	public void enterpassword(String pword)
	{
		driver.findElement(ohrmpassword).sendKeys(pword);
	}
	
	public void clicksubmit()
	{
		driver.findElement(ohrmsubmit).click();
	}
	
	public boolean searchdisplay()
	{
		Boolean search=driver.findElement(ohrmsearch).isDisplayed();
		return search;
	}

}
