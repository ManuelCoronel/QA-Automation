@restful1
Feature: 	Retrive object in api restful

  @restful1
  Scenario: retrive object in Get
    Given the "actor name" set the base  url  for restful api "base url restful"
	   When consult the "Endpoint Get restful" 
	   Then validate the status code 200 and the schema restful "Json schema restful"


