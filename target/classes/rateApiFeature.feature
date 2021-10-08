Feature: Exchange Rates of different currencies  in different scenarios.



Scenario: Get API response for Latest Foreign Exchange rates 

	Given Rates API for latest foreign exchange rate 
	
	Then Receive success HTTP response success 200
	
	And Receive exchange rates as response 
	
	
	
Scenario: Checking response of API, when incorrect url passed 

	Given Incorrect rates API url for Latest Foreign Exchange rates 
	
	Then I receive requested service point not exist HTTP response 401 
	
	
	
Scenario: Get Foreign Exchange Rates API for historic date 

	Given Rates API for specific historic date foreign exchange rate 
	
	Then Receive success HTTP response success 200 
	
	And Receive exchange rates as response 
	
	
	
Scenario: Get Foreign Exchange Rates API for Future date 

	Given Rates API for Future date foreign exchange rate 
	
	Then Receive Bad request error 400  for future date foreign exchange rate
	
