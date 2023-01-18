Feature: Delete


  Scenario Outline: Delete product with invalid id
    Given Delete product with valid id <id>
    When Send request delete product
    Then Should return status code 200
    And Validate json schema delete product
    Examples:
      | id |
      | 1  |