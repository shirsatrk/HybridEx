package com.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.util.ArrayList;
import java.util.List;
import com.testBase.BaseClass;
import com.utility.ActionUtility;
import com.utility.PropertiesUtility;

public class test1 extends BaseClass {
	PropertiesUtility pu;
	ActionUtility au;
	ArrayList<String> actcourse;
	ArrayList<String> expcourse;

	
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) {
		initialization(browser);
		reportInit();
	}

	@Test
	public void firstTest() {
		pu = new PropertiesUtility();
		au = new ActionUtility();

		driver.get(pu.readProperties("url"));
		// WebElement w = driver.findElement(By.id("email"));
		// WebElement useridLoc = au.getElement("xpath","//input[@id='email']");
		au.typeIn(au.getElement(driver, "xpath", "//input[@id='email']"), pu.readProperties("username"));

		WebElement passwordLoc = au.getElement(driver, "id", "password");
		au.typeIn(passwordLoc, pu.readProperties("password"));

		WebElement ButtonLoc = au.getElement(driver, "xpath", "//button");
		au.click(ButtonLoc);
		actcourse = new ArrayList<String>();
		List<WebElement> list = driver.findElements(By.xpath("//h3"));
		for (WebElement course : list) {
			String text = course.getText();
			actcourse.add(text);
		}
		expcourse = new ArrayList<String>();
		expcourse.add("Selenium");
		expcourse.add("Java / J2EE");
		expcourse.add("Python");
		expcourse.add("Php");

		AssertJUnit.assertEquals(actcourse, expcourse);
	}
	
	
	@Test
	public void SecondTest() {
		pu = new PropertiesUtility();
		au = new ActionUtility();

		driver.get(pu.readProperties("url"));
		// WebElement w = driver.findElement(By.id("email"));
		// WebElement useridLoc = au.getElement("xpath","//input[@id='email']");
		au.typeIn(au.getElement(driver, "xpath", "//input[@id='email']"), pu.readProperties("username"));

		WebElement passwordLoc = au.getElement(driver, "id", "password");
		au.typeIn(passwordLoc, pu.readProperties("password"));

		WebElement ButtonLoc = au.getElement(driver, "xpath", "//button");
		au.click(ButtonLoc);
		AssertJUnit.assertEquals(driver.findElement(By.xpath("//b[text()='Java By Kiran']")).getText(), "Java By Kiran");
	}
}