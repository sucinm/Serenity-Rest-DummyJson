Feature: Get Single Todo
  @Test
  Scenario: Get single todo with valid parameter todo id API
    Given Get single todos with valid id 1
    When Send request get single todos
    Then Should return status code 200
    And Validate JSON schema single todos

  @Test
  Scenario: Get single todo with invalid parameter id todo API
    Given Get single todos with invalid id "xyzz"
    When Send request get single todos
    Then Should return status code 404
