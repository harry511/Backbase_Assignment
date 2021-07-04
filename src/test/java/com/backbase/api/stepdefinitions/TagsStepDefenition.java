package com.backbase.api.stepdefinitions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.List;

import com.backbase.utilities.APIUtils;
import com.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TagsStepDefenition{

	private static String path="/tags";
	private static Response response;
	private static RequestSpecification request;

	@Given("^I want to access tags from home page$")
	public void i_want_to_access_tags_from_home_page() throws Throwable {
		APIUtils.setBasePath(path);
		request = APIUtils.setBasicRequest(request);
	}


	@Then("^the response should contains following tags$")
	public void the_response_should_contains(DataTable testData) throws Throwable {
		List<String> tags = testData.asList(String.class);
		for (String tag : tags) {
			assertTrue(response.jsonPath().getList("tags").contains(tag));
		}

	}
	
	@When("^I hit get request for tags$")
	public void i_hit_the_API() throws Throwable {
		response = request.when().get();
		System.out.println("************The Response value as --\n" + response.prettyPrint());
		Reporter.addStepLog("************The Response is  *************\n" + response.prettyPrint());
	}
	
	@Then("the tags status code is (\\d+)")
	public void verify_status_code(int statusCode){
		response.then().statusCode(statusCode);
	}

	@Then("the tags schmea should be as (.*)")
	public void verify_response_schema(String schema){
		File schemaFile = new File(APIUtils.testDataPath+"json/"+schema+".json");
		response.then().assertThat().body(matchesJsonSchema(schemaFile));
	}

}
