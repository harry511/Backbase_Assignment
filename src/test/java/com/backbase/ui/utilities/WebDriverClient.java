package com.backbase.ui.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.backbase.utilities.TestFrameworkException;

public class WebDriverClient {

	protected WebDriver myDriver;
	private final int implicitWait = 5000;
	private final int pageloadtimeout = 30;
	private final int WEBDRIVER_CLIENT_EXPLICIT_DELAY = 60;
	public WebDriverWait webdriverWait;

	public WebDriverClient(WebDriver driver) {
		this.myDriver = driver;
		myDriver.manage().timeouts()
		.pageLoadTimeout(pageloadtimeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		webdriverWait = new WebDriverWait(driver, WEBDRIVER_CLIENT_EXPLICIT_DELAY);
		webdriverWait.ignoring(StaleElementReferenceException.class);
		setImplicitWait(implicitWait);
	}

	public WebDriver getWebDriver() {
		return myDriver;
	}

	public void quit() {
		myDriver.quit();
	}

	public void close() {
		myDriver.close();
	}

	public void setImplicitWait(int implicitWait) {
		myDriver.manage().timeouts()
		.implicitlyWait(implicitWait, TimeUnit.MILLISECONDS);
	}

	/**
	 *  Wait for element to be visible and enabled such that you
	 * can click it.
	 *
	 * @param xpath
	 * @return WebElement
	 * @throws Exception
	 */
	public WebElement waitForElementToBeClickable(WebElement element) throws TestFrameworkException {
		return webdriverWait.until(ExpectedConditions
				.elementToBeClickable(element));
	}

	/**
	 * Waits for the visibility of the element (WebElement) on DOM of a page
	 *
	 * @param element
	 * @return WebElement
	 * @throws Exception
	 */
	public WebElement waitForVisibilityOfElement(WebElement element) throws Exception{
		try {
			return webdriverWait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Failed in waitForVisibilityOfElement");
		}	
	}

	/**
	 * First checks if element is displayed or not? If true then checks if it is enabled
	 *
	 * @param element
	 * @return True if the element is enabled, false otherwise.
	 * @throws Exception
	 */
	public boolean isWebElementEnabled(WebElement element) throws TestFrameworkException{
		if(element.isEnabled()) {
			if(!element.getAttribute("class").contains("disabled"))
				return true;
		}
		return false;
	}

	/**
	 * First checks if element is present or not? If true then checks if it is displayed
	 *
	 * @param element
	 * @return True if the element is enabled, false otherwise.
	 * @throws Exception
	 */
	public boolean isWebElementDisplayed(String element) throws TestFrameworkException{
		if(myDriver.findElements(By.xpath(element)).size()>0 )
			return myDriver.findElement(By.xpath(element)).isDisplayed();
		else
			return false;
	}



	/**
	 * Perform click action on element
	 *
	 * @param locator
	 * @return boolean
	 * @throws Exception
	 */
	public boolean click(WebElement element) throws TestFrameworkException {
		try {				
			waitForElementToBeClickable(element);
			if(isWebElementEnabled(element)){
				element.click();
				return true;
			}
			else
				throw new TestFrameworkException("Click failed as the element is disabled.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Failed to click, as either unable to locate element OR met an exception.");
		}
	}

	/**
	 * Perform click action on element
	 *
	 * @param locator
	 * @return boolean
	 * @throws Exception
	 */
	public boolean click(By locator) throws TestFrameworkException {
		try {			
			WebElement element = myDriver.findElement(locator);
			waitForElementToBeClickable(element);
			if(isWebElementEnabled(element)){
				element.click();
				return true;
			}
			else
				throw new TestFrameworkException("Click failed as the element is disabled.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Failed to click, as either unable to locate element OR met an exception.");
		}
	}

	/**
	 * Clears the existing text and enters new text
	 * @param locator
	 * @param inputText
	 * @throws Exception
	 */
	public boolean clearTextAndType(WebElement element, String inputText) throws TestFrameworkException {
		try {
			if(isWebElementEnabled(element)){
				element.click();
				element.clear();			
				element.sendKeys(inputText);
				return true;
			}else
				return false;			
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Failed to enter the text into input field");
		}
	}

	/**
	 * Clears the existing text if any, type the new text and hits 'Enter' key
	 *
	 * @param element
	 * @param inputText
	 * @return true if provided input text is set in the element, false otherwise
	 * @throws Exception
	 */
	public boolean clearTextTypeAndHitEnterKey(WebElement element, String inputText) throws TestFrameworkException {
		boolean flag = false;
		if(isWebElementEnabled(element)){
			element.clear();
			element.sendKeys(inputText);
			element.sendKeys(Keys.ENTER);
			return flag;
		}else{
			throw new TestFrameworkException("Locator does not exists or it is disabled");
		}
	}


	/**
	 * Get the text from locator
	 *
	 * @param locator
	 * @return text
	 * @throws Exception
	 */
	public String getText(WebElement locator) throws TestFrameworkException {
		return locator.getText();
	}

	/**
	 * Get the text from locator
	 *
	 * @param locator
	 * @return text
	 * @throws Exception
	 */
	public String getText(String locator) throws TestFrameworkException {
		return getWebDriver().findElement(By.xpath(locator)).getText();
	}


	/**
	 * Get the text from locator
	 *
	 * @param locator
	 * @return text
	 * @throws Exception
	 */
	public int getElementCount(String locator) throws TestFrameworkException {
		return myDriver.findElements(By.xpath(locator)).size();
	}






}
