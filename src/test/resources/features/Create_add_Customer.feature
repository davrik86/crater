@regression @customerSuite
Feature:

Background:
		Given As a "level1" user, I am loged in
		And I click on Customers page and navigate to page

@create_Customers_page @smoke_tests	
	Scenario: As a user I can validate the Customers Page UI components
		Then I validate reqiered Customers Page UI components
		And I should see Pagination navigation with the following controls
	# Table, 3dot, Filter, New Customer 

@portal_Access
	Scenario Outline: As user I should be able to use Portal acces function
		And I click to +NewCustomer button
		And I click toggle button to validate all components
	#	Then I would validate "<Password>" tabs and errors
	
	Examples:	
		|Password|
		| |
		|abcdefg|
		|abcdefghigk|
	
@add_Customer_UI_comp
	Scenario Outline: As a user I can fill out New Customer page
		Then I validate reqiered Customers Page UI components
		And I click to +NewCustomer button
		And Validate Basic informatio address UI components with "<Name_val>" "<Email>" "<zip>" "<phone>" "<Primary_Contact>"
		
		Then Validate Shipping and Billing address UI components "<Name_val>" "<Address_ST>" "<zip>" "<phone>" 

Examples:
|Name_val|Email|zip 	|phone|Primary_Contact|Address_ST	| 
|		0		 |	0	 |	0		|		0	|				0				|			0		 	|
|		1		 |	1	 |	1		|		1	|				2				|			1			|
|		2		 |	3	 |	2		|		2	|				3				|			2			|
|		49	 |124	 |	4		|	9		|				49			|			99		|
|		50	 |125	 |	5		|	10  |			50				|			100 	|
|		51	 |126	 |	6		|	11	|			51				|		101			|


		

@validate_customer_data_saved
	Scenario: As a user I can check if entered data is saved
		Then I validate reqiered Customers Page UI components
		And I click to +NewCustomer button
		And I enter the following "DisName", "Primary_con" "zip" "phone" "Email" "Website" "Billing" "Shipping"	and hit the save button 	
		Then I validate entered data is saved and Success message 
		
		
		







		
		