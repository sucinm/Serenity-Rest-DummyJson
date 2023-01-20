Feature: Get cart of user
@Test @PositiveCase @Carts
Scenario: Get cart of user with valid id
Given Get cart of user with valid id 6
When Send request get cart of user
Then Should return status code 200
#And Validate json schema get cart of user

@Test @NegativeCase @Carts
Scenario: Get cart of user with invalid id
Given Get cart of user with invalid id 0
When Send request get cart of user
Then Should return status code 404
And Response body message "not found"
And Validate json schema get cart of user Invalid Schema