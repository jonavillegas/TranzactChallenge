# Service Framework using Karate DSL

This project is a service framework that utilizes Karate DSL, a Behavior Driven Development (BDD) testing framework based on Gherkin, to perform web service testing.

## Requirements

- Java 11
- Maven

## Test Execution

To execute the tests, Maven is used, and a RUN CONFIGURATION has been created in the project with the following command:

clean test "-Dkarate.options=--tags @POC" -Dkarate.env=cert


This command will run the tests tagged with "@POC" and use the "cert" environment configuration. 
Make sure to have the appropriate configuration in the `karate-config.js` file for the certification environment.

## Test Report

After executing the tests, a web-based report will be generated, providing a detailed view of the results. You can access this report at the following location:
target/surefire-reports/karate-summary.html

The report displays information such as executed scenarios, their status (pass, fail, skip), execution times, and more.

## Project Structure

The project follows a typical Maven structure, with the main directories and files organized as follows:

src
  main
    java (Java source code)
    resources (Project resources)
  test
    java (Java source code for tests)
    resources (Test resources)
      features (Karate DSL test files)


