
@Parallel
Feature: Case 4

  Background:
    Given the user is on the Base page
    And the user should be able to login
  @wip
  Scenario: take some product to the packet
    Given the user clicks one of the restroant
    And the user add a product to the packet
    When check the product on the packet
    And thue user remove the product from packet
    Then chek the packet is empity