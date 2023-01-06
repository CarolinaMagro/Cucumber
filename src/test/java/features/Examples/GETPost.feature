@ApiRest
Feature: GET Post


  Background:
    Given I perform authentication operation for "/auth/login" with body
      |email            |password      |
      |seba@email.com   |seba123       |


  @rest
  Scenario: Verify one author of the post
    Given I perform GET operation for "/posts/1"
    Then I should see the author name as "Karthik KK"

  @rest
  Scenario: Verify collection of authors in the post
    Given I perform GET operation for "/posts"
    Then I should see the author names

  @rest
  Scenario: Verify Parameter of Get
    Given I perform GET operation for "/posts"
    Then I should see verify Get parameter


  @rest
  Scenario: Verify GET operation with bearer authentication token
    Given I perform GET operation for "/posts/1"
    Then I should see the author name as "Karthik KK" with json validation
