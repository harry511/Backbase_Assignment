package com.backbase.ui.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.backbase.ui.utilities.Controller;
import com.backbase.ui.utilities.WebDriverClient;
import com.backbase.ui.workflow.BackbaseWorkflow;
import com.backbase.utilities.TestFrameworkException;
import com.backbase.utilities.TestNGListenerAdapter;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseTest {

	public ThreadLocal<RemoteWebDriver> remoteDriver = null;
	public ThreadLocal<WebDriver> webDriver = null;
	protected String environment = null;
	protected String myTestName = null;
	protected boolean headlessMode = false;
	protected boolean runOnGrid = false;
	protected String executionBrowser = "";
	protected String hubUrl = "";
	public static Properties properties;
	protected WebDriverClient webDriverClient;
	protected Controller controller;
	protected BackbaseWorkflow backbaseWorkflow;
	public static String applicationUrl;
	public WebDriver baseDriver;



	public WebDriver getLocalDriver(ThreadLocal<WebDriver> webDriver) {
		baseDriver = webDriver.get();
		return baseDriver;
	}

	public WebDriver getRemoteDriver(ThreadLocal<RemoteWebDriver> webDriver) {
		baseDriver = webDriver.get();
		return baseDriver;
	}


	public BaseTest(){
		try {
			properties = new Properties();
			//System.out.println("The browser property is: " + browserProperties);
			FileInputStream props = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/config/FrameworkConfig.properties");
			properties.load(props);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}




	@Parameters({"env","headless","browser", "hub"})
	@BeforeSuite(alwaysRun=true)
	public void beforeSuite( @Optional String env,@Optional String headless, @Optional String browser, @Optional String hub) throws TestFrameworkException, Exception{

		//Handling both maven and testng parameters 

		//Set Headless mode
		if(StringUtils.isNotEmpty(System.getProperty("headless")))
			headlessMode = System.getProperty("headless").equalsIgnoreCase("Yes")?true:false;
		else				
			headlessMode = StringUtils.isNotEmpty(headless) && headless.equalsIgnoreCase("Yes")?true:false; //setting default to no if headless apart from yes

		//set execution mode to either remote or local, if remote set hub url
		if(StringUtils.isNotEmpty(System.getProperty("hub"))) {
			runOnGrid = true;
			hubUrl = System.getProperty("hub");
		}
		else{
			runOnGrid = StringUtils.isNotEmpty(hub)?true:false;
			hubUrl = hub;
		}

		//Set browser
		if(StringUtils.isNotEmpty(System.getProperty("browser"))) 
			executionBrowser = System.getProperty("browser");
		else
			executionBrowser = StringUtils.isNotEmpty(browser)?browser:"chrome";

		//Set environment
		if(StringUtils.isNotEmpty(System.getProperty("env"))) 
			environment = System.getProperty("env");
		else
			environment = StringUtils.isNotEmpty(env)?env:"qa";

		Reporter.log("************************** TEST EXECUTION PARAMETERS **************************");
		Reporter.log("Headless Mode : " + headlessMode,true);
		Reporter.log("Execution Environment : " + environment,true);
		Reporter.log("Remote[true] or Local[false] : " + runOnGrid,true);
		Reporter.log("Hub Url : " +hubUrl,true);
		Reporter.log("Browser : " + executionBrowser,true);
	}


	@Parameters({"env","headless","browser", "hub"})
	@BeforeClass(alwaysRun=true )
	public void setUp(@Optional String env,@Optional String headless,@Optional String browser, @Optional String hub,
			ITestContext ctx) throws Exception {
		//setting default values incase no values passed
		browser = StringUtils.isNotEmpty(browser)?browser:"chrome";
		env = StringUtils.isNotEmpty(env)?env:"qa";
		//Invoking Listener here for better reporting
		TestRunner runner = (TestRunner) ctx;
		ctx.setAttribute("user", "");
		ctx.setAttribute("priority", "");
		runner.addListener(new TestNGListenerAdapter(this));

		DesiredCapabilities dc = new DesiredCapabilities();
		LoggingPreferences loggingprefs = new LoggingPreferences();
		loggingprefs.enable(LogType.BROWSER, Level.ALL);
		dc.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
		// Setting environment, browser and hub from testng xml file

		if(runOnGrid) {	
			this.remoteDriver = new ThreadLocal<RemoteWebDriver>();
			//Just to test local grid
			System.setProperty("webdriver.chrome.driver", "C://Users//hmarothu//Downloads//chromedriver_win32//chromedriver.exe");
			System.out.println("Running on grid");
			if (browser.equalsIgnoreCase("firefox")) {	
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setAcceptInsecureCerts(false);
				firefoxOptions.setHeadless(headlessMode);
				dc.setBrowserName("firefox");
				dc.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
				dc.setCapability("marionette", true);
			} else if (browser.equalsIgnoreCase("chrome")) {
				dc.setBrowserName("chrome");
				HashMap<String, Object> plugin = new HashMap<String, Object>();
				plugin.put("enabled", false);
				HashMap<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_settings.popups", 0);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				prefs.put("plugins.plugins_list", Arrays.asList(plugin));
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.setHeadless(headlessMode);//setting headless mode
				dc.setCapability(ChromeOptions.CAPABILITY, options);
			}
			remoteDriver.set(new RemoteWebDriver(new URL(hubUrl), dc));
			this.getRemoteDriver(remoteDriver);
			baseDriver = remoteDriver.get();
		}
		else {
			this.webDriver = new ThreadLocal<WebDriver>();
			if (browser.equalsIgnoreCase("chrome")) {
				HashMap<String, Object> plugin = new HashMap<String, Object>();
				plugin.put("enabled", false);
				HashMap<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_settings.popups", 0);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				prefs.put("plugins.plugins_list", Arrays.asList(plugin));
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.setHeadless(headlessMode);//setting headless mode	
				WebDriverManager.chromedriver().setup();	
				webDriver.set(new ChromeDriver(options));
				baseDriver = webDriver.get();
			}
		}

		controller = new Controller(webDriver.get());
		backbaseWorkflow = new BackbaseWorkflow(controller);
		applicationUrl = properties.getProperty("applicationUrl").replace("env", env);
		Reporter.log("Application URL : "+applicationUrl,true);	
	}

	@AfterClass
	public void tearDown() {
		Reporter.log("Closing the driver session",true);
		webDriver.get().quit();
	}

}
