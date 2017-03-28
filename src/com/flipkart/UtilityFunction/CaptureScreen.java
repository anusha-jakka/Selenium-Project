package com.flipkart.UtilityFunction;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreen
{
public static void CaptureScreenShot(WebDriver driver,String ScrenshotName) throws IOException
{
	
	try
	{
	File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("E:\\Anusha Selenium\\Selenium Practice\\Screenshots\\"+ScrenshotName+".jpeg"));
	}
	catch (Exception e) 
	{
	System.out.println("Screenshot not taken");
	}
}
}
