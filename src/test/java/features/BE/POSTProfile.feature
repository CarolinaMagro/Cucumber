Feature: Verify different GET operations using REST-assured

  @rest
  Scenario: Verify Post operation for Profile
    Given I perform POST operation for "/posts/{profileNo}/profile" with body
    |name|profile|
    |Sams|2      |
    Then I should the body has name as "Sams"
