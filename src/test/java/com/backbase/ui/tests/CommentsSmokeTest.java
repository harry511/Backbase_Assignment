package com.backbase.ui.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.joda.time.LocalDate;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.backbase.metadata.Article;
import com.backbase.utilities.DataGenerator;
import com.backbase.utilities.TestFrameworkException;



public class CommentsSmokeTest extends BaseTest {
	
	private Article article;
	private String comment;
	private int beforeCount;
	
	/*
	 * public CommentsSmokeTest() { super(); }
	 */

	@Test(description = "Login to application")
	public void test001_login() throws TestFrameworkException, InterruptedException {
		Assert.assertTrue(controller.signInPage().signIn(properties.getProperty("email"),properties.getProperty("password")),"Failed to login to application");
	}	
	
	@Test(dependsOnMethods = "test001_login",description = "Create a new article Aand verify data")
	public void test002_articleCreationAndVerification() throws TestFrameworkException {
		article = DataGenerator.getArticleWithRandomData();
		assertTrue(backbaseWorkflow.createNewArticle(article), "Failed to create a new article with random data");
		assertEquals(controller.articlePage().getArticleTitle(), article.getTitle());
	}
	
	@Test(dependsOnMethods = "test002_articleCreationAndVerification",description = "Add comments to newley created post")
	public void test003_AddNewComment() throws TestFrameworkException {
		comment = DataGenerator.getFakerObj().aviation().airport().replaceAll("'", "");//creating new comment content
		beforeCount = controller.articlePage().getCommentsCount();
		assertTrue(controller.articlePage().addNewComment(comment),"Failed to post new comment");		
	}
	
	@Test(dependsOnMethods = "test003_AddNewComment",description = "Validate newley added comment on page")
	public void test004_verifyNewleyAddedComment() throws TestFrameworkException {
		assertEquals(controller.articlePage().getCommentsCount(),beforeCount+1);
		assertEquals(controller.articlePage().getRecentCommentContent(),comment);
		backbaseWorkflow.openArticleFromUserProfile(article.getTitle());
		int actualCount = controller.articlePage().getCommentsCount();
		assertEquals(actualCount,beforeCount+1,"Comments count doesn't match : ");
		assertEquals(controller.articlePage().getRecentCommentContent(),comment);
	}	

	@Test(dependsOnMethods = "test003_AddNewComment",description = "Validate delete comment functionlaity")
	public void test005_verifyDeleteComment() throws TestFrameworkException {
		beforeCount = controller.articlePage().getCommentsCount();
		comment = DataGenerator.getFakerObj().aviation().airport();//creating new comment content
		assertTrue(controller.articlePage().addNewComment(comment),"Failed to post new comment");
		controller.articlePage().deleteComment(comment);
		assertEquals(controller.articlePage().getCommentsCount(),beforeCount);		
	}
	
	@Test(dependsOnMethods = "test005_verifyDeleteComment",description = "Logouts from the application", alwaysRun = true)
	public void test006_logout() throws TestFrameworkException {
		assertTrue(controller.settingsPage().logout(), "Failed to logout from the application ");
	}

}
