package com.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtility {

	public void selectTextByVisiblity(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
		}
	public void selectTextByIndex(WebElement element, int i) {
		Select s = new Select(element);
		s.selectByIndex(i);
		}
	public void selectTextByValue(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByValue(text);
		}
	
}
