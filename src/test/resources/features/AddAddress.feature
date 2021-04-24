@Parallel
Feature: Case 2

  Background:
    Given the user is on the Base page
    And the user should be able to login
   #And page title has to match this title "GetirYemek - Yemek siparişi artık Getir farkıyla!"

  Scenario: Add new address
    Given the user click his profile
    And the user choose a dropdown "Adreslerim" from the list
    And page title has to match this title "Adreslerim | GetirYemek"
    And the user should be able to create a new address from adderess type "Ev adresi"
    Then the user should be able to create a new address

      |Adres|Düzgün Sokak|
      |Bina |10          |
      |Kat  |3           |
      |Daire|10          |
