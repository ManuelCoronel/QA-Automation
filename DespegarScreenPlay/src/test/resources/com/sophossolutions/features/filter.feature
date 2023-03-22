
@tag
Feature: Filter flights
  
	Background:
    Given i am in the page 'despegar'
		When i select a day to fly and day to return
  
  Scenario: Filter by the lowest price
    When i filter by lowest price

