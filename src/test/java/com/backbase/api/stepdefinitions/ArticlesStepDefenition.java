package com.backbase.api.stepdefinitions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apiguardian.api.API;
import org.json.JSONArray;
import org.json.JSONObject;


import com.backbase.utilities.APIUtils;
import com.backbase.utilities.DataGenerator;
import com.backbase.utilities.FileUtils;
import com.backbase.utilities.TimeValidator;
import com.cucumber.listener.Reporter;
import com.github.javafaker.Faker;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ArticlesStepDefenition{

	private static String jsonPathTerm;	
	private static String slug;
	private static String path="/articles";
	private static Response response;
	private static RequestSpecification request;


	@Given("^I want to access articles from global feed with limit <(\\d+)> and offset <(\\d+)>$")
	public void i_want_to_access_articles_from_global_feed(int limit, int offset) throws Throwable {
		APIUtils.setBasePath(path);
		request = APIUtils.setBasicRequest(request);
		request.param("limit", limit);
		request.param("offset", offset);		
	}

	@When("^I hit get request$")
	public void i_hit_the_API() throws Throwable {
		response = request.when().get();
	}

	@Then("articles count should be (\\d+)")
	public void verify_articles_count(int count){
		APIUtils.validateBasicRequestHeaders(response);
		assertEquals(count, response.jsonPath().getList("articles").size());	
	}

	@Given("^I want to access articles from user feed <(\\d+)> and offset <(\\d+)>$")
	public void i_want_to_access_articles_from_user_feed(int limit, int offset) throws Throwable {
		APIUtils.setBasePath(path+"/feed");
		request = APIUtils.setBasicRequest(request);
		request.header("jwtauthorization", "Token "+APIUtils.accessToken);
		request.param("limit", limit);
		request.param("offset", offset);		
	}

	@Then("articles count should be greater than (\\d+)")
	public void verify_articles_count_greater_than(int count){
		APIUtils.validateBasicRequestHeaders(response);
		assertTrue(response.jsonPath().getList("articles").size()>0);		
		//System.out.println("Access Token : " + APIUtils.accessToken);
	}

	@Given("^I want to add a new article$")
	public void i_want_to_add_a_new_article() throws Throwable {
		APIUtils.setBasePath(path);
		request = APIUtils.setBasicRequest(request);
		request.header("jwtauthorization", "Token "+APIUtils.accessToken);		
		request.body(DataGenerator.generateArticleRequestBody());
	}

	@When("^I hit post request$")
	public void i_hit_post_request() throws Throwable {
		response = request.when().post();
		System.out.println("************The Response value after post request --\n" + response.prettyPrint());
		Reporter.addStepLog("************The Response is  *************\n" + response.prettyPrint());
	}

	@Then("verify response should contains article content")
	public void verify_response_contains_article_content(){
		JSONObject requestBody = new JSONObject(DataGenerator.articlRequestBody).getJSONObject("article");
		assertEquals(response.jsonPath().get("article.title"),requestBody.getString("title"));
		assertEquals(response.jsonPath().get("article.description"),requestBody.getString("description"));
		assertEquals(response.jsonPath().get("article.body"),requestBody.getString("body"));
		assertEquals(response.jsonPath().get("article.tagList"),requestBody.getJSONArray("tagList").toList());
		assertTrue(TimeValidator.isValidDate(response.jsonPath().getString("article.createdAt")));
		assertTrue(TimeValidator.isValidDate(response.jsonPath().getString("article.updatedAt")));
		APIUtils.validateBasicRequestHeaders(response);
	}

	@Then("^store the slug$")
	public void store_the_slugId() throws Throwable {
		slug = response.jsonPath().get("article.slug");

	}

	@When("^I hit delete request$")
	public void i_hit_delete_request() throws Throwable {
		response = request.when().delete();
	}

	@Given("^I want to delete an article with slug$")
	public void i_want_to_delete_an_article_with_slugId() throws Throwable {
		APIUtils.setBasePath(path+ "/" +slug);
		request = APIUtils.setBasicRequest(request);
		request.header("jwtauthorization", "Token "+APIUtils.accessToken);	
		Reporter.addStepLog("************The Response is  *************\n" + response.prettyPrint());
		
	}

	@Given("^I want to update a article with slug$")
	public void i_want_to_update_a_article_with_slug() throws Throwable {
		APIUtils.setBasePath(path+ "/" +slug);
		request = APIUtils.setBasicRequest(request);
		request.header("jwtauthorization", "Token "+APIUtils.accessToken);	
		Faker faker = new Faker();
		JSONObject requestBody = new JSONObject(FileUtils.readFileAsString(APIUtils.testDataPath+"json/newArticleData.json"));
		JSONObject article = requestBody.getJSONObject("article");
		article.put("title", "Updated Title " + faker.date().birthday());
		article.put("description", "Updated Description " + faker.date().birthday());
		article.put("body", "Updated Body " + faker.date().birthday());		
		requestBody.put("article", article);
		request.body(requestBody.toString());

	}
	
	@Given("^I want to update a article with slug \"([^\"]*)\"$")
	public void i_want_to_update_a_article_with_slug(String slug) throws Throwable {
		APIUtils.setBasePath(path+ "/" +slug);
		request = APIUtils.setBasicRequest(request);
		request.header("jwtauthorization", "Token "+APIUtils.accessToken);	
		Faker faker = new Faker();
		JSONObject requestBody = new JSONObject(FileUtils.readFileAsString(APIUtils.testDataPath+"json/newArticleData.json"));
		JSONObject article = requestBody.getJSONObject("article");
		article.put("title", "Updated Title " + faker.date().birthday());
		article.put("description", "Updated Description " + faker.date().birthday());
		article.put("body", "Updated Body " + faker.date().birthday());		
		requestBody.put("article", article);
		request.body(requestBody.toString());

	}

	@When("^I hit put request$")
	public void i_hit_put_request() throws Throwable {
		response = request.when().put();
		System.out.println("************The Response value as Put Request--\n" + response.prettyPrint());
		Reporter.addStepLog("************The Response is  *************\n" + response.prettyPrint());
	}

	@Given("^I want to delete an article with slug \"([^\"]*)\"$")
	public void i_want_to_delete_an_article_with_slug(String slug) throws Throwable {
		APIUtils.setBasePath(path+ "/" +slug);
		request = APIUtils.setBasicRequest(request);
		request.header("jwtauthorization", "Token "+APIUtils.accessToken);	
	}

	@Then("^the resposne should be \"([^\"]*)\"$")
	public void the_resposne_should_be(String resp) throws Throwable {
		assertEquals(resp, response.body().asString());
	}
	
	@Given("^I want to verify a article with slug$")
	public void i_want_to_verify_a_article_with_slug() throws Throwable {
		APIUtils.setBasePath(path+ "/" +slug);
		request = APIUtils.setBasicRequest(request);
		request.header("jwtauthorization", "Token "+APIUtils.accessToken);	
	}
	
	@Then("^the status code is \"([^\"]*)\"$")
	public void verify_status_code(int statusCode){
		response.then().statusCode(statusCode);
	}
	

	@Then("the status code is (\\d+)")
	public void verify_status_code_as(int statusCode){
		response.then().statusCode(statusCode);
	}

	@Then("the schmea should be as (.*)")
	public void verify_response_schema(String schema){
		File schemaFile = new File(APIUtils.testDataPath+"json/"+schema+".json");
		response.then().assertThat().body(matchesJsonSchema(schemaFile));
	}




}
