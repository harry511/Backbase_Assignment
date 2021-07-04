package com.backbase.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.backbase.ui.utilities.Controller;
import com.backbase.ui.utilities.WebDriverClient;
import com.backbase.utilities.TestFrameworkException;

public class BasePage {

	protected WebDriverClient webDriverClient;


	public WebDriverClient getWebDriverClient() {
		return webDriverClient;
	}

	public void setWebDriverClient(WebDriverClient webDriverClient) {
		this.webDriverClient = webDriverClient;
	}


	@FindBy(partialLinkText = "Home")
	protected WebElement lnk_homeLink;

	@FindBy(partialLinkText = "Sign in")
	protected WebElement lnk_signIn;
	
	protected String signIn = "//a[contains(text(),'Sign in')]";

	@FindBy(partialLinkText = "Sign up")
	protected WebElement lnk_signUp;

	@FindBy(partialLinkText = "New Article")
	protected WebElement lnk_newArticle;

	@FindBy(linkText = "conduit")
	protected WebElement lnk_conduitLink;

	@FindBy(partialLinkText = "Settings")
	protected WebElement lnk_settings;

	@FindBy(partialLinkText = "Global Feed")
	protected WebElement lnk_globalFeed;

	@FindBy(partialLinkText = "Your Feed")
	protected  WebElement lnk_yourFeed;

	@FindBy(xpath = "(//a[contains(text(),'New Article')]/ancestor::ul//a)[4]")
	protected  WebElement lnk_profile;

	public static String articleAuthor = "(//div[@class='article-preview']//div[@class='info']/a)[%d]";

	public static String articlePostedOn ="(//div[@class='article-preview']//div[@class='info']/a)[%d]";

	public static String articleTitle = "//a[@class='preview-link']/h1[contains(text(),'%s')]";

	public static String articleDescription = "(//a[@class='preview-link']/p)[%d]";

	public static String articlesTagList = "(//div[@class='article-preview']//ul[@class='tag-list'])[%d]/li";

	public static String articlesFavoriteButton = "(//div[@class='article-preview']//button)[%d]";

	public boolean navigateToUserProfile() throws TestFrameworkException {		
		return webDriverClient.click(lnk_profile);		
	}
	
	public boolean openPostWithTitle(String title) throws TestFrameworkException {	
		return webDriverClient.click(By.xpath(articleTitle.replace("%s",title)));		
	}
	
	








}
