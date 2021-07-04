package com.backbase.ui.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.backbase.ui.tests.BaseTest;
	
public class ExtentReportsClass {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	private BaseTest bt;
	
	public ExtentReportsClass() {
		super();
	}

	public ExtentReportsClass(BaseTest baseTest) {
		super();
		this.bt = baseTest;
	}

	@BeforeTest
	public void startReport() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/BackBase_UI_TestReport.html");
        	// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Backbase");
        	extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Hari Kiran");
		htmlReporter.config().setDocumentTitle("UI Test Report"); 
                // Name of the report
		htmlReporter.config().setReportName("UI Automation Test Report"); 
                // Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD);			
	}
	
	//This method is to capture the screenshot and return the path of the screenshot.
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	/*
	 * @AfterMethod public void getResult(ITestResult result) throws Exception{
	 * if(result.getStatus() == ITestResult.FAILURE){ //MarkupHelper is used to
	 * display the output in different colors logger.log(Status.FAIL,
	 * MarkupHelper.createLabel(result.getName() + " - Test Case Failed",
	 * ExtentColor.RED)); logger.log(Status.FAIL,
	 * MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed",
	 * ExtentColor.RED)); String screenshotPath = getScreenShot(w result.getName());
	 * //To add it in the extent report
	 * logger.fail("Test Case Failed Snapshot is below " +
	 * logger.addScreenCaptureFromPath(screenshotPath)); } else
	 * if(result.getStatus() == ITestResult.SKIP){ logger.log(Status.SKIP,
	 * MarkupHelper.createLabel(result.getName() + " - Test Case Skipped",
	 * ExtentColor.ORANGE)); } else if(result.getStatus() == ITestResult.SUCCESS) {
	 * logger.log(Status.PASS,
	 * MarkupHelper.createLabel(result.getName()+" Test Case PASSED",
	 * ExtentColor.GREEN)); } }
	 */

	@AfterTest
	public void endReport() {
		extent.flush();
	}
}