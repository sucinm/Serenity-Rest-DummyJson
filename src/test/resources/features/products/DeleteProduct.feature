Feature: Delete

  @Test @PositiveCase @Products
  Scenario: Delete product with valid id
    Given Delete product with valid id 1
    When Send request delete product
    Then Should return status code 200

  @Test @NegativeCase @Products
  Scenario: Delete product with invalid id
    Given Delete product with valid id 0
    When Send request delete product
    Then Should return status code 404
