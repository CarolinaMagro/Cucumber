Feature: Verify different GET operations using REST-assured

  @rest
  Scenario: Verify one author of the post
    Given I perform GET operation for "/posts"
    And I perform GET for the post number "1"
    Then I should see the author name as "Karthik KK"

  @rest
  Scenario: Verify collection of authors in the post
    Given I perform GET operation for "/posts"
    Then I should see the author names

  @rest
  Scenario: Verify Parameter of Get
    Given I perform GET operation for "/posts"
    Then I should see verify Get parameter
