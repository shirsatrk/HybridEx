package com.utility;

import com.testBase.BaseClass;

public class DriverUtility extends BaseClass {
	
	public void switchToFrameIndex(String index) {
	driver.switchTo().frame(index);	
	}
	public void switchToFrameName(String id) {
		driver.switchTo().frame(id);	
		}
	public void switchToFrameElement(String element) {
		driver.switchTo().frame(element);	
		}
	public void switchToFrameIndexParent() {
		driver.switchTo().parentFrame();	
		}
	public void switchToWindow(String id) {
		driver.switchTo().window(id);
		}
	}
