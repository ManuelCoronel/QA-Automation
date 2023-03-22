
@tours
Feature: Login in new Tours Page
 

  @tours
  Scenario: Loguin in new  Tours Page with correct credentials
  Given be in "New tours page"
  When insert credentials "mngr480432" and "EtadUdy"
  Then validate message in home with the word "Login Successfully"

