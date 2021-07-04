$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Articles.feature");
formatter.feature({
  "line": 2,
  "name": "Display, Create, Update, Delete Articles",
  "description": "",
  "id": "display,-create,-update,-delete-articles",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@articles"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "GET: Display List of Articles on Global Feed on First page",
  "description": "",
  "id": "display,-create,-update,-delete-articles;get:-display-list-of-articles-on-global-feed-on-first-page",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I want to access articles from global feed with limit \u003c10\u003e and offset \u003c0\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I hit get request",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "the status code is 200",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "the schmea should be as ArticlesSchema",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "articles count should be 10",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 55
    },
    {
      "val": "0",
      "offset": 71
    }
  ],
  "location": "ArticlesStepDefenition.i_want_to_access_articles_from_global_feed(int,int)"
});
formatter.result({
  "duration": 80131000,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.i_hit_the_API()"
});
formatter.result({
  "duration": 1384217200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 19
    }
  ],
  "location": "ArticlesStepDefenition.verify_status_code_as(int)"
});
formatter.result({
  "duration": 44277600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ArticlesSchema",
      "offset": 24
    }
  ],
  "location": "ArticlesStepDefenition.verify_response_schema(String)"
});
formatter.result({
  "duration": 513346500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 25
    }
  ],
  "location": "ArticlesStepDefenition.verify_articles_count(int)"
});
formatter.result({
  "duration": 24841100,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "GET: Display List of Articles on personal feed",
  "description": "",
  "id": "display,-create,-update,-delete-articles;get:-display-list-of-articles-on-personal-feed",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 12,
      "name": "@defect"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "I want to access articles from user feed \u003c5\u003e and offset \u003c0\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "I hit get request",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "the status code is 200",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "the schmea should be as ArticlesSchema",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "articles count should be greater than 0",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 42
    },
    {
      "val": "0",
      "offset": 57
    }
  ],
  "location": "ArticlesStepDefenition.i_want_to_access_articles_from_user_feed(int,int)"
});
formatter.result({
  "duration": 2166500,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.i_hit_the_API()"
});
formatter.result({
  "duration": 1170293800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 19
    }
  ],
  "location": "ArticlesStepDefenition.verify_status_code_as(int)"
});
formatter.result({
  "duration": 409300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ArticlesSchema",
      "offset": 24
    }
  ],
  "location": "ArticlesStepDefenition.verify_response_schema(String)"
});
formatter.result({
  "duration": 7821600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 38
    }
  ],
  "location": "ArticlesStepDefenition.verify_articles_count_greater_than(int)"
});
formatter.result({
  "duration": 9937100,
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:86)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat org.junit.Assert.assertTrue(Assert.java:52)\r\n\tat com.backbase.api.stepdefinitions.ArticlesStepDefenition.verify_articles_count_greater_than(ArticlesStepDefenition.java:70)\r\n\tat ✽.And articles count should be greater than 0(Articles.feature:18)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 21,
  "name": "POST: Add a new article",
  "description": "",
  "id": "display,-create,-update,-delete-articles;post:-add-a-new-article",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 20,
      "name": "@create"
    },
    {
      "line": 20,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 22,
  "name": "I want to add a new article",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "I hit post request",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "the status code is 200",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "the schmea should be as ArticleSchema",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "verify response should contains article content",
  "keyword": "And "
});
formatter.match({
  "location": "ArticlesStepDefenition.i_want_to_add_a_new_article()"
});
formatter.result({
  "duration": 113939600,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.i_hit_post_request()"
});
formatter.result({
  "duration": 1811657500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 19
    }
  ],
  "location": "ArticlesStepDefenition.verify_status_code_as(int)"
});
formatter.result({
  "duration": 673100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ArticleSchema",
      "offset": 24
    }
  ],
  "location": "ArticlesStepDefenition.verify_response_schema(String)"
});
formatter.result({
  "duration": 12826400,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.verify_response_contains_article_content()"
});
formatter.result({
  "duration": 89189000,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "DELETE: Deleate article from the list",
  "description": "",
  "id": "display,-create,-update,-delete-articles;delete:-deleate-article-from-the-list",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 28,
      "name": "@delete"
    },
    {
      "line": 28,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "I want to add a new article",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "I hit post request",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "the status code is 200",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "store the slug",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "I want to delete an article with slug",
  "keyword": "Given "
});
formatter.step({
  "line": 35,
  "name": "I hit delete request",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "the status code is 204",
  "keyword": "Then "
});
formatter.match({
  "location": "ArticlesStepDefenition.i_want_to_add_a_new_article()"
});
formatter.result({
  "duration": 8717600,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.i_hit_post_request()"
});
formatter.result({
  "duration": 1758354300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 19
    }
  ],
  "location": "ArticlesStepDefenition.verify_status_code_as(int)"
});
formatter.result({
  "duration": 742500,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.store_the_slugId()"
});
formatter.result({
  "duration": 11158700,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.i_want_to_delete_an_article_with_slugId()"
});
formatter.result({
  "duration": 2702700,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.i_hit_delete_request()"
});
formatter.result({
  "duration": 1578342400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "204",
      "offset": 19
    }
  ],
  "location": "ArticlesStepDefenition.verify_status_code_as(int)"
});
formatter.result({
  "duration": 406900,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 40,
  "name": "DELETE: Try to delete a article which is doesn\u0027t exist",
  "description": "",
  "id": "display,-create,-update,-delete-articles;delete:-try-to-delete-a-article-which-is-doesn\u0027t-exist",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 39,
      "name": "@deleteArticle"
    }
  ]
});
formatter.step({
  "line": 41,
  "name": "I want to delete an article with slug \"\u003cSlug\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 42,
  "name": "I hit delete request",
  "keyword": "When "
});
formatter.step({
  "line": 43,
  "name": "the status code is \"\u003cStatus\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 44,
  "name": "the resposne should be \"\u003cError Message\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "line": 45,
  "name": "",
  "description": "",
  "id": "display,-create,-update,-delete-articles;delete:-try-to-delete-a-article-which-is-doesn\u0027t-exist;",
  "rows": [
    {
      "cells": [
        "Slug",
        "Status",
        "Error Message"
      ],
      "line": 46,
      "id": "display,-create,-update,-delete-articles;delete:-try-to-delete-a-article-which-is-doesn\u0027t-exist;;1"
    },
    {
      "cells": [
        "how-to-train-your-dragon-e3o9iw",
        "403",
        "Forbidden"
      ],
      "line": 47,
      "id": "display,-create,-update,-delete-articles;delete:-try-to-delete-a-article-which-is-doesn\u0027t-exist;;2"
    },
    {
      "cells": [
        "I-dont-exist-e3o9iw",
        "404",
        "Not Found"
      ],
      "line": 48,
      "id": "display,-create,-update,-delete-articles;delete:-try-to-delete-a-article-which-is-doesn\u0027t-exist;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 47,
  "name": "DELETE: Try to delete a article which is doesn\u0027t exist",
  "description": "",
  "id": "display,-create,-update,-delete-articles;delete:-try-to-delete-a-article-which-is-doesn\u0027t-exist;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@articles"
    },
    {
      "line": 39,
      "name": "@deleteArticle"
    }
  ]
});
formatter.step({
  "line": 41,
  "name": "I want to delete an article with slug \"how-to-train-your-dragon-e3o9iw\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 42,
  "name": "I hit delete request",
  "keyword": "When "
});
formatter.step({
  "line": 43,
  "name": "the status code is \"403\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 44,
  "name": "the resposne should be \"Forbidden\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "how-to-train-your-dragon-e3o9iw",
      "offset": 39
    }
  ],
  "location": "ArticlesStepDefenition.i_want_to_delete_an_article_with_slug(String)"
});
formatter.result({
  "duration": 570900,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.i_hit_delete_request()"
});
formatter.result({
  "duration": 1591966500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "403",
      "offset": 20
    }
  ],
  "location": "ArticlesStepDefenition.verify_status_code(int)"
});
formatter.result({
  "duration": 3667400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Forbidden",
      "offset": 24
    }
  ],
  "location": "ArticlesStepDefenition.the_resposne_should_be(String)"
});
formatter.result({
  "duration": 433300,
  "status": "passed"
});
formatter.scenario({
  "line": 48,
  "name": "DELETE: Try to delete a article which is doesn\u0027t exist",
  "description": "",
  "id": "display,-create,-update,-delete-articles;delete:-try-to-delete-a-article-which-is-doesn\u0027t-exist;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@articles"
    },
    {
      "line": 39,
      "name": "@deleteArticle"
    }
  ]
});
formatter.step({
  "line": 41,
  "name": "I want to delete an article with slug \"I-dont-exist-e3o9iw\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 42,
  "name": "I hit delete request",
  "keyword": "When "
});
formatter.step({
  "line": 43,
  "name": "the status code is \"404\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 44,
  "name": "the resposne should be \"Not Found\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "I-dont-exist-e3o9iw",
      "offset": 39
    }
  ],
  "location": "ArticlesStepDefenition.i_want_to_delete_an_article_with_slug(String)"
});
formatter.result({
  "duration": 1857400,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.i_hit_delete_request()"
});
formatter.result({
  "duration": 2462921200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 20
    }
  ],
  "location": "ArticlesStepDefenition.verify_status_code(int)"
});
formatter.result({
  "duration": 307900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Not Found",
      "offset": 24
    }
  ],
  "location": "ArticlesStepDefenition.the_resposne_should_be(String)"
});
formatter.result({
  "duration": 139900,
  "status": "passed"
});
formatter.scenario({
  "line": 52,
  "name": "PUT: Update an exiting article",
  "description": "",
  "id": "display,-create,-update,-delete-articles;put:-update-an-exiting-article",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 51,
      "name": "@update"
    },
    {
      "line": 51,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 53,
  "name": "I want to add a new article",
  "keyword": "Given "
});
formatter.step({
  "line": 54,
  "name": "I hit post request",
  "keyword": "When "
});
formatter.step({
  "line": 55,
  "name": "the status code is 200",
  "keyword": "Then "
});
formatter.step({
  "line": 56,
  "name": "store the slug",
  "keyword": "And "
});
formatter.step({
  "line": 57,
  "name": "I want to update a article with slug",
  "keyword": "Given "
});
formatter.step({
  "line": 58,
  "name": "I hit put request",
  "keyword": "When "
});
formatter.step({
  "line": 59,
  "name": "the status code is 200",
  "keyword": "Then "
});
formatter.step({
  "line": 60,
  "name": "the schmea should be as ArticleSchema",
  "keyword": "And "
});
formatter.match({
  "location": "ArticlesStepDefenition.i_want_to_add_a_new_article()"
});
formatter.result({
  "duration": 6053200,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.i_hit_post_request()"
});
formatter.result({
  "duration": 1349000400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 19
    }
  ],
  "location": "ArticlesStepDefenition.verify_status_code_as(int)"
});
formatter.result({
  "duration": 698400,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.store_the_slugId()"
});
formatter.result({
  "duration": 10845900,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.i_want_to_update_a_article_with_slug()"
});
formatter.result({
  "duration": 2453900,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.i_hit_put_request()"
});
formatter.result({
  "duration": 1024466100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 19
    }
  ],
  "location": "ArticlesStepDefenition.verify_status_code_as(int)"
});
formatter.result({
  "duration": 825400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ArticleSchema",
      "offset": 24
    }
  ],
  "location": "ArticlesStepDefenition.verify_response_schema(String)"
});
formatter.result({
  "duration": 9499500,
  "status": "passed"
});
formatter.scenario({
  "line": 63,
  "name": "PUT: Update an exiting article",
  "description": "",
  "id": "display,-create,-update,-delete-articles;put:-update-an-exiting-article",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 62,
      "name": "@update"
    }
  ]
});
formatter.step({
  "line": 64,
  "name": "I want to update a article with slug \"I-dont-exist-e3o9iw\"",
  "keyword": "Given "
});
formatter.step({
  "line": 65,
  "name": "I hit put request",
  "keyword": "When "
});
formatter.step({
  "line": 66,
  "name": "the status code is 404",
  "keyword": "Then "
});
formatter.step({
  "line": 67,
  "name": "the resposne should be \"Not Found\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "I-dont-exist-e3o9iw",
      "offset": 38
    }
  ],
  "location": "ArticlesStepDefenition.i_want_to_update_a_article_with_slug(String)"
});
formatter.result({
  "duration": 2782800,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.i_hit_put_request()"
});
formatter.result({
  "duration": 1460228900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 19
    }
  ],
  "location": "ArticlesStepDefenition.verify_status_code_as(int)"
});
formatter.result({
  "duration": 525500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Not Found",
      "offset": 24
    }
  ],
  "location": "ArticlesStepDefenition.the_resposne_should_be(String)"
});
formatter.result({
  "duration": 140100,
  "status": "passed"
});
formatter.scenario({
  "line": 70,
  "name": "GET Verify a article with slug",
  "description": "",
  "id": "display,-create,-update,-delete-articles;get-verify-a-article-with-slug",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 69,
      "name": "@read"
    },
    {
      "line": 69,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 71,
  "name": "I want to add a new article",
  "keyword": "Given "
});
formatter.step({
  "line": 72,
  "name": "I hit post request",
  "keyword": "When "
});
formatter.step({
  "line": 73,
  "name": "the status code is 200",
  "keyword": "Then "
});
formatter.step({
  "line": 74,
  "name": "store the slug",
  "keyword": "And "
});
formatter.step({
  "line": 75,
  "name": "I want to verify a article with slug",
  "keyword": "Given "
});
formatter.step({
  "line": 76,
  "name": "I hit get request",
  "keyword": "When "
});
formatter.step({
  "line": 77,
  "name": "the status code is 200",
  "keyword": "Then "
});
formatter.step({
  "line": 78,
  "name": "the schmea should be as ArticleSchema",
  "keyword": "And "
});
formatter.step({
  "line": 79,
  "name": "verify response should contains article content",
  "keyword": "And "
});
formatter.match({
  "location": "ArticlesStepDefenition.i_want_to_add_a_new_article()"
});
formatter.result({
  "duration": 4662300,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.i_hit_post_request()"
});
formatter.result({
  "duration": 1498187900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 19
    }
  ],
  "location": "ArticlesStepDefenition.verify_status_code_as(int)"
});
formatter.result({
  "duration": 754700,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.store_the_slugId()"
});
formatter.result({
  "duration": 10450500,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.i_want_to_verify_a_article_with_slug()"
});
formatter.result({
  "duration": 651700,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.i_hit_the_API()"
});
formatter.result({
  "duration": 1387831100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 19
    }
  ],
  "location": "ArticlesStepDefenition.verify_status_code_as(int)"
});
formatter.result({
  "duration": 2580300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ArticleSchema",
      "offset": 24
    }
  ],
  "location": "ArticlesStepDefenition.verify_response_schema(String)"
});
formatter.result({
  "duration": 12198700,
  "status": "passed"
});
formatter.match({
  "location": "ArticlesStepDefenition.verify_response_contains_article_content()"
});
formatter.result({
  "duration": 114667500,
  "status": "passed"
});
formatter.uri("Tags.feature");
formatter.feature({
  "line": 2,
  "name": "Display lists of Tags",
  "description": "",
  "id": "display-lists-of-tags",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@tags"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "GET: Display List of tags on home page",
  "description": "",
  "id": "display-lists-of-tags;get:-display-list-of-tags-on-home-page",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I want to access tags from home page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I hit get request for tags",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "the tags status code is 200",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "the tags schmea should be as TagsSchema",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "the response should contains following tags",
  "rows": [
    {
      "cells": [
        "matrix"
      ],
      "line": 11
    },
    {
      "cells": [
        "capacitor"
      ],
      "line": 12
    },
    {
      "cells": [
        "card"
      ],
      "line": 13
    },
    {
      "cells": [
        "interface"
      ],
      "line": 14
    },
    {
      "cells": [
        "protocol"
      ],
      "line": 15
    },
    {
      "cells": [
        "firewall"
      ],
      "line": 16
    },
    {
      "cells": [
        "bus"
      ],
      "line": 17
    },
    {
      "cells": [
        "pixel"
      ],
      "line": 18
    },
    {
      "cells": [
        "circuit"
      ],
      "line": 19
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "TagsStepDefenition.i_want_to_access_tags_from_home_page()"
});
formatter.result({
  "duration": 1245900,
  "status": "passed"
});
formatter.match({
  "location": "TagsStepDefenition.i_hit_the_API()"
});
formatter.result({
  "duration": 900747100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 24
    }
  ],
  "location": "TagsStepDefenition.verify_status_code(int)"
});
formatter.result({
  "duration": 893300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "TagsSchema",
      "offset": 29
    }
  ],
  "location": "TagsStepDefenition.verify_response_schema(String)"
});
formatter.result({
  "duration": 7718600,
  "status": "passed"
});
formatter.match({
  "location": "TagsStepDefenition.the_response_should_contains(DataTable)"
});
formatter.result({
  "duration": 164850000,
  "status": "passed"
});
});