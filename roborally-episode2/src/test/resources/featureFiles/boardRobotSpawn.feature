@robotSpawn
Feature: Robot spawning
As a board, when a player starts the game, I generate robots

	@robotsSpawning
  Scenario: spawn two robots
  	Given 2 players
  	When board spawns robots
  	Then robots are in opposite corners
   	And one robot per corner

  Scenario: spawn three robots
  	Given 3 players
  	When board spawns robots
  	Then robots are in corners
   	And one robot per corner
   	
  Scenario: spawn four robots
  	Given 4 players
  	When board spawns robots
  	Then robots are in all corners
  	
  @robotsDirection
  Scenario: direction of robots
    Given a corner <c>
    When 1 robot is spawned
    Then the directions must point to <dir>

    Examples:
		| c | dir |
		| 0 |  2  | #2
		| 3 |  3  | #3
		| 2 |  0  | #0
		| 1 |  1  | #1
  