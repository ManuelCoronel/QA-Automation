@tag
Feature: Api users

  @tag1
  Scenario: Get api user detail
    Given Dado que "actor name" set the base  url "base url gorest"
    When consult the "Endpoint Post Go Rest" por medio de una peticion post.
      | email  | manuel9@hotmail.com |
      | name   | manuel              |
      | field  |                 123 |
      | gender | male                |
      | status | active              |
    Then validate the status code 201 and the schema with "Json schema User gorest"
      | id     |            1011410 |
      | name   | manuel             |
      | email  | manuel@hotmail.com |
      | gender | male               |
      | status | active             |
