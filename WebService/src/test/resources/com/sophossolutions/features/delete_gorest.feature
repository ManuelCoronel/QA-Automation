@tag
Feature: Api users

  @tag1
  Scenario: Get api user detail
    Given Dado que "actor name" set the base  url "base url gorest"
    When consult the endpoint for delete "Endpoint Delete Go Rest" with id 86875
	  Then validate the status code 204
