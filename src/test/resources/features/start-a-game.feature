Feature: Start a game

  Scenario: Player can join a Table
    Given an empty Table
    When a person named "Kris" joins the Table
    Then only a person named "Kris" is present at the Table
    And the game has not started yet

  Scenario: Two players can start a game
    Given an empty Table
    When a person named "Kris" joins the Table
    And a person named "Guido" joins the Table
    And "Guido" deals the cards
    Then the game is started

