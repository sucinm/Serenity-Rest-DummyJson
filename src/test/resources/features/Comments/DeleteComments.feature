Feature: Delete Comments

  @Test @PositiveCase @Comments
  Scenario: Delete comment with valid id
    Given Delete comment with id 3
    When send request delete comment
    Then API should return status code 200
    And response body id should be 3 and user ID 29, and Username "jissetts"
    And validate json schema success delete comments

  @Test @NegativeCase @Comments
  Scenario: Delete comment with invalid id
    Given Delete comment with id "x"
    When send invalid request delete comment
    Then API should return status code 404
    And response body error should be "Comment with id 'x' not found"
    And validate json schema failed delete comments

  @Test @NegativeCase @Comments
  Scenario: Delete comments with filter
    Given Delete comments with limit 1 and skip 3
    When send request delete comment with filter
    Then API should return status code 404