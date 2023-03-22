
Feature: Find flight
  

  Scenario: Find flight with correct days
    Given i am in the page 'despegar'
		When i select a day to fly and day to return
		Then show me the page of airlines enable
