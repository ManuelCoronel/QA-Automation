@restful1
Feature: 	Retrive object in api restful

  @restful1
  Scenario: retrive object in Get
    Given Dado que "actor name" set the base  url "base url restful"
    When consult the endpoint "Endpoint Get restful"
		Then validate the status code 200 and the schema with "Json schema restful"


