Feature: Play a game

  Scenario: Players can play a Game
    Given a Table with Players "Kris" and "Guido"
    When "Kris" folds
    Then "Guido" wins

  Scenario: Players can play a full hand
    Given a Table with Players "Kris" and "Guido"
    When "Kris" is dealt "Ace of Hearts" and "King of Clubs"
    And "Guido" is dealt "Ace of Clubs" and "Ace of Spades"
    And "Guido" calls the big blind
    And "Kris" checks
    And the flop is the "Ace of Diamonds", "2 of Diamonds", "3 of Clubs"
    And both players check
    And the turn is "6 of Spades"
    And both players check
    And the river is "10 of Hearts"
    And both players check
    Then "Guido" wins

