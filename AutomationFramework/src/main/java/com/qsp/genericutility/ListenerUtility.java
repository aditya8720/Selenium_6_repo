package com.qsp.genericutility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerUtility extends BaseClass implements ITestListener {
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			wUtil.takeScreenShot(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
