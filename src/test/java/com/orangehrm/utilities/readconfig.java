package com.orangehrm.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class readconfig {
	Properties prob;
	public void readconfig() throws IOException
	{
		try
		{
		InputStream input=new FileInputStream("C:\\Saritha\\Saritha\\Batch1\\Aug16thSelenium\\configuration\\ohrmdata.properties");
		  prob=new Properties();
		  prob.load(input);
		}
		catch(Exception e)
		{
			System.out.println("August 25th Exception is:"+e.getMessage());
		}
	}
	
	public String getohrmurl()
	{
		String ohrmurl=prob.getProperty("ohrmurl");
		System.out.println("url is:"+ohrmurl);
		return ohrmurl;
	}
	
	
	public String getexcelpath()
	{
		String excelpath=prob.getProperty("inputdata");
		System.out.println("input data path:"+excelpath);
		return excelpath;
	}
	

}
