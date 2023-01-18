Feature: Put update product

  @Test @PositiveCase
  Scenario: Update product with valid id
    Given Update product with 1 as valid id and valid JSON
    When Send request put update product
    Then Should return status code 200
    And Response body id 1
    And Validate json schema success update product

  @Test @NegativeCase
  Scenario: Update product with invalid ID
    Given Update product with 0 as valid id and valid JSON
    When Send request put update product
    Then Should return status code 404
    And Response body message "not found"
    And Validate json schema failed update product
