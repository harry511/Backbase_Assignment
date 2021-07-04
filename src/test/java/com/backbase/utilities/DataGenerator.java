package com.backbase.utilities;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.backbase.metadata.Article;
import com.github.javafaker.Faker;

public class DataGenerator {

	public static String articlRequestBody="";

	/**
	 * Generates article json string body with random data
	 * @return json string as a request body 
	 */
	public static String generateArticleRequestBody() {
		Faker faker = new Faker();
		JSONObject json = new JSONObject();
		JSONObject article = new JSONObject();

		//Creating dummy data for every request
		List<String> tagList = new ArrayList<String>();
		tagList.add(faker.harryPotter().character());    

		//creating jsonObject for request body 
		json.put("tagList", tagList);
		json.put("title", faker.harryPotter().book()); 
		json.put("description", faker.harryPotter().house());
		json.put("body", faker.harryPotter().spell());
		article.put("article", json);
		System.out.println(" Article Request Body : " + article.toString());
		return articlRequestBody=article.toString();
	}


	/**
	 * Creates an article object with random data
	 * 
	 *  @return article objects 
	 */
	public static Article getArticleWithRandomData() {
		Faker faker = new Faker();
		//Creating dummy data for every request
		List<String> tagList = new ArrayList<String>();
		tagList.add(faker.book().publisher());  
		Article article = new Article(tagList, faker.book().title(), faker.book().genre(), faker.book().author());
		System.out.println(" Article Request Body : " + article.toString());
		return article;
	}
	
	/**
	 * Creates Facker object to generate random data
	 * 
	 *  @return article objects 
	 */
	public static Faker getFakerObj() {
		Faker faker = new Faker();
		return faker;
	}

}
