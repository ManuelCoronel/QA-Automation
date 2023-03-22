 @restful0
Feature: 	Create object in api restful


  @restful0
  Scenario: create object in post
    Given the "actor name" set the base  url  for restful api "base url restful"
	   When consult the "Endpoint Post restful" with the file "data restful"
	   Then validate the status code 200 and the schema restful "Json schema restful"


