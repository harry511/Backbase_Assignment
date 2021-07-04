package com.backbase.utilities;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class TroubleShoot {
	public static void main(String[] args) {
		System.out.println(DataGenerator.generateArticleRequestBody());
		
		Map<String, ?> parametersMap;
		ResponseAwareMatcher<Response> responseAwareMatcher;
		RestAssured.given()
		.baseUri("")
		.baseUri("")
	//	.params(parametersMap)
		.header("", "")
		.accept("")
		.when()
		.post()
		.then()
		.statusCode(200)
		.assertThat();
		//.body("", "", responseAwareMatcher);
	}

}
