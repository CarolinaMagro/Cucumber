@EndToEnd
Feature: Index Page (Log Out)
  As a user I want to Log Out


  Background:
    Given The user is on the Demoblaze Page

  @baufest
  Scenario: Log out a user
    Given The user opens Log in modal
    When The user write the Username
    And The user write the Password
    And Click into Log in
    And The user is loged
    And Click log out
    Then The user is loged out