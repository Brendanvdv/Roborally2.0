@board
Feature: Board generation
#As a board, when a player starts the game, I gene6rate a 2D array board and initialise it with Tiles

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
  
	@noObstaclesUnderRobots
	Scenario: I want to make sure there are no obstacles under robots
		Given a board 10 by 10 is created and 2 robots are spawned
		When the tiles are generated
		Then i want robots to stand on floor
		
	@difficultyObstacles
	Scenario: I want to make the board harder or simpler
		Given an difficulty level <diff> and dimensions <len> and <wid> and <num> players
		When the board is generated
		Then there are between <low> and <high> floor tiles
		
		Examples:
			| diff | num | len | wid | low | high |
			|  1   |  2  | 10  | 10  | 50  |  60  |
			|  2   |  2  | 10  | 10  | 40  |  50  |
			|  3   |  2  | 10  | 10  | 30  |  40  |
			
	
