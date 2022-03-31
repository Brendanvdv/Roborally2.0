@tile
Feature: Tile
#As a tile, when I am created I want to randomly be assigned a different kind of tile like an obstacle or something
  @creatingATile
  Scenario: Generating a tile
    Given a tile is created
    When tile is initialized into a random tile
    Then the tile should one of the tile kinds

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

		
		
		
		