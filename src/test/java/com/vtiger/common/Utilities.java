package com.vtiger.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class Utilities {
	
	private WebDriver driver;
	private ExtentTest logger;
	
	public Utilities(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
	}
	
	
	public void setInputText(WebElement elm, String val,String elmName)
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.clear();
		elm.sendKeys(val);
		logger.pass(val+" has been entered successfully in "+elmName);
		}
		catch(Exception e)
		{
		logger.fail(e.getMessage());	
		}
	}
	
	
	public void ClickElement(WebElement elm,String elmName)
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(elm));		
		elm.click();
		logger.pass(elmName+" has been clicked");
		}
		catch(Exception e)
		{
		logger.fail(e.getMessage());	
		}
	}
	
	public boolean IsElementDisplay(WebElement elm,String elmName)
	{
		boolean val = false;
		try
		{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(elm));		
		val=elm.isDisplayed();
		logger.pass(elmName+" has been displayed");
		return val;
		}
		catch(Exception e)
		{
		logger.fail(e.getMessage());
		return val;
		}
		
		
	}
	
	

}
