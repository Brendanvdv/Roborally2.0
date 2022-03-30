@tag
Feature: Board generation
As a board, when a player starts the game, I generate a 2D array board

  @tag1
  Scenario: Making a square board
  	Given length and width 10
  	When square board is generated
  	Then make board with size 10
  	
  Scenario: Making a strictly rectangular board
  	Given length 10 and width 20
  	When rectangular board is generated
  	Then make board with size 10 x 20
  
  
    
