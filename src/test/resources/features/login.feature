
@Parallel
Feature: Case 1


  Scenario: Automate the lobin page
    Given the user is on the Base page
    When the user clicks the "Giriş yap" button
    And the user clicks the getir password button
    And the user enters  a valid phoneNumber
    And the user enters the valid password
    And the user clicks the submit button
    Then page title has to match this title "Restoranlar | GetirYemek"