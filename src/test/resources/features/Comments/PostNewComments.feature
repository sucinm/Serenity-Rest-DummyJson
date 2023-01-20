Feature: Post Comments

  @Test @NegativeCase @Comments
  Scenario: Post add new comment with invalid path
    Given Post add new comment with valid json
    When send invalid request post comment
    Then API should return status code 404

  @Test @PositiveCase @Comments
  Scenario:Post add new comment with valid path
    Given Post add new comment with valid json
    When send request post comment
    Then API should return status code 200
    And response body post ID should be 3, user ID 5, and body "This makes all sense to me!"
    And validate json schema post comments

