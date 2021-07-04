package com.backbase.ui.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.backbase.utilities.TestFrameworkException;

public class SettingsPage extends BasePage {
	

	
	@FindBy(css = "input[placeholder='URL of profile picture']")
	private WebElement txt_urlProfilePic;

	@FindBy(css = "input[placeholder='Username']")
	private WebElement txt_description;

	@FindBy(css = "textarea[placeholder='Short bio about you']")
	private WebElement txt_title;

	@FindBy(css = "input[placeholder='Email']")
	private WebElement txt_email;
	
	@FindBy(css = "input[placeholder='New Password']")
	private WebElement txt_newPassword;
	
	@FindBy(xpath = "//button[text()=' Or click here to logout. ']")
	private WebElement btn_logout;
	
	@FindBy(xpath = "//button[text()=' Update Settings ']")
	private WebElement btn_updateSettings;
	
	/**
	 * Navigates to  settings page
	 * @return object of homePage
	 * @throws TestFrameworkException
	 */
	public boolean navigateToSettings() throws TestFrameworkException {
		try {
			webDriverClient.click(lnk_settings);
			webDriverClient.waitForVisibilityOfElement(btn_logout);
			return btn_logout.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Falied to navigate to settings page");
		}
	}
	
	/**
	 * logout from the application
	 * @return object of homePage
	 * @throws TestFrameworkException
	 */
	public boolean clickOnLogout() throws TestFrameworkException {
		try {
			webDriverClient.click(btn_logout);
			webDriverClient.waitForVisibilityOfElement(lnk_signIn);
			return lnk_signIn.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Falied to click on logout button");
		}
	}
	
	/**
	 * Navigates to settings and logout from the application
	 * @return object of homePage
	 * @throws TestFrameworkException
	 */
	public boolean logout() throws TestFrameworkException {
		try {
			navigateToSettings();
			return clickOnLogout();
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Failed to logout");
		}
	}
	
	



}
