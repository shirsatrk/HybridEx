package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersEx implements ITestListener{

	public void onTestStart(ITestResult result) {
	System.out.println("test is started = "+ result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("test is passed = "+ result.getName());
		
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("test is fail = "+ result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("test is skipped = "+ result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("test is fail = "+ result.getName());
		
	}

	public void onStart(ITestContext context) {
		System.out.println("test is contect start = "+ context.getName());
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("test is finish = "+ context.getName());		
	}

}
