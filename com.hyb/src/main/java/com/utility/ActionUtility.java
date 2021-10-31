package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.testBase.BaseClass;


public class ActionUtility extends BaseClass {
	
	
	public void typeIn(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void dragAndDrop(WebElement element, WebElement target) {
		
		Actions act = new Actions(driver);
		act.dragAndDrop(element, target);
	}
	public void moveToElement(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element);
	}
	
	public void moveAndClick(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).click().build().perform();
	}
	
	public WebElement getElement(WebDriver driver, String loctype, String locvalue) {
		if (loctype.equals("id")) {
				return driver.findElement(By.id(locvalue));
		}
		else if (loctype.equals("xpath")) {
			System.out.println(locvalue);
			return (driver.findElement(By.xpath(locvalue)));
		}
		else if (loctype.equals("text")) {
			return driver.findElement(By.linkText(locvalue));
		}
		else if (loctype.equals("css")) {
			return driver.findElement(By.cssSelector(locvalue));
		}
		else{
			return null;
		}
		}
	
}
