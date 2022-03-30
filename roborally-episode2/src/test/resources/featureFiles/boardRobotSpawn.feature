@robotSpawn
Feature: Robot spawning
As a board, when a player starts the game, I generate robots

	@2robotsSpawned
  Scenario: spawn two robots
  	Given Two 2 players
  	When board spawns two robots
  	Then robots are in opposite corners
   	And one robot per corner in two corners
  @3robotsSpawned
  Scenario: spawn three robots
    Given Three 3 players
  	When board spawns three robots
  	Then robots are in corners
  	And one robot per corner in three corners
  @4robotsSpawned
  Scenario: spawn four robots
    Given Four 4 players
  	When board spawns four robots
  	Then robots are in all corners
  
