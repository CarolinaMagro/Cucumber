@EndToEnd
Feature: Sing Up Page
  Como QA automation I want to sing up a new user


  Background:
    Given The user is on the Demoblaze Page

  @baufest
  Scenario: Sing up a new user
    Given The user opens sing up modal
    When The user write his Username
    And The user write his Password
    And Click into Sing Up
    Then The user is registred
