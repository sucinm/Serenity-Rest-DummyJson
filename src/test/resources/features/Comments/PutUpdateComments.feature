Feature: Put Update Comments

  @Test @PositiveCase @Comments
  Scenario: Put update comment with valid json
    Given put comment by id 3
    When send request put Update comment
    Then API should return status code 200
    And response body post ID should be 61, user ID 29, and body is "make daily activity"
    And validate json schema put comments

  @Test @NegativeCase @Comments
  Scenario: Put update comment with invalid json
    Given put comment by id 100 with invalid json
    When send request put Update comment
    Then API should return status code 400
