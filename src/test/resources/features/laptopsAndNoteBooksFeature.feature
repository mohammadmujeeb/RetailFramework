@LaptopsAndNotebooksFeature
Feature: Laptop & Notebooks Feature


Scenario: Add and Remove a Mac book from Cart
Given User is on Retail website
When User click on Laptops & NoteBooks tab
And User click on Show all Laptops & NoteBooks option
And User clicks on "MacBook" item
And User click Add to Cart button
Then User should see a message ‘Success: You have added "MacBook" to your shopping cart!’
And User should see "1 item(s)-$602.00" showed to the cart
And User click on cart option
And user click on red X button to remove the item from cart
Then item should be removed and cart should show "0 item(s)-$0.00"


Scenario: Product Comparison
Given User is on Retail website
When User click on Laptops & NoteBooks tab
And User click on Show all Laptops & NoteBooks option
And User click on product comparison icon on "MacBook"
And User click on product comparison icon on "MacBook Air"
Then User should see a message ‘Success: You have added "MacBook Air" to your product comparison!’
And User click on Product Comparison link
Then User should see Product Comparison chart


Scenario: Adding an item to Wish list
Given User is on Retail website
When User click on Laptops & NoteBooks tab
And User click on Show all Laptops & NoteBooks option
And User click on heart icon to add "Sony VAIO" laptop to wish list
Then User should get a message ‘You must login or create an account to save "Sony VAIO" to your wish list!’


Scenario: Validate the price of MacBook Pro is 2000
Given User is on Retail website
When User click on Laptops & NoteBooks tab
And User click on Show all Laptops & NoteBooks option
And User clicks on "MacBook Pro" item
Then User should see "$2,000.00" price tag is present on UI.

