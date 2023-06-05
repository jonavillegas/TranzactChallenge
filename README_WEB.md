# WEB CHALLENGE using Selenium with Java, Cucumber, and Gherkin

This project is a web functional testing framework that utilizes Selenium WebDriver with Java, Cucumber, and Gherkin. 

## Requirements

- Java 1.8
- Maven

## Test Execution

To execute the tests, Maven is used, and a RUN CONFIGURATION has been created in the project with the following command:
clean verify "-DCucumber.options=--tags @placeOrder"


This command will run the tests tagged with "@placeOrder". Make sure to have the appropriate step definitions and feature files for the scenarios you want to execute.

## Test Report

After executing the tests, a web-based report will be generated, providing a detailed view of the test results. 
You can access this report at the following location:
target/generated-reports/'nameWithFormatCurrentDate'/index.html


## Project Structure

The project follows a Maven structure, with the main directories and files organized as follows:

src
  main
    java (Java source code)
    resources (Project resources)
  test
    java (Java source code for tests)
      stepdefinitions (Cucumber step definitions)
    resources (Test resources)
      features (Gherkin feature files)

