Feature: PUTPost
    Verify put post operation


  Background:
    Given I perform authentication operation for "/auth/login" with body
      |email            |password      |
      |seba@email.com   |seba123       |


  @rest
  Scenario: Verify PUT operation after POST
    Given I ensure to perform POST operation for "/posts" with body as
    |id   |title               |author           |
    |6    |API Testing course  |ExecuteAutomation|
    And I  Perform PUT operation  for "/posts/{postid}/"
    |id   |title               |author           |
    |6    |API Testing course  |ExecuteAutomation|
    And I perform GET operation with path parameter for "/posts/{postid}/"
    |postid|
    |6     |
    Then I "should" see the body with title as "API Testing course"
