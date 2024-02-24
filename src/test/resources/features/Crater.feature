Feature: Crater items functionality
	@CraterAddItem
	Scenario: As a user, I am able to create an item or a service
		Given As an entity user, I am logged in
		And I navigate to Items tab
		When I click on the Add Item button
		Then I should be on item input page
		When I provide item information name "itemName", price "1800", unit "pc", and description "a good book"
		And I click Save Item button 
		Then The Item is added to the Item list table
		And I delete the item
	@CratorUpdateItem
	Scenario: As a user, I am able to update an item or a service
		Given As an entity user, I am logged in
		And I navigate to Items tab
		When I select the item "Books"
		And I should be on item details page
		When I update the item price to 30 dollars
		And I click Update Item button 
		Then The Item price is updated to 30 dollars
		And I delete the item