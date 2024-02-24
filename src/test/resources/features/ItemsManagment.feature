Feature: Item Management 



	@create_items
	Scenario: As a user, I am able to create an item or service
		Given As a "level1" user, I am loged in
		And I navigate to Items page
		When I click on Add Item button
		Then I should be on New Item page
		When I provide item name "NewItem" price "1200" unit "pc" and description "Just cool coffee mug"
		And I click on Save item button
		Then the item is added the list table
		And  I delete the created item
		
	#@update_items
	#Scenarios: As a user, I am able to update an item or service
		#Given As a "level2" user, I am loged in
		
