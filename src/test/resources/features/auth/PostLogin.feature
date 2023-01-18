Feature: Login user
  @Test @PositiveCase
  Scenario: Login with valid username and password
    Given Login with valid JSON
    When Send request post to login
    Then Should return status code 200
    And Validate json schema success login

  @Test @NegativeCase
  Scenario: Login with valid username and empty password
    Given Login with invalid JSON
    When Send request post to login
    Then Should return status code 400
    And Response body message "Invalid credentials"
    And Validate json schema failed login