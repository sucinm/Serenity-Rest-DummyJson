Feature: Get Single Comment

  @Test @PositiveCase @Comments
  Scenario Outline: Get single comment by valid post id
    Given get comment by post id <id>
    When send request get comment
    Then API should return status code 200
    And response body id should be <commentsID>
    And validate json schema get comments
  Examples:
    | id | commentsID |
    | 3  | 56         |
    | 95 | 101        |

  @Test @NegativeCase @Comments
  Scenario: Get single comment by invalid post id
    Given get comment by invalid post id "%#"
    When send invalid request get comment
    Then API should return status code 400

