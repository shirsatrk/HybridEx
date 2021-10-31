package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryListener implements IRetryAnalyzer {

	int count = 1;
	int maxlimit = 3;
	
	public boolean retry(ITestResult result) {
		

		if (count < maxlimit) {
			count++;
			return true;
		}
		return false;
	}

}
