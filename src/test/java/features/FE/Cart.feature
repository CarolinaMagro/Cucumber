@EndToEnd
Feature: Cart Page
  As a user I want to Log In


  Background:
    Given The user is on the Demoblaze Page

  @baufest
  Scenario: Add a item into the cart
    Given The user opens Log in modal
    When The user write the Username
    And The user write the Password
    And Click into Log in
    And The user is loged
    And Select a item
    And Add to cart item
    Then The item is on the cart

