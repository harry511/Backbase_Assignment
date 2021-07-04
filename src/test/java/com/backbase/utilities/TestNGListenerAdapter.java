package com.backbase.utilities;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;

import com.backbase.ui.tests.BaseTest;
import com.backbase.ui.utilities.Controller;





public class TestNGListenerAdapter extends TestListenerAdapter implements ISuiteListener, ITestListener {

	private BaseTest bt = null;


	public TestNGListenerAdapter() {
		super(); }

	public TestNGListenerAdapter(BaseTest baseTest) { super(); this.bt =
			baseTest; }

	@Override  
	public void onFinish(ISuite suite) {
		Reporter.log("Finished suite " + suite.getName(), true);
	}

	@Override
	public void onStart(ISuite suite) {
		Reporter.log("Started suite " + suite.getName(), true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {

			String currentUrl = bt.baseDriver.getCurrentUrl();
			String description = result.getMethod().getDescription();
			Reporter.log("Test Failed... " + result.getMethod().getMethodName() + "()", true);					
			Reporter.log("Tests executed are as below:",true);

			Reporter.log("<a href='"+currentUrl+ "' target='_blank'>"+currentUrl+"</a>",true);
			File screenshot = ((TakesScreenshot) bt.baseDriver).getScreenshotAs(OutputType.FILE);
			String nameScreenshot =  result.getTestClass().getRealClass().getSimpleName();
			String path = getFullPath(nameScreenshot);
			Reporter.log("Path in take screenshot" +path);
			FileUtils.copyFile(screenshot, new File(path));
			Reporter.log ("\n failure screenshot:");
			Reporter.log ("\n FileName:" +getFileName(nameScreenshot));

			Reporter.log("<img src='" + path+"'"+ " target='_blank' >" + "<br>" + getFileName(nameScreenshot) );
			if (!(result.getThrowable() == null)) {
				result.getThrowable().toString();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		try {
			Reporter.log("Test Skipped : " + result.getMethod().getMethodName() + "()", true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		super.onTestSkipped(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			Reporter.log("Test Passed... " + result.getMethod().getMethodName() + "()", true);		}
		catch (Exception e) {
			e.printStackTrace();
		}
		super.onTestSuccess(result);
	}

	private static String getFileName(String nameTest) throws IOException {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh-mm-ss");	
		return dateFormat.format(date) + "_" + nameTest + ".png";
	}

	private static  String getFullPath(String nameTest) throws IOException {
		File directory = new File(".");
		System.out.println("Path in getpath" +directory.getCanonicalPath());
		String newFileNamePath = System.getProperty("user.dir") + "\\screenShots\\" + getFileName(nameTest);
		return newFileNamePath;
	}




}
