Feature: Post add new Todo
  @Test
  Scenario: Post add new todo with valid JSON
    Given Post add new todo with valid JSON
    When Send request post add new todo
    Then Should return status code 200
    And Response body name should be id 151
    And Validate JSON schema success add new todo

  @Test
  Scenario: Post add new todo with invalid JSON
    Given Post add new todo invalid JSON
    When Send request post add new todo
    Then Should return status code 400
    And Validate JSON schema failed add new todo

