Feature: Patch update product

  @Test @PositiveCase @Products
  Scenario Outline: Patch update product with valid json
    Given Patch update product with valid JSON and <id> as valid Id product
    When Send request patch update product
    Then Should return status code 200
    And Response body should be <price> as price and <stock> as stock
    And Validate json schema update products
    Examples:
      | id | price | stock |
      | 1  | 789   | 50    |

  @Test @NegativeCase @Products
  Scenario: Patch update product with invalid json
    Given Patch update product with invalid JSON and 1 as valid Id product
    When Send request patch update product
    Then Should return status code 400
