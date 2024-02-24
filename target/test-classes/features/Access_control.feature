Feature: Access control user mnagment
					Use casses for app access control
					
					
				@valid_login	
		Scenario: As a user I should be able to login
			Given I am on the login page
			And Login page components exists
			When I enter valid username and valid password
			And I click on login button
			Then I should be on the Dashboard page
			And sucess message displays
		
				@valid_login_variable
		Scenario: As a user I should be able to login
			Given I am on the login page
			And Login page components exists
			When I enter valid username and valid password
			And I click on login button
			Then I should be on the " Dashboard" page
			And "Success!" message displays
			
				@invalid_login
		Scenario Outline: As a User I should not be able to login
			Given I am on the login page 
			And Login page components exists
			When I enter invalid "<username>" and invalid "<password>"
			And I click on login button
			Then I should not be loged in
			
			Examples:
			|username										| password			 |
			|dummy@primetechschool.com  | fakePass       |
			|fake@prime.com							|primetech@school|
			|dummy@primetechschool.com  |					       |
			|														|primetech@school|
			|fake@primhool.com					|								 |
			|														|tech@school		 |
			|														|								 |
				
			