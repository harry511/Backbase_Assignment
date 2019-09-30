# Backbase QA Assignment

##  Description

This assessment is to measure the candidate's knowledge with Git, test cases creation, test reporting and the ability to adapt with automation tools.

## Prerequisites
- GitHub account

## Application Under Test

"**BBlog**" is a social blogging site (i.e. a Medium.com clone). It uses a custom API for all requests, including authentication.

## General functionality

- User Sign-up/Login/Logout (button on settings page)
- CRUD Articles
- CR*D Comments on articles (no updating required)
- GET and display paginated lists of articles
- Favorite articles
- Follow other users

## Deliverables

To start, please access the following web page [https://qa-task.backbasecloud.com/](https://qa-task.backbasecloud.com/#/), to access the application you can use username: _**candidatex**_ and password: _**qa-is-cool**_

Based on the previously mentioned general functionality, for **both backend and front-end** the following is required:

1. Create a series of manual test cases that cover **one** functionality that you choose
2. Automate ( **at least two** ) of the previously created test cases (you may use different tools for backend and front-end testing)
3. Provide a test report for executed test cases
4. Provide an overall evaluation report for the application (approach, issues, risks, recommendation, why you chose the test cases to automate,etc)
5. When the assignment is completed please push your deliverables to a **private git repository** with clear instructions on where to find each deliverable and how to run tests


## Additional Information

### Application Routing Guidelines

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

### Application API Specs

JSON Objects returned by APIs and application endpoints are described in [Specs.md](Specs.md)