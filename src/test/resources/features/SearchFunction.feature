
@Parallel
Feature: Case 3

  Background:
    Given the user is on the Base page
    And the user should be able to login
    #And page title has to match this title "GetirYemek - Yemek siparişi artık Getir farkıyla!"


  Scenario Outline: check the search
    When the user enters search item '<searchItem>' int the search button
    Then all the results has to be related with search item

    Examples:
      | searchItem |
      | pizza      |
      | lahmacun    |
      | kebap      |
