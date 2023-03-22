 @restful0
Feature: 	Create object in api restful


  @restful0
  Scenario: create object in post
    Given Dado que "actor name" set the base  url "base url restful"
   	 When consult the "Endpoint Post restful" with the file "data restful"
		Then validate the status code 200 and the schema with "Json schema restful"


