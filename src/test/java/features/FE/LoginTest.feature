@EndToEnd
Feature: Log in Page
  As a user I want to Log In


  Background:
    Given The user is on the Demoblaze Page

  @baufest
  Scenario: Log In a user
    Given The user opens Log in modal
    When The user write the Username
    And The user write the Password
    And Click into Log in
    Then The user is loged

