@regression @Items_Suite
Feature: Item Management 

	Background:
		Given As a "level1" user, I am loged in
		And I navigate to Items page
		
		
		
	@create_items_page @smoke_tests
	Scenario: As a user, I am able to create an item or service		
		When I click on Add Item button
		Then I should be on New Item page
		When I provide item name "NewItem" price "1200" unit "pc" and description "Just cool coffee mug"
		And I click on Save item button		
		And  I delete the created item
		
		
		
	@create_items_page_validating_ItemName @smoke_tests
	Scenario Outline: As a user, I am checking boundry analisys 		
		When I click on Add Item button
		Then I should be on New Item page
		When I provide item name "<NewItem>" price "1300" unit "pc" and description "Just cool coffee mug"
		And I click on Save item button
		Then I validate error messages
		
		Examples:
		|NewItem|
		|  			|
		|CH|
		|CHI|
		|MLCPdZgNTDgiqNQyzLacuJhGGCiDItnFbcvBegjRuvrUIeZEN|
		|AWkywTiZYKeCgqdrJvZXxfprxWljOWgGWwGfrXMIUwQLnhbClk|
		|yPpuuFPFXGFyqvuNqatcNXqzaXkcKyuBGQcXaCiQtOfHZgcbkuK|
		
		
	
	@validate_Items_page_comp
	Scenario: Validate Items page components		
		Then I should be able to see  page titled “Items” and menu navigation path as “Home / Items”
		And there should be two buttons with Filter and + AddItem sign on them
		And table with Select All checkbox, NAME, UNIT, PRICE,ADDED ON
		Then A link icon showing three dots with the following options: Edit with an edit icon, Delete with a delete icon.
		And I should see Pagination navigation with the following controls
		
	@update_items @smoke_tests
	Scenario: Update created Item		
		When I click on Add Item button
		Then I should be on New Item page
		When I provide item name "NewItem" price "1200" unit "pc" and description "Just cool coffee mug"
		And I click on Save item button
		When I update the item price with "1500"
		Then an item is added to the item list table
		And  I delete the created item
		
	@check_if_item_matches_with_saved @smoke_tests
	Scenario: Check if created item exists in the table	
		When I click on Add Item button
		Then I should be on New Item page
		When I provide item name "NewItem" price "1200" unit "pc" and description "Just cool coffee mug"
		And I click on Save item button
		And I should see Success message			
		Then an items "NewItem" price "1200" unit "pc" and description "Just cool coffee mug" should appear in table
		And  I delete the created item	
		
	@delete_Singel_item_Action
	Scenario: Delite single Item using the action button		
		When I click on 1st item checkbox
		And I click on Action button I select delete
		Then I veryfy the Alert text and click ok
	
	@delete_Multiple_item_Action
	Scenario: Delite multiple Item using the action button		
		When I click on all item checkbox
		And I click on Action button I select delete
		Then I veryfy the Alert text and click ok
			
		
