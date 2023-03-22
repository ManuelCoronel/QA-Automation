@tag
Feature: Api users

  @tag1
  Scenario: Get api user detail
    Given Dado que "actor name" set the base  url "base url gorest"
    When consult the endpoint "endpoint user-GET" with token
		Then validate the status code 200 and the schema with "Json schema User gorest"


