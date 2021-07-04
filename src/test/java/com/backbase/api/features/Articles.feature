@articles
Feature: Display, Create, Update, Delete Articles

@smoke
  Scenario: GET: Display List of Articles on Global Feed on First page
    Given I want to access articles from global feed with limit <10> and offset <0>
    When I hit get request 
    Then the status code is 200
    And the schmea should be as ArticlesSchema
    And articles count should be 10
 
 @defect
 Scenario: GET: Display List of Articles on personal feed
    Given I want to access articles from user feed <5> and offset <0>
    When I hit get request
    Then the status code is 200
    And the schmea should be as ArticlesSchema
    And articles count should be greater than 0
  
  @create @smoke  
  Scenario: POST: Add a new article
    Given I want to add a new article
    When I hit post request 
    Then the status code is 200
    And the schmea should be as ArticleSchema
    And verify response should contains article content
  
  @delete @smoke
  Scenario: DELETE: Deleate article from the list
    Given I want to add a new article
    When I hit post request 
    Then the status code is 200
    And store the slug
    Given I want to delete an article with slug
    When I hit delete request 
    Then the status code is 204
  
    
  @deleteArticle
  Scenario Outline: DELETE: Try to delete a article which is doesn't exist
    Given I want to delete an article with slug "<Slug>"
    When I hit delete request 
    Then the status code is "<Status>"
    And the resposne should be "<Error Message>"
    Examples:
    |	Slug								|	Status	| Error Message	|
    |	how-to-train-your-dragon-e3o9iw		|	403		|	Forbidden	|
    |	I-dont-exist-e3o9iw					|	404		|	Not Found	|
    
    
  @update @smoke
  Scenario: PUT: Update an exiting article
  	Given I want to add a new article
    When I hit post request 
    Then the status code is 200
    And store the slug
    Given I want to update a article with slug
    When I hit put request 
    Then the status code is 200
    And the schmea should be as ArticleSchema
    
   @update
  Scenario: PUT: Update an exiting article
    Given I want to update a article with slug "I-dont-exist-e3o9iw"
    When I hit put request 
    Then the status code is 404
    And the resposne should be "Not Found"
    
  @read @smoke
  Scenario: GET Verify a article with slug
  	Given I want to add a new article
    When I hit post request 
    Then the status code is 200
    And store the slug
    Given I want to verify a article with slug
    When I hit get request 
    Then the status code is 200
    And the schmea should be as ArticleSchema
    And verify response should contains article content

      
  
    
      
 
 