Feature: Add user

  @Test @PositiveCase @Users
  Scenario Outline: Add user with valid JSON
    Given Add user with valid json
    When Post user request
    Then Should return status code 200
    And Response body should contain "<firstName>" as firstName and "<lastName>" as lastName
    And Validate json schema success add user
    Examples:
      | firstName | lastName |
      | Suci      | Maharani |

  @Test @NegativeCase @Users
  Scenario: Add user without JSON
    Given Add user without json
    When Post user request
    Then Should return status code 400


