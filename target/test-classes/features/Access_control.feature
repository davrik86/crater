@regression
Feature: Access control user mnagment
					Use casses for app access control
					
		
			
					
				@valid_login	@smoke_tests 
		Scenario: As a user I should be able to login
			Given I am on the login page
			And Login page components exists
			When I enter valid username and valid password
			And I click on login button
			Then I should be on the Dashboard page
			And sucess message displays
					
				@valid_login_variable @smoke 
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
			
			@invalid_login_WithBLNK 
		Scenario Outline: As a User I should not be able to login
			Given I am on the login page 
			And Login page components exists
			When I enter invalid "<username>" and invalid "<password>" including blank option
			And I click on login button
			Then I should not be loged in(using blank)
			
			Examples:
			|username										| password			 |
			|dummy@primetechschool.com  |					       |
			|														|primetech@school|
			|fake@primhool.com					|								 |
			|														|tech@school		 |
			|														|								 |
				
			
			@Login_resetPass_EmailVal
			Scenario Outline: As a User I should not be able to login
			Given I am on the login page 
		  And Login page components exists
			When I click on Forget Password? link 
			And enter an invalid "<email>" I should see the  Errormessage
		#	When I click with leaving the email as blank I should see the Errormessage
		#	When I enter "valid email" and click Reset link button
		#	Then I should recive an email with following "context"
		
			Examples:
			|email								|
			|nonevalid@whoknowscom|								
			|nonevalidwhoknows.com|									
			|											|
			
		
		
			
		#	@Login_resetPass
		#	Scenario Outline: As a User I should not be able to login
		#	Given I am on the login page 
		#	And Login page components exists
		#	When I click on Forget Password? link 
		#	And I enter valid email and click Send reset link
		#	When I recive an email with reset link, I clik on it
			
			
			
			