
@guru
Feature: login in Guru page

  @guru
  Scenario: Login in Guru with correct user and password
    Given be in the page "Guru Page Login"
    When insert credentials in guru with "mngr480432" and "EtadUdy"
    Then validate the home with the word "Manger Id : mngr480432"
