##Technologies
* Java
* Maven
* Cucumber
* Selenium Webdriver

## Before Building
* Ensure that you have Chrome installed and the chromedriver that matches your Chrome version available on your $PATH. You may have to update this from time to time.
* Ensure that you have npm installed.
* Ensure that you Java SDK installed.

## usage
* Run src/test/java/runner/Testrunner.java
* Reports opens automatecally when finish the execution

## Architecture POM
* Features: src/test/java/features/FE
* Steps: src/test/java/glue/FrontEndSteps
* Pages: src/test/java/pom/pages
* Properties: src/test/resources/testing.properties
* ChromeDriver: src/test/resources/chromedriver