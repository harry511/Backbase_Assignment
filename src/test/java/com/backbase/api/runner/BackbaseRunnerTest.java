package com.backbase.api.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.backbase.utilities.APIUtils;
import com.backbase.utilities.TestFrameworkException;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/backbase/api/features", 
				glue = {"com.backbase.api.stepdefinitions" }, 
				tags = { "@articles, @tags" },
				plugin = {"com.cucumber.listener.ExtentCucumberFormatter:src/test/reports/cucumber_report.html","html:output/html-report"},
			//	dryRun = true,
				monochrome = true
				//strict = false
				)
public class BackbaseRunnerTest    {

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("src/test/resources/config/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Windows 10");
		Reporter.setTestRunnerOutput("Backbase test runner output message");
	}

	@BeforeClass
	public static void setUp() throws TestFrameworkException {
		APIUtils.setAccessToken();
	}
}
