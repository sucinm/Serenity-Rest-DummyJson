Feature: Delete Todo
  @Test
  Scenario: Delete Todos with id API
    Given Given Delete todos with valid id 1
    When Send request delete todos
    Then Should return status code 200
    And Validate JSON schema Success delete todos

  @Test
  Scenario: Delete Todos with unavailable id API
    Given Delete todos with unavailable id "xyzz"
    When Send request delete todos
    Then Should return status code 404
    And Validate json schema failed delete todos

