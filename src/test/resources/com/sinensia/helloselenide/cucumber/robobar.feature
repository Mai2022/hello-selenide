Feature: Robobar cart

  Scenario: user add one cola
    Given user opens robobar website
    When user adds a cola
    Then total should be €1.25

  Scenario: user add two colas
    Given user opens robobar website
    When user adds a cola
    And user adds a cola
    Then total should be €2.50

  Scenario: user add one beer
    Given user opens robobar website
    When user adds a beer
    Then total should be €2.00

  Scenario: user add two beers
    Given user opens robobar website
    When user adds a beer
    And user adds a beer
    Then total should be €4.00

  Scenario: user add one wine
    Given user opens robobar website
    When user adds a wine
    Then total should be €3.00

  Scenario: user add two wines
    Given user opens robobar website
    When user adds a wine
    And user adds a wine
    Then total should be €6.00

  Scenario: user add one cola and one beer
    Given user opens robobar website
    When user adds a cola
    And user adds a beer
    Then total should be €3.25

  Scenario: user add and cola and one beer and one wine
    Given user opens robobar website
    When user adds a cola
    And user adds a beer
    And user adds a wine
    Then total should be €6.25


  Scenario Outline: user buy several drinks
    Given user opens robobar website
    When user adds <cola> cola <beer> beer <wine> wine
    Then total should be €<total>
    Examples:
      | cola | beer | wine | total |
      | 1    | 0    | 0    | 1.25  |

  Scenario: underage buys cola
    Given user opens robobar website
    When user adds a cola
    And user checkout
    And user order
    Then message should be "Coming right up! ~bzzzt~"

  Scenario: underage buys beer
    Given user opens robobar website
    When user adds a beer
    And user checkout
    And user inputs age "17"
    And user order
    Then alert should appear

  Scenario: adult buys beer
    Given user opens robobar website
    When user adds a beer
    And user checkout
    And user inputs age "19"
    And user order
    Then message should be "Coming right up! ~bzzzt~"