@tag
Feature: Board generation
#As a board, when a player starts the game, I generate a 2D array board and initialise it with Tiles

  @squareBoard
  Scenario: Making a square board
  	Given length and width 10
  	When square board is generated
  	Then make board with size 10
  @rectangularBoard
  Scenario: Making a strictly rectangular board
  	Given length 20 and width 10
  	When rectangular board is generated
  	Then make board with size 20 x 10
  
  @initBoard
  Scenario: Initialize the board with tiles
  	Given a board with length and width 20 and 10
  	When board is initialized
  	Then fill the board with tiles
  
#After the robots are spawned, as a board I want to generate tiles so that the robot is not standing on the obstacle tiles
	@noObstaclesUnderRobots
	Scenario: I want to make sure there are no obstacles under robots
		Given a board 10 by 10 is created and 2 robots are spawned
		When the tiles are generated
		Then i want robots to stand on floor