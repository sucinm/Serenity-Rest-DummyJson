Feature: Put update cart feature
  @Test @PositiveCase @Carts
    Scenario: Put update a cart with valid json and id
    Given Put update a cart with valid json and id 1
    When Send request put update a cart
    Then Should return status code 200
    And Response body should be id 1
    And Validate json schema put update cart

  @Test @NegativeCase @Carts
    Scenario: Put update a cart with invalid json
    Given Put update a cart with invalid json and id 1
    When Send request put update a cart
    Then Should return status code 404
    And Response body message "not found"
    And Validate json schema put update cart invalid json


