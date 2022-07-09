Feature: Play a game

  Scenario: Players can play a Game
    Given a Table with Players "Kris" and "Guido"
    When "Kris" folds
    Then "Guido" wins

