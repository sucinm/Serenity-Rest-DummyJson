Feature: Get single cart
  @Test @PositiveCase @Carts

    Scenario: Get single cart with valid id
    Given Get single cart with valid id 1
    When Send request get single cart
    Then Should return status code 200
    And Response body should be id 1
    And Validate json schema get single cart



    @Test @NegativeCase @Carts
  Scenario: Get single cart with invalid id
    Given Get single cart with invalid id 0
    When Send request get single cart
    Then Should return status code 404
    And Response body message "not found"
    And Validate json schema for failed to get single cart

