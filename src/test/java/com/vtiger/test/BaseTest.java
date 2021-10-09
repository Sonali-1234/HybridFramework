package com.vtiger.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest {
	
public static WebDriver driver;
public static ExtentHtmlReporter htmlReporter;
public static ExtentReports extent;
public static ExtentTest logger;
	


	@BeforeSuite
	public void launchApp()
	{
		createExtentReport();		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Selenium_Software/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:100");        
        driver.manage().window().maximize();
	}
	
	
	public void createExtentReport()
	{
		DateFormat fmat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		Date d = new Date();
		String str = fmat.format(d);
		System.out.println(str);
		String ReportPath = System.getProperty("user.dir")+"/src/test/java/com/vtiger/report/";
		String ReportName = "vTigerAutomationResult_"+str+".html";
		htmlReporter = new ExtentHtmlReporter(ReportPath+ReportName);
    	// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test Hub");
		    	extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Rajesh U");
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
		            // Name of the report
		htmlReporter.config().setReportName("Name of the Report Comes here "); 
		            // Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD); 
	}
	
	@AfterSuite
	public void closeApp()
	{
		driver.quit();
	}

}
