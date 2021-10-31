package com.testCases;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testBase.BaseClass;

public class Test2 extends BaseClass {
	@Parameters("browser")
	@BeforeTest 
	public void setup(String browser) {
		initialization(browser);
		
	}
	
	
	@Test (description = "Login", priority = 0, enabled = true,groups = "Rohan", dependsOnGroups = "Ramesh" )
	public void loginTest() {
		driver.get("file:///D:/Rohan/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html#");
		
		AssertJUnit.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}
	
	@Test (description = "Dash", priority = 0,groups = "Rohan" ,dependsOnMethods = "loginTest")
	public void Dashboard() {
		driver.get("file:///D:/Rohan/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html#");
		
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
			
		AssertJUnit.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard1");
		
		
	}
	
	@Test (description = "list",groups = "Ramesh", priority = 0)
	public void listOfCourses() {
		driver.get("file:///D:/Rohan/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html#");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		java.util.List<WebElement> li = driver.findElements(By.xpath("//h3"));
		ArrayList<String> al = new ArrayList<String>();
		for (WebElement course : li) {
			String courses = course.getText();
			al.add(courses);
		}
		ArrayList<String> al1 = new ArrayList<String>();
		al1.add("Selenium");
		al1.add("Java / J2EE");
		al1.add("Python");
		al1.add("Php");
		
		
		AssertJUnit.assertEquals(al1, al);
		
		
	}
	
	@Test (description = "User",groups = "Ramesh", priority = 0)
	public void DashboardUserText() {
		driver.get("file:///D:/Rohan/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html#");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
			/*try {
				Thread.sleep(000);
			} catch (InterruptedException e) {
				System.out.println("failessss");
				e.printStackTrace();
			}*/
		AssertJUnit.assertEquals(driver.findElement(By.xpath("//small")).getText(), "Courses Offered");
		
		
		
	}

}
