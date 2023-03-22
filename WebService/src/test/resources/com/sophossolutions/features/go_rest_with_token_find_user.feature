@tag
Feature: Api users

  @tag1
  Scenario: Get api user detail
    Given Dado que "actor name" set the base  url "base url gorest"
    When consult the endpoint "endpoint user-GET" with token
     Then validate the status code 200 and the schema with "Json schema User gorest"
      | id     |            1011410 |
      | name   | manuel             |
      | email  | manuel@hotmail.com |
      | gender | male               |
      | status | active             |
