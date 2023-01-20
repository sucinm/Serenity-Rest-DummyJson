Feature: Delete carts
  @Test @PositiveCase @Carts
  Scenario: Delete a cart with valid id
  Given Delete a cart with valid id 2
  When Send request delete a cart
  Then Should return code 200
  And Response body id should be 2
  And Validate schema delete a cart

  @Test @NegativeCase @Carts
  Scenario: Delete a cart with invalid id
  Given Delete a cart with invalid id 0
  When Send request delete a cart
  Then Should return code 404
  And Response body message "not found"
  And Validate schema delete a cart invalid id
