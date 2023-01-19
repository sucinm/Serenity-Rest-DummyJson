Feature: Get Product

  @Test @PositiveCase @Products
  Scenario: Get list products with valid token
    Given Get list product with valid token
    When Send request get list product
    Then Should return status code 200
    And Validate json schema list product


  @Test @NegativeCase @Products
  Scenario: Get list products with expired token
    Given Get list product with expired token
    When Send request get list product
    Then Should return status code 403