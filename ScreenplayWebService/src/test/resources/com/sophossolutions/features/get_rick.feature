@rick_and_morty_api
Feature: Retrive character details in rick api

  Scenario: Get detail character
    Given Dado que "actor name" set the base  url "base url rick Api"
   When consult the endpoint "endpoint rick character-GET"
   Then validate the status code 200 and the schema with "Json schema rick"
   
  