@POC
Feature: Get all Countries

  Background:
    * def token = '60e766c1edaf51662f909893cd2bced8'
    * param access_key = token


  Scenario: Get all countries [2xx]
    Given url uxURL = baseURL + '/v2/all'
    When method GET
    Then status 200
    * string jsonSchemaExpected = read('file:src/test/java/schema/countriesAll/countriesAll[200]_schema.json')
    * string jsonData = response
    * def SchemaUtils = Java.type('util.JSONSchemaUtil')
    * assert SchemaUtils.isValid(jsonData, jsonSchemaExpected)
    * string responseBodyExpected = read('file:src/test/java/response/countriesAll/countriesAll_responseBody.json')
    Then match jsonData == responseBodyExpected


  Scenario Outline: Get by id countries [2xx]
    Given url uxURL = baseURL + '/v2/alpha/<code>'
    When method GET
    Then status 200
    * string jsonSchemaExpected = read('file:src/test/java/schema/countryBy/countryBy[200]_schema.json')
    * string jsonData = response
    * def SchemaUtils = Java.type('util.JSONSchemaUtil')
    * assert SchemaUtils.isValid(jsonData, jsonSchemaExpected)
    * string responseBodyExpected = read('file:src/test/java/response/countryBy/countries[<code>]_responseBody.json')
    Then match jsonData == responseBodyExpected
    * match $.alpha2Code == "<code>"

    Examples:
      | code |
      | US   |
      | DE   |
      | GB   |


  Scenario Outline: POST create country [201]
    Given url uxURL = baseURL + '/v2/create'
    And json requestBody = read('file:src/test/java/bdd/request/json/requestCreateCountry.json')
    And replace requestBody.name = <name>
    And replace requestBody.alpha2_code = <alpha2_code>
    And replace requestBody.alpha3_code = <alpha3_code>
    When method POST
    Then status 201

    Examples:
      | name           | alpha2_code | alpha3_code |
      | Test Country 1 | TC          | TCY         |