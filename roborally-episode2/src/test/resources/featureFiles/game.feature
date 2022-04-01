@game
Feature: Game starting

	@takeInputAndStart
	Scenario: game starts generate a board and robots
		Given A board of length 10 and width 10 and 3 players
		When Game starts
		Then make a board of 10 x 10 with 3 robots on it
		
	@makingActionCards
	Scenario: when a player's turn starts generate 9 Action Cards
		Given Player turn starts true 
		When Game starts the player's turn
		Then Generate 9 Action Cards
