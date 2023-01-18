Feature: Add Product

  @Test @PositiveCase @Products
  Scenario Outline: Add product with valid JSON
    Given Add products with valid json
    When Post products request
    Then Should return status code 200
    And Response body should contain "<title>"
    And Validate json schema success add products
    Examples:
      | title            |
      | iPhone Galaxy +1 |

  @Test @NegativeCase @Products
  Scenario: Add product with invalid JSON
    Given Add products with valid json
    When Post products request
    Then Should return status code 400


