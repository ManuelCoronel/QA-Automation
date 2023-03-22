@tag
Feature: select random number

  @tag1
  Scenario: select random number
    Given El usuario debe estar en la pagina de random "numbers page"
		When el usuario selecciona la opcion de tipo de juego e ingresa el numero que adivina
		|tipo|Demo|
		|numero|3|
		Then Se valida  la cadena "correcto"
		