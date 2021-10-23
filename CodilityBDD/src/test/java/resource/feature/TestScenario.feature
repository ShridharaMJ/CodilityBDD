Feature: Verify Add to wish and add to cart functionality
Scenario: Add to cart successfuly
Given I add four different products to my wish list
When I view my wishlist table
Then I find total select four items in my Wishlist
When I search for lowest price product
And I am able to add lowest price item to my cart
Then I am able to verify the item in my cart


