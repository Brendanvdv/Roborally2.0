#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Game Starts
  	Given <p> players and difficulty of <d>
  	When Game starts
  	Then A game is created
  	And A board is generated
  	And The board has right dimensions
  	And Is made up of tiles
  	And Tiles have types
  	And Tiles have obstacles on them
  	And Obstacles have types
  	And Players are made
  	And Robots are spawned
		
		Examples:
			| p | d |
			| 4 | 1 |
			| 4 | 2 |
			| 4 | 3 |
			
	@tag2
  Scenario: Turn Starts
  	Given <p> players and difficulty of <d>
  	When Game starts
  	And Turn starts
  	Then Players have action cards
  	And No player is affected by acid
  	
  	
  	Examples:
			| p | d |
			| 2 | 1 |
			| 3 | 1 |
			| 4 | 1 |
			
	@tag3
  Scenario: Exec
  	Given 4 players and difficulty of 1
  	When Game starts
  	And Turn starts
  	And Players selected their cards
  	And Another set
  	And Moves are executed
  	Then The tile where robot was is unset
  	And Check whether a player won
  	And A new tile is set
  	And If a players robot is dead he is eliminated
		
	@tag4
  Scenario: Pit
  	Given 4 players and difficulty of 1
  	And An Obstacle tile Pit
  	When Game starts
  	When Robot steps on an obstacle tile
  	Then Robot interacts with the Pit

	@tag5
  Scenario: GearL
  	Given 4 players and difficulty of 1
  	And An Obstacle tile GearL
  	When Game starts
  	When Robot steps on an obstacle tile
  	Then Robot interacts with the GearL
  	
  @tag6
  Scenario: GearR
  	Given 4 players and difficulty of 1
  	And An Obstacle tile GearR
  	When Game starts
  	When Robot steps on an obstacle tile
  	Then Robot interacts with the GearR
	
	@tag7
  Scenario: Conveyor N
  	Given 4 players and difficulty of 1
  	And An Obstacle tile ConveyorN
  	When Game starts
  	When Robot steps on an obstacle tile
  	Then Robot interacts with the ConveyorN
  	
 	@tag8
  Scenario: Conveyor S
  	Given 4 players and difficulty of 1
  	And An Obstacle tile ConveyorS
  	When Game starts
  	When Robot steps on an obstacle tile
  	Then Robot interacts with the ConveyorS
  	
  @tag9
  Scenario: Conveyor W
  	Given 4 players and difficulty of 1
  	And An Obstacle tile ConveyorW
  	When Game starts
  	When Robot steps on an obstacle tile
  	Then Robot interacts with the ConveyorW
  	
 	@tag10
  Scenario: Conveyor E
  	Given 4 players and difficulty of 1
  	And An Obstacle tile ConveyorE
  	When Game starts
  	When Robot steps on an obstacle tile
  	Then Robot interacts with the ConveyorE
  	
	@tag11
  Scenario: Barrel
  	Given 4 players and difficulty of 1
  	And An Obstacle tile Barrel
  	When Game starts
  	When Robot steps on an obstacle tile
  	Then Robot interacts with the Barrel
  
  @tag12
  Scenario: Acid
  	Given 4 players and difficulty of 1
  	And An Obstacle tile Acid
  	When Game starts
  	When Robot steps on an obstacle tile
  	Then Robot interacts with the Acid
  
  @tag13
  Scenario: Checkpoint
  	Given 4 players and difficulty of 1
  	And An Obstacle tile Checkpoint
  	When Game starts
  	When Robot steps on an obstacle tile
  	Then Robot interacts with the Checkpoint
			
			
			
			
			
			
			
			