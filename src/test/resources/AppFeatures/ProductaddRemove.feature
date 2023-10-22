Feature: Add/Remove products to the cart

Scenario: Add a Product to the Cart
Given the user is on the homepage
When the user adds a product to the cart
Then the product should be in the cart

Scenario: Remove a Product from the Cart
Given the user is on homepage with a product in the cart
When the user removes the product from the cart
Then the cart should be empty