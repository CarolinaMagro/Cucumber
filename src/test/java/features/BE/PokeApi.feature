Feature: Pokemon

  @API2
  Scenario: Verify pokemon
    Given I perform post operation for "/pikachu"

    Then I should see the pokemon as "pikachu"

