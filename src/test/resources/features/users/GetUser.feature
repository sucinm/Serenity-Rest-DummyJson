Feature: Get single user

  @Test @PositiveCase @Users
  Scenario: Get single user with valid id
    Given Get single user with valid id 1
    When Send request get single user
    Then Should return status code 200
    And Validate json schema single user


  @Test @NegativeCase @Users
  Scenario: Get single user with special char as id
    Given Get single user with invalid id "@!#@"
    When Send request get single user
    Then Should return status code 400