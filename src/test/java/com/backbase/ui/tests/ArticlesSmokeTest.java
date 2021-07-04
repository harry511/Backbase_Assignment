package com.backbase.ui.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.joda.time.LocalDate;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.backbase.metadata.Article;
import com.backbase.utilities.DataGenerator;
import com.backbase.utilities.TestFrameworkException;



public class ArticlesSmokeTest extends BaseTest {
	
	private Article article;
	
	/*
	 * public ArticlesSmokeTest() { super(); }
	 */

	@Test(description = "Login to application")
	public void test001_login() throws TestFrameworkException {
		System.out.println("I am in login test");	
		Assert.assertTrue(controller.signInPage().signIn(properties.getProperty("email"),properties.getProperty("password")),"Failed to login to application");
	}	
	
	@Test(dependsOnMethods = "test001_login",description = "Create a new article Aand verify data")
	public void test002_articleCreationAndVerification() throws TestFrameworkException {
		article = DataGenerator.getArticleWithRandomData();
		assertTrue(backbaseWorkflow.createNewArticle(article), "Failed to create a new article with random data");
		assertEquals(controller.articlePage().getArticleTitle(), article.getTitle());
	}
	
	@Test(dependsOnMethods = "test002_articleCreationAndVerification",description = "Update article created in above step")
	public void test003_updateNewleyCreatedArticle() throws TestFrameworkException {
		Article updatedArticle = new Article();
		updatedArticle.setTitle("Updated - "+article.getTitle());
		updatedArticle.setBody("Updated - " + article.getBody() +" " + LocalDate.now());
		Reporter.log("Articl title before update : "+ article.getTitle());
		Reporter.log("Articl title after update : "+ updatedArticle.getTitle());
		assertTrue(controller.articlePage().Update(updatedArticle), "Failed to update article with random data");
		assertEquals(controller.articlePage().getArticleTitle(), updatedArticle.getTitle());
		assertEquals(controller.articlePage().getArticleBody(), updatedArticle.getBody());
	}
	
	@Test(dependsOnMethods = "test002_articleCreationAndVerification",description = "Delete article created in above step")
	public void test004_deleteNewleyCreatedArticle() throws TestFrameworkException {
		assertTrue(controller.articlePage().deletArticle(), "Failed to delete article ");
	}
	

	@Test(dependsOnMethods = "test004_deleteNewleyCreatedArticle",description = "Logouts from the application")
	public void test005_logout() throws TestFrameworkException {
		assertTrue(controller.settingsPage().logout(), "Failed to logout from the application ");
	}

}
