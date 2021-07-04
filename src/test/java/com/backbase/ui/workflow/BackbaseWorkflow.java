package com.backbase.ui.workflow;

import com.backbase.metadata.Article;
import com.backbase.ui.utilities.Controller;
import com.backbase.ui.utilities.WebDriverClient;
import com.backbase.utilities.TestFrameworkException;

public class BackbaseWorkflow {	

	private Controller controller;
	private WebDriverClient webDriverClient;
	
	public BackbaseWorkflow(Controller controller) {
		this.controller = controller;
		this.webDriverClient = controller.getWebDriverClient();
	}
	
	/**
	 * Work flow method to create article 
	 * @param article
	 * @return
	 * @throws TestFrameworkException
	 */
	public boolean createNewArticle(Article article) throws TestFrameworkException {		
		try {
			controller.articlePage().navigateToNewArticleForm();			
			return controller.articlePage().createOrUpdate(article);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Failed to Create an Article");
		} 		
	}
	
	/**
	 * Work flow method to create article 
	 * @param article
	 * @return
	 * @throws TestFrameworkException
	 */
	public boolean updateRandomArticle(Article article) throws TestFrameworkException {		
		try {
			controller.articlePage().navigateToNewArticleForm();			
			return controller.articlePage().createOrUpdate(article);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Failed to Create an Article");
		} 		
	}
	
	/**
	 *Navigates to User profile and open post with specific title
	 * @param article
	 * @return
	 * @throws TestFrameworkException
	 */
	public boolean openArticleFromUserProfile(String title) throws TestFrameworkException {		
		try {
			controller.basePage().navigateToUserProfile();			
			controller.basePage().openPostWithTitle(title);
			return controller.articlePage().getArticleTitle().equals(title);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Failed to Create an Article");
		} 		
	}
	

}
