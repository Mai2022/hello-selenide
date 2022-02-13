Feature: Robobar age checks

  Background: User has already placed alcoholic beverages in her cart

  Rule: Underage users can not buy alcohol

    Scenario Outline: minor tries to buy alcohol
      Given user is ready to check out with alcohol
      When user is <age> years old
      Then robobar does not allow checkout
      Examples:
        | age |
        | 15  |
        | 16  |
        | 17  |

    Scenario Outline: adult tries to buy alcohol
      Given user is ready to check out with alcohol
      When user is <age> years old
      Then robobar confirms order
      Examples:
        | age |
        | 18  |
        | 19  |
        | 20  |