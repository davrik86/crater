@regression
Feature: Item Management 



	@create_items @smoke_tests
	Scenario: As a user, I am able to create an item or service
		Given As a "level1" user, I am loged in
		And I navigate to Items page
		When I click on Add Item button
		Then I should be on New Item page
		When I provide item name "NewItem" price "1200" unit "pc" and description "Just cool coffee mug"
		And I click on Save item button
		Then The item is added to the item list table
		And  I delete the created item
		
	@update_items @smoke_tests
	Scenario: As a user, I am able to create an item or service
		Given As a "level1" user, I am loged in
		And I navigate to Items page
		When I click on Add Item button
		Then I should be on New Item page
		When I provide item name "NewItem" price "1200" unit "pc" and description "Just cool coffee mug"
		And I click on Save item button
		Then The item is added to the item list table
		When I update the item price with "1500"
		Then The item is added to the item list table
		And  I delete the created item
