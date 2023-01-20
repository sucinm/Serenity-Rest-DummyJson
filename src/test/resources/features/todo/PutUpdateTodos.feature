Feature: Put Update todos with valid JSON
  @Test
  Scenario: Put update todos with valid JSON
    Given Put update todos with valid JSON and as 1 valid id todos
    When Send request put update todo and completed
    Then Should return status code 200
    And Response body name should be todo "Rico Rinaldi QE"
    And Validate JSON schema update todos
  @Test
  Scenario: Put update todos with invalid JSON
    Given Put update todo with invalid JSON and 1 as valid id todos
    When Send request put update todo and completed
    Then Should return status code 400