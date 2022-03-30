@tag
Feature: Robot spawning
As a board, when a player starts the game, I generate robots

  @tag1
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
  
