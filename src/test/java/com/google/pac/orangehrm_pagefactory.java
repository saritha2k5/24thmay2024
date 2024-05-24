package com.google.pac;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class orangehrm_pagefactory {
	//WebDriver driver;
	//By ohrmusername=By.name("username");
	@FindBy(name="username")
	WebElement ohrmusername;
	//By ohrmpassword=By.name("password");
	@FindBy(name="password")
	WebElement ohrmpassword;
	//By ohrmsubmit=By.xpath("//button[@type='submit']");
	@FindBy(xpath="//button[@type='submit']")
	WebElement ohrmsubmit;
	//By ohrmsearch=By.xpath("//input[@placeholder='Search']");
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement ohrmsearch;
	public void enterusername(String uname)
	{
		ohrmusername.sendKeys(uname);
	}
	
	public void enterpassword(String pword)
	{
		ohrmpassword.sendKeys(pword);
	}
	
	public void clicksubmit()
	{
		ohrmsubmit.click();
	}
	
	public boolean searchdisplay()
	{
		Boolean search=ohrmsearch.isDisplayed();
		return search;
	}

}
