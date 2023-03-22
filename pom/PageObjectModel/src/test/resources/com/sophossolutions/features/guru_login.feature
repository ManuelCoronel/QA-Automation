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
Feature: Login into guru page
  

  @tag1
  Scenario: login with correct user and password in guru 
    Given El usuario debe estar en la pagina guru <url>
		When ingresa credenciales en guru con usuario <user> y la password <password> 
		Then Se valida  la cadena en el home de guru <cadenaValidacion>
		
		Examples:
		|url|user|password|cadenaValidacion|
		|"https://demo.guru99.com/V4/"|"mngr480432"|"EtadUdy"|"Manger Id : mngr480432"|


