package com.backbase.ui.pageobjects;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.backbase.metadata.Article;
import com.backbase.utilities.TestFrameworkException;

public class ArticlePage extends BasePage {

	@FindBy(css = "input[formcontrolname='title']")
	private WebElement txt_title;

	@FindBy(css = "input[formcontrolname='description']")
	private WebElement txt_description;

	@FindBy(css = "textarea[formcontrolname='body']")
	private WebElement txtArea_body;

	@FindBy(css = "input[placeholder='Enter tags']")
	private WebElement txt_tags;

	@FindBy(xpath = "//button[contains(text(),'Publish Article')]")
	private WebElement btn_publishArticle;
	
	@FindBy(partialLinkText = "Edit Article")
	private WebElement articleContent;
	
	@FindBy(xpath = "//div[@class='banner']//h1")
	private WebElement articleTitle;
	

	@FindBy(xpath = "//div[@class='row article-content']//p")
	private WebElement articleBody;
	
	@FindBy(xpath = "//div[@class='banner']//a[contains(text(),'Edit Article')]")
	private WebElement lnk_editArticle;
	
	
	@FindBy(xpath = "//div[@class='banner']//button[contains(text(),'Delete Article')]")
	private WebElement btn_deleteArticle;
	
	@FindBy(xpath = "//div[@class='card-block']//textarea")
	private WebElement txtArea_CommentBlock;
	
	@FindBy(xpath = "//button[contains(text(),'Post Comment')]")
	private WebElement btn_postComment;	
	
	private String postedComment = "//div[@class='card']//p";
	
	private static String commentContent = "(//div[@class='card']//p)[%d]";
	
	private static String deleteCommentButton = "//p[contains(text(),'%s')]/ancestor::div[@class='card']//i";
	
	
	/**
	 * Navigates to new Article form page
	 * @return boolean
	 * @throws TestFrameworkException
	 */
	public boolean navigateToNewArticleForm() throws TestFrameworkException {
		try {
			webDriverClient.click(lnk_newArticle);
			webDriverClient.waitForVisibilityOfElement(btn_publishArticle);
			return btn_publishArticle.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Falied to click on Home Link");
		}
	}
	

	/**
	 * Fills Article Form
	 * @param email
	 * @param password
	 * @return boolean
	 * @throws TestFrameworkException
	 */
	public boolean fillArticleForm(Article article) throws TestFrameworkException {		
		try {
			if(StringUtils.isNotEmpty(article.getTitle())) {
				webDriverClient.clearTextAndType(txt_title, article.getTitle());
			}
			if(StringUtils.isNotEmpty(article.getDescription())) {
				webDriverClient.clearTextAndType(txt_description, article.getDescription());
			}
			if(StringUtils.isNotEmpty(article.getBody())) {
				webDriverClient.clearTextAndType(txtArea_body, article.getBody());
			}
			if(!article.getTagList().isEmpty()) {
				for(String tag:article.getTagList()) {
					webDriverClient.clearTextTypeAndHitEnterKey(txt_tags, tag);		
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Failed to fill Article Form");
		} 		
	}

	/**
	 * Create or Update Article
	 * @param article
	 * @return
	 * @throws TestFrameworkException
	 */
	public boolean createOrUpdate(Article article) throws TestFrameworkException {		
		try {
			fillArticleForm(article);
			webDriverClient.click(btn_publishArticle);
			webDriverClient.waitForVisibilityOfElement(txtArea_CommentBlock);
			return webDriverClient.isWebElementEnabled(btn_deleteArticle);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Failed to Create an Article");
		} 		
	}
	
	/**
	 * Update Article
	 * @param article
	 * @return
	 * @throws TestFrameworkException
	 */
	public boolean Update(Article article) throws TestFrameworkException {		
		try {
			webDriverClient.click(lnk_editArticle);
			webDriverClient.waitForVisibilityOfElement(btn_publishArticle);
			return createOrUpdate(article);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Failed to Update an Article : " + article.getTitle());
		} 		
	}
	
	/**
	 * Get Article title from opened article
	 * @param article
	 * @return
	 * @throws TestFrameworkException
	 */
	public String getArticleTitle() throws TestFrameworkException {		
		try {			
			return webDriverClient.getText(articleTitle);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Failed to get title of opened article");
		} 		
	}
	
	/**
	 * Get Article body from opened article
	 * @param article
	 * @return
	 * @throws TestFrameworkException
	 */
	public String getArticleBody() throws TestFrameworkException {		
		try {			
			return webDriverClient.getText(articleBody);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Failed to get body of opened article");
		} 		
	}
	
	/**
	 * Delete an opened article
	 * @return boolean
	 * @throws TestFrameworkException
	 */
	public boolean deletArticle() throws TestFrameworkException {		
		try {	
			webDriverClient.isWebElementEnabled(btn_deleteArticle);
			webDriverClient.click(btn_deleteArticle);
			return lnk_yourFeed.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Failed to delete an opened article");
		} 		
	}
	
	/**
	 * Posts new comment on opened article
	 * @param article
	 * @return
	 * @throws TestFrameworkException
	 */
	public boolean addNewComment(String commentText) throws TestFrameworkException {		
		try {	
			webDriverClient.clearTextAndType(txtArea_CommentBlock, commentText);			
			return webDriverClient.click(btn_postComment);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Failed to add new comment");
		} 		
	}
	
	/**
	 * Get number of comments on article
	 * @param article
	 * @return
	 * @throws TestFrameworkException
	 */
	public int getCommentsCount() throws TestFrameworkException {		
		try {			
			return webDriverClient.getElementCount(postedComment);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Failed to get total comments count");
		} 		
	}
	
	/**
	 * Get recent/first comment content from the article
	 * @return comment content
	 * @throws TestFrameworkException
	 */
	public String getRecentCommentContent() throws TestFrameworkException {		
		try {			
			return webDriverClient.getText(commentContent.replace("%d","1"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Failed to get comment content");
		} 		
	}
	
	/**
	 * Delete comment with specific comment
	 * @param comment
	 * @return
	 * @throws TestFrameworkException
	 */
	public boolean deleteComment(String comment) throws TestFrameworkException {		
		try {			
			webDriverClient.click(By.xpath(deleteCommentButton.replace("%s",comment)));
			webDriverClient.waitForElementToBeClickable(btn_postComment);
			webDriverClient.waitForVisibilityOfElement(txtArea_CommentBlock);
			webDriverClient.waitForVisibilityOfElement(lnk_editArticle);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Failed to delete comment");
		} 		
	}



}
