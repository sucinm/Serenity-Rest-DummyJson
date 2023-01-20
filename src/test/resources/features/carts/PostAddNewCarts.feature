Feature: Post add cart feature
#  @Test @PositiveCase @Carts
#  Scenario:Post add new cart with valid json and valid user id
#  Given Post add new cart with valid json and valid user id 1
#  When Send request post add new cart
#  Then Should return status code 200
#  And Response body user id should be 1
#  And Validate json schema post add cart


  @Test @NegativeCase @Carts
  Scenario:Post add new cart with invalid json
  Given Post add new cart with invalid json
  When Send request post add new cart
  Then Should return status code 400
  And Response body message "products can not be empty"
