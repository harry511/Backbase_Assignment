package com.backbase.utilities;

import static org.testng.AssertJUnit.assertEquals;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class APIUtils {
	//Global Setup Variables

	public static String path; 
	public static String jsonPathTerm; 
	public static RequestSpecification request;
	public static Response response;
	public static String accessToken="";	
	public static ValidatableResponse json;
	public static String testDataPath = System.getProperty("user.dir")+"/src/test/resources/test-data/";


	//Sets Base URI
	public static void setBaseURI() {
		RestAssured.baseURI = "https://qa-task.backbasecloud.com/api";
	}

	//Sets base path
	public static void setBasePath(String basePathTerm) {
		RestAssured.basePath = basePathTerm;
	}

	//Reset Base URI (after test)
	public static void resetBaseURI() {
		RestAssured.baseURI = null;
	}

	//Reset base path
	public static void resetBasePath() {
		RestAssured.basePath = null;
	}

	//Sets ContentType
	public static void setContentType(ContentType Type) {
		RestAssured.requestSpecification.header("CONTENT_TYPE", Type);
	}

	//Sets ContentType
	public static void setBasicHeaders(RequestSpecification request) {
		request.accept("application/json");
		request.contentType("application/json");
		request.header("Authorization", "Basic Y2FuZGlkYXRleDpxYS1pcy1jb29s");
	}

	//Sets ContentType
	public static RequestSpecification setBasicRequest(RequestSpecification request) {
		setBaseURI();		
		request = RestAssured.given();	
		setBasicHeaders(request);
		return request;
	}

	public static void validateBasicRequestHeaders(Response response) {
		assertEquals(response.getHeader("Content-Type"),"application/json; charset=utf-8");
	}

	public static void setAccessToken() throws TestFrameworkException {
		try {
			setBasePath("/users/login");
			RequestSpecification request = APIUtils.setBasicRequest(APIUtils.request);  		
			String requestBody;
			requestBody = FileUtils.readFileAsString(APIUtils.testDataPath+"json/User.json");
			request.body(requestBody);
			response = request.post();
			assertEquals(200, response.getStatusCode());
			APIUtils.accessToken = response.jsonPath().getString("user.token");
			System.out.println("AccessToken : "+accessToken);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TestFrameworkException("Unable to create access token");
			
		}
	}

}