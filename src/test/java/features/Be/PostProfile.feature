Feature: Post


  Background:
    Given I perform authentication operation for "/auth/login" with body
      |email            |password      |
      |seba@email.com   |seba123       |

  @rest
  Scenario: Verify Post operation for Profile
    Given I perform POST operation for "/posts/{profileNo}/profile" with body
    |name|profile|
    |Sams|2      |
    Then I should the body has name as "Sams"
