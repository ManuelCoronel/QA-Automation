#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login in new tours

  @tag1
  Scenario: login with correct user and password
    Given El usuario debe estar en la pagina de guru tours <url>
		When ingresa credenciales  en guru tours con usuario <user> y la password <password> 
		Then Se valida  la cadena en el home de guru tours  <cadenaValidacion>
		
		Examples:
		|url|user|password|cadenaValidacion|
		|"https://demo.guru99.com/test/newtours/"|"mngr480432"|"EtadUdy"|"Login Successfully"|

