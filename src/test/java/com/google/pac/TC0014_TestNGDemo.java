package com.google.pac;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC0014_TestNGDemo {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  System.out.println("Value of n:"+n);
	  System.out.println("Value of s:"+s);
	 Assert.assertEquals(n, 1);
	 Assert.assertEquals(s, "a");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
	  
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class");
  }

  @AfterClass
  public void afterClass() {
	  
	  System.out.println("After Class");
  }

  @BeforeTest
  public void beforeTest() {
	  
	  System.out.println("Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  
	  System.out.println("Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  
	  System.out.println("After Suite");
  }

}
