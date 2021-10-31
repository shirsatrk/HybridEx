package com.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.testBase.BaseClass;

public class RobotUtility extends BaseClass {
	private Robot r;
	public void pressEnter() {
		
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_ENTER);
	}
public void pressTab() {
		
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_TAB);
	}
	
public void pressEsc() {
	
	try {
		r = new Robot();
	} catch (AWTException e) {
		e.printStackTrace();
	}
	r.keyPress(KeyEvent.VK_ESCAPE);
}
	
}
