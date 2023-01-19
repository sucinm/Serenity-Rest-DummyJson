Feature: Delete user

  @Test @PositiveCase @Users
  Scenario: Delete user with valid id
    Given Delete user with valid id 1
    When Send request delete user
    Then Should return status code 200

  @Test @NegativeCase @Users
  Scenario: Delete product with invalid id
    Given Delete product with invalid id "x"
    When Send request delete user
    Then Should return status code 400
    And Response body message "Invalid user id"

