@regression @Access_Control_Suite
Feature: Access control user mnagment
					Use casses for app access control
					
		Background:
			Given I am on the login page
			And Login page components exists
					
				@valid_login	@smoke_tests 
		Scenario: As a user I should be able to login			
			When I enter valid username and valid password
			And I click on login button
			Then I should be on the Dashboard page
			And sucess message displays
					
				@valid_login_variable @smoke_tests 
		Scenario: As a user I should be able to login			
			When I enter valid username and valid password
			And I click on login button
			Then I should be on the " Dashboard" page
			And "Success!" message displays
			
				@invalid_login 
		Scenario Outline: As a User I should not be able to login			
			When I enter invalid "<username>" and invalid "<password>"
			And I click on login button
			Then I should not be loged in
			
			Examples:
			|username										| password			 |
			|dummy@primetechschool.com  | fakePass       |
			|fake@prime.com							|primetech@school|
			|														|								 |
			|														|primetech@school|
			|fake@primhool.com					|								 |
			|														|tech@school		 |
			
			
							
			
		@Login_resetPass_EmailVal
			Scenario Outline: Forgot Password validation		 
			 When I click on Forget Password? link 
			 And enter an invalid "<email>" I should see the  Errormessage
			# When I enter "valid email" and click Reset link button
		  # Then I should recive an email with following "context"
		
			Examples:
			|email								|
			|nonevalid@whoknowscom|								
			|nonevalidwhoknows.com|									
			|											|
			
		
		
			
		
			
			
			
			