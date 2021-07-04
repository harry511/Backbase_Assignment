package com.backbase.ui.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.backbase.ui.pageobjects.ArticlePage;
import com.backbase.ui.pageobjects.BasePage;
import com.backbase.ui.pageobjects.HomePage;
import com.backbase.ui.pageobjects.SettingsPage;
import com.backbase.ui.pageobjects.SigninPage;


public class Controller {
	
	public WebDriverClient webDriverClient;
	
	public Controller(WebDriver webDriver) {
		super();
		this.webDriverClient= new WebDriverClient(webDriver);
	}
	
	public WebDriverClient getWebDriverClient() {
		return this.webDriverClient;
	}
	
	/*
	 * public Controller(WebDriverClient webDriverClient) { super();
	 * Controller.webDriverClient=webDriverClient; }
	 * 
	 */
	private <T extends BasePage> T initPage(Class<T> t) {
    	T page = PageFactory.initElements(webDriverClient.getWebDriver(), t);
    	page.setWebDriverClient(webDriverClient);
        return page;
    }
	
	public HomePage homePage() {		
		return initPage(HomePage.class);
	}
	
	public SigninPage signInPage() {		
		return initPage(SigninPage.class);
	}
	
	public ArticlePage articlePage() {
		return initPage(ArticlePage.class);
	}
	
	public SettingsPage settingsPage() {
		return initPage(SettingsPage.class);
	}
	
	public BasePage basePage() {
		return initPage(BasePage.class);
	}
	
	
	
	
	

}
