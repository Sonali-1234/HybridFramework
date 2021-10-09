package com.vtiger.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

public class E2E extends BaseTest {
	
	
	@Test
	public void CreateLeadswithMandatoryData_TC02()
	{
		logger=extent.createTest("CreateLeadswithMandatoryData_TC02");
		LoginPage lp = new LoginPage(driver,logger);
		lp.Login("admin", "admin");
		LeadPage ldp = new LeadPage(driver,logger);
		ldp.clickNewLead();
		ldp.createLeadwithMandatoryFields("Modi", "BJP");
		ldp.clickLogout();
		extent.flush();				
	}
	
	

}
