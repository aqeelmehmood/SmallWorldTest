Feature: Login page feature


Scenario: Login page link
Given user is on login page
When user get the link of the page
Then Login page link should be "https://www.saucedemo.com/"

Scenario: Login with correct credentials
Given user is on login page
When user enters username "standard_user"
And user enters password "secret_sauce"
And user click on login button
Then user gets the link of the home page
And Home page link should be "https://www.saucedemo.com/inventory.html"








