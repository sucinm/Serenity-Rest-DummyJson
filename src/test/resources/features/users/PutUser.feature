Feature: Update user

  @Test @PositiveCase @Users
  Scenario: Update user with valid id
    Given Update user with 1 as id and valid JSON
    When Send request put update user
    Then Should return status code 200
    And Response body id 1
    And Validate json schema success update user

  @Test @NegativeCase @Users
  Scenario: Update user with unavailable ID
    Given Update user with 0 as id and valid JSON
    When Send request put update user
    Then Should return status code 404
    And Response body message "not found"
    And Validate json schema failed update user
