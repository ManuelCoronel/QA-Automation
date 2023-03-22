@rick_and_morty_api
Feature: Retrive character details in rick api

  Scenario: Get detail character
    Given the "actor name" set the base  url "base url rick Api"
    When consult the endpoint of rick api "endpoint rick character-GET"
    Then validate the status code <code> , the data character and the "Json schema rick"
      | code     |              200 |
      | name     | Teacher Rick     |
      | status   | Alive            |
      | species  | Human            |
      | gender   | Male             |
      | location | Citadel of Ricks |
 And prueba