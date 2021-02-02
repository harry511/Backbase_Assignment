# Backbase QA Assignment

##  Description

This assessment’s goal is to measure the candidate's knowledge of Git, test case creation, test reporting, and the ability to adapt to automation tools.

The purpose of this assessment is to show your API and Web testing skills, knowledge in Git, test case creation, testing approach, and reporting, and the ability to adapt with automation tools.

We will evaluate the technical test depending on your seniority level by evaluating:

* the test strategy
* test coverage
* test cases
* practices adopted

## Prerequisites to develop the tests
- GitHub account

## Application Under Test

**BBlog** is a social blogging site (i.e. a Medium.com clone).
It has an API that uses a custom API for all requests, including authentication and a Web interface that implements the API and enables the final users to use it through a web browser.

### General functionality

All the functionalities bellow are implemented in the API and Web layers:

- CRUD Articles
- CR*D Comments on articles (no updating required)
- GET and display paginated lists of articles
- Favorite articles
- Follow other users

### API layer

The API endpoints and JSON return Objects are described in the [Specs.md](Specs.md) document.

### Web Layer
You can access the BBlog web page using the following URL: [https://qa-task.backbasecloud.com](https://qa-task.backbasecloud.com)

To authenticate into the page you can use the following credentials:
* Username: `candidatex`
* Password: `qa-is-cool`

#### Functionalities

- Home page (URL: /#/ )
  - List of tags
  - List of articles pulled from either Feed, Global, or by Tag
  - Pagination for list of articles
- Sign in/Sign up pages (URL: /#/login, /#/register )
  - Uses JWT (store the token in localStorage)
  - Authentication can be easily switched to session/cookie based
- Settings page (URL: /#/settings )
- Editor page to create/edit articles (URL: /#/editor, /#/editor/article-slug-here )
- Article page (URL: /#/article/article-slug-here )
  - Delete article button (_only shown to article's author_)
  - Render markdown from server client side
  - Comments section at bottom of page
  - Delete comment button (_only shown to comment author_)
- Profile page (URL: /#/profile/:username, /#/profile/:username/favorites )
  - Show basic user info
  - List of articles populated from author's created articles or author's favorite articles

## Deliverables

### Must-haves

These are the items you must deliver in your assignment

* Create a **document containing a series of manual test cases** that cover one functionality that you choose
* Create, at least, 2 (two) **automated scripts for API tests** that can be run successfully
* Create, at least, 2 (two) **automated scripts for Web tests** that can be run successfully
* Create an **Overall Evaluation Report** for the application containing:
   * the issues found
   * why you chose the test cases to automate
   * any other additional information you would like to add, e.g. risks, recommendations, approach, etc.
* An **automatic test report** that must be generated after the tests run 
* Clear **README** file containing:
   * how to run the test cases/suite (assume the reader does not know your coding language)
   * how to access the generated report

### Nice to have
* Framework modules that can demonstrate your skills in the design and implementation of testing frameworks, e.g. layers, design patterns, or other architectural decisions. Please hold the balance of solution complexity vs tasks being solved, do not overengineer
* CI/CD scripts in any tool (Jenkins, GitHub Actions, GitLab CI, Travis CI, etc..)
* Toggle for on/off headless execution for the front-end tests
* Suggestions for improvements

### We will not accept
* Use of record & play tools to generate both API and Web automated tests
* Deliver the API part with no code. Ex: Postman collections, Karate specifications, etc...

### Additional information
* Candidates that do not deliver all the **Must haves** will be automatically rejected
* You can either create only one project for the API and Web part. If you decide to create separate projects you must send both links
* You can use any programming language you like but as we work with Java and Javascript we would appreciate the tech assignment in one of these

## How to deliver the assignment

### What do you need to deliver to us
As soon as you finish you must:

* Deliver the assignment in a private GitHub repository (please contact your tech recruiter)
* Ask the tech recruiter the user you must add as a collaborator, so we can review your assignment
* You can also attach a zip file of your project, but the GitHub link is also mandatory
* Don't forget to tell us where are the documents you created

### How long do I have to deliver the assignment?

* You can allocate as much time as needed, however focus on delivering your solution within 7 days from the moment of receiving the assignment. If more time is needed, please reach out to discuss the deadline