@gameStarts
Feature: game starts

	@gameStart
	Scenario: make tiles
		Given A board of length 10 and width 10 and 4 players and difficulty 1
		When Game starts
		Then I want the board to be random tiles
		And there should be a checkpoint in the center
		
	Scenario: spawn robots
		Given A board of length 10 and width 10 and 4 players and difficulty 1
		When Game starts
		Then robots are spawned in the corners
		And that there are no obstacles where the robots are at
	
	Scenario: check the board dimensions
		Given A board of length <len> and width <wid> and 4 players and difficulty 1
		When Game starts
		Then make a board of <len> x <wid> with 4 robots on it
		
		Examples:
		| len  | wid |
		|  10  | 10  |
		|  11  | 10  |
		|  11  | 11  |
		|  10  | 11  |
		
	Scenario: check different difficulties
		Given A board of length 10 and width 10 and 4 players and difficulty <dif>
		When Game starts
		Then there should be between <low> and <high> Floor tiles
		
		Examples:
		| dif | low | high|
		|  1  | 50  |  60 |
		|  2  | 40  |  50 |
		|  3  | 30  |  40 |
		
	Scenario: check different directions
		Given A board of length 10 and width 10 and 4 players and difficulty 1
		When Game starts
		Then robot <num> direction is set to <dir>
		
		Examples:
		| num | dir |
		|  1  |  1  |
		|  2  |  2  |
		|  3  |  3  |
		|  4  |  0  |



