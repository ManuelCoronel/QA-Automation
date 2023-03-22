@tag
Feature: Save flight

  Background: 
    Given El usuario debe estar en la pagina de guru tours "https://demo.guru99.com/test/newtours/"
		When ingresa credenciales  en guru tours con usuario "mngr480432" y la password "EtadUdy" 
		Then Se valida  la cadena en el home de guru tours  "Login Successfully"
		

  @tag1
  Scenario: save correct flight
    Given be in the page flight "New Tours Flight Page"
    When select fligth with the parameters
      | type           | oneway           |
      | number         |                3 |
      | departingFrom  | London           |
      | departingMonth | December         |
      | departingDay   |               13 |
      | arrivePlace    | Paris            |
      | arriveMonth    | October          |
      | arriveDay      |               15 |
      | serviceClass   | Business         |
      | Airline        | Unified Airlines |
    Then validate the reservation with the text "After flight finder - No Seats Avaialble  "
