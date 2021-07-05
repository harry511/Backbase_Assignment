### Backbase-QA-assignment

## Test Cases File -  `src/test/reports/BackBaseAssignmentTCs_2.pdf` 
Test case id highligted with yellow are identifed for automation and in which few of them marked as smoke tests

##Open Defects
![Open Defects](src/test/reports/ExistingDefects.PNG?raw=true "Open Defects")


For API I have used Rest-Assured with Cucumber and for reporting I used Extent Reports
## Run Both API and UI tests together
Command to run both API and UI tests together
```sh
mvn clean test
```
## API Test Execution Steps
To Run all api related tests mentioned in the framework
```sh
mvn -DsomeModule.test.excludes="**/ui/tests/*.*java" test
```
To Run specific tests associated with tag use following command
```sh
mvn -DsomeModule.test.excludes="**/ui/tests/*.*java" test -Dcucumber.options="--tags @smoke"
```

> API test results report path: `src/test/reports/cucumber_report.html` 

Report looks like <Add screenshot>
![API Report](src/test/reports/API_Report_Preview.PNG?raw=true "API Report")



For UI tests I have used testNg with selenium and customized Testng Report by using listners

## UI Test Execution Steps
  
To Run all UI related tests mentioned in the framework
```sh
mvn -DsomeModule.test.excludes="**/BackbaseRunnerTest.*java" test
```
To pass parameters from build use following command "env","headless","browser", "hub"
```sh
mvn -DsomeModule.test.excludes="**/BackbaseRunnerTest.*java" test -Denv="qa" -Dheadless="Yes"
```
> UI test results report path: `Backbase-QA-assignment/test-output/index.html` 

> UI test results report path for Emailable report :`Backbase-QA-assignment/test-output/index.html` 

Report looks like <Add screenshot>
## UI Detailed Report
![UI Report](src/test/reports/TestNGReportPrecview1.PNG?raw=true "UI Report")

## UI Emailable Report
![UI Report](src/test/reports/TestNGReportPreview2.PNG?raw=true "UI Emailable Report")

## Recommendation and Enhancements
- Currently for test data we have used Faker library, instead of this we create metdata for all objects and we can leverage serialization and deserialization
- We can enhance reproting part of UI tests
- Right now we have used high level logging across the framework, we can add low level logging to make it more easy for debugging
- We can add docker setup to run UI scripts on dockerized grid


