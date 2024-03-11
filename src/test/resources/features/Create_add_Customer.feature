@regression
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
	Scenario: As user I should be able to use Portal acces function
		Given user is in New Customer page and can fill 
		I 
	
@add_Customer_UI_comp
	Scenario Outline: As a user I can fill out New Customer page
		Then I should be directed to the page to validate Basic Info UI components
		And I click to +NewCustomer button
		And Validate Basic informatio address UI components with "<Name_val>", "<Email>" "<zip>" "<phone>" "<Primary_Contact>"
		Then Validate Shipping and Billing address UI components "<Name_val>", "<Address_ST>" "<zip>" "<phone>" 
		
Examples:
|Name_val|Email|zip 	|phone|Primary_Contact|Address_ST	|
|		0		 |	0	 |	0		|		0	|				0				|			0		 	|
|		1		 |	1	 |	1		|		1	|				2				|			1			|
|		2		 |	3	 |	2		|		2	|				3				|			2			|
|		49	 |124	 |	4		|	9		|				49			|			99		|
|		50	 |125	 |	5		|	10  |			50				|			100 	|
|		51	 |126	 |	6		|	11	|			51				|		101			|



@validate_customer_data_saved
	Scenario Outline: As a user I can fill out New Customer page
		Then I should be directed to the page to validate Basic Info UI components
		And I click to +NewCustomer button
		And Validate Basic informatio address UI components with "<Name_val>", "<Email>" "<zip>" "<phone>" "<Primary_Contact>"
		Then Validate Shipping and Billing address UI components "<Name_val>", "<Address_ST>" "<zip>" "<phone>"
		And As user I should be navigated to Sales page
		Then User should see entered data and Success message
		And  User data can be viewd using filter
		
		
		
		