package com.backbase.ui.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.backbase.ui.tests.BaseTest;
import com.backbase.ui.utilities.WebDriverClient;
import com.backbase.utilities.TestFrameworkException;

public class SigninPage extends BasePage {
	
	@FindBy(css = "input[formcontrolname='email']")
	private WebElement txt_email;

	@FindBy(css = "input[formcontrolname='password']")
	private WebElement txt_password;

	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	private WebElement btn_signIn;

	/**
	 * @return 
	 * @throws TestFrameworkException
	 */
	public boolean navigateToSigninPage() throws TestFrameworkException {
		try {
			webDriverClient.click(lnk_signIn);
			webDriverClient.waitForVisibilityOfElement(txt_email);
			return txt_email.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Falied to click on Home Link");
		}
	}

	/**
	 * signIn method to login to application
	 * @param email
	 * @param password
	 * @return boolean
	 * @throws TestFrameworkException
	 */
	public boolean signIn(String email, String password) throws TestFrameworkException {
		try {
			webDriverClient.getWebDriver().get(BaseTest.properties.getProperty("authUrl"));//Handling authentication
			webDriverClient.getWebDriver().navigate().refresh();
			webDriverClient.getWebDriver().get(BaseTest.applicationUrl);
			Reporter.log("Title : "+webDriverClient.getWebDriver().getTitle(),true);
			navigateToSigninPage();
			webDriverClient.waitForElementToBeClickable(txt_email);
			webDriverClient.clearTextAndType(txt_email, email);
			webDriverClient.clearTextAndType(txt_password, password);
			webDriverClient.click(btn_signIn);
			webDriverClient.waitForVisibilityOfElement(lnk_settings);
			return lnk_settings.isDisplayed();			
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Failed to login");
		}		
	}



}
