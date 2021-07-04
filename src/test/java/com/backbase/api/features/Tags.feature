@tags
Feature: Display lists of Tags

@smoke
  Scenario: GET: Display List of tags on home page
    Given I want to access tags from home page
    When I hit get request for tags
    Then the tags status code is 200
    And the tags schmea should be as TagsSchema
    And the response should contains following tags
    	|	matrix		|
        |	capacitor	|
        |	card		|
        |	interface	|
        |	protocol	|
        |	firewall	|
        |	bus			|
        |	pixel		|
        |	circuit		|

  
 