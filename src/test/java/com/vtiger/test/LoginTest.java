package com.vtiger.test;


import org.testng.Assert;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vtiger.pages.HeaderPage;
import com.vtiger.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	
	@Test
	public void VerifyValidLogin_TC01()
	{
		logger=extent.createTest("VerifyValidLogin_TC01");
		LoginPage lp = new LoginPage(driver,logger);
		lp.Login("admin", "admin");		
		HeaderPage hp = new HeaderPage(driver);
		boolean val = hp.verifylogout();
		Assert.assertEquals(val, true);		
		hp.clickLogout();
		extent.flush();
	}
	
	@Test
	public void VerifyInValidLogin_TC02()
	{
		logger=extent.createTest("VerifyInValidLogin_TC02");
		LoginPage lp = new LoginPage(driver,logger);
		lp.Login("admin1", "admin1");		
		boolean val = lp.validateErrorMsg();		
		Assert.assertEquals(val, true);	
		extent.flush();
	}
	
	@Test
	public void VerifyLogo_TC03()
	{
		logger=extent.createTest("VerifyLogo_TC03");
		LoginPage lp = new LoginPage(driver,logger);	
		boolean val = lp.validateLogo();
		Assert.assertEquals(val, true);			
		extent.flush();
	}
	
	
	

}
