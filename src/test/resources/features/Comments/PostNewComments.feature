Feature: Put Comments

  @Test @NegativeCase @Comments
  Scenario: Post add new comment with invalid path
    Given Post add new comment with valid json
    When send invalid request post comment
    Then API should return status code 404

