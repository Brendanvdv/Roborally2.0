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
Feature: Tile
#As a tile, when I am created I want to randomly be assigned a different kind of tile like an obstacle or something
  @creatingATile
  #Scenario: Generating a tile
    #Given a tile is created
    #When tile is initialized into a random tile
    #Then the tile should one of the tile kinds

#As a board, After the board is initialized I want to spawn a checkpoint in the centre
	@spawningACheckpoint
	Scenario: Genearate a checkpoint in the dead center of the board
		Given a board of lenght and width <int1> and <int2>
		When center tile is generated
		Then it is a checkpoint tile
		
		Examples:
		| int1 | int2 |
		|  10  |  10  |
		|  11  |  10  |
		|  10  |  11  |
		|  11  |  11  |

		
		
		
		