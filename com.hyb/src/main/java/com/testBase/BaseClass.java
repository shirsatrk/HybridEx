package com.testBase;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.PropertiesUtility;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;



public class BaseClass {
	public WebDriver driver;
	PropertiesUtility prop;
	ExtentSparkReporter spark;
	ExtentReports report;
	
		
	public void initialization(String browser) {
		prop = new PropertiesUtility();
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.readProperties("chromeDriverPath"));
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.readProperties("geckoDriverPath"));
			driver = new FirefoxDriver();
		}
		
		/*
		
		if (prop.readProperties("browser") .equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.readProperties("chromeDriverPath"));
			driver = new ChromeDriver();
		}
		if (prop.readProperties("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.readProperties("chromeDriverPath"));
			driver = new FirefoxDriver();
		}
		if (prop.readProperties("browser").equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", prop.readProperties("chromeDriverPath"));
			driver = new InternetExplorerDriver();
		}
		if (prop.readProperties("browser").equalsIgnoreCase("html")) {
			driver = new HtmlUnitDriver();
		}*/
	}
	
	public void reportInit() {
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
		report = new ExtentReports();
		report.setSystemInfo("Host Name", "Roha-RKS");
		report.setSystemInfo("Platform", "Window");
		report.setSystemInfo("Environment", "Test Automation");
		report.attachReporter(spark);
		}
	
	public String takeScreenShot(String name) {
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ("user.dir")+"Screenshot"+name+".jpg";
		try {
			FileUtils.copyDirectory(src, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}return path;
		}
	
}
