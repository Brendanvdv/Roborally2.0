@turnStarts
Feature: Turn starts

	@turnStart
	Scenario: turn starts for a player
		Given Game started
		When turn starts
		Then generate action cards
		And there should be at least 3 movement cards
		
	Scenario: chosing cards
		Given Game started
		When turn starts
		And I chose four cards
		Then I want to have four action cards in my hand
		
	Scenario: exectuing moves
		Given Game started
		When turn starts
		And I chose four cards
		And the game executes the moves
		Then player moves
		
	Scenario: checking if the move is valid 
		Given a robot at <x> and <y> looking at <dir> movement Action Card of <mag> magnitude
		When check card
		Then robots move is <status>
		
		Examples: #board for this example is 10 x 10
		| x | y | dir | mag | status |
		| 9 | 9 |  1  |  1  |  0     |
		| 2 | 2 |  2  |  1  |  1     |
		| 0 | 0 |  3  |  1  |  0     |
		| 2 | 2 |  0  |  1  |  1     |
		| 2 | 2 |  1  |  2  |  1     |
		| 8 | 8 |  2  |  2  |  0     |
		| 2 | 2 |  3  |  2  |  1     |
		| 2 | 2 |  0  |  2  |  1     |
		| 2 | 2 |  1  |  3  |  1     |
		| 2 | 2 |  2  |  3  |  1     |
		| 2 | 2 |  3  |  3  |  0     |
		| 2 | 2 |  0  |  3  |  0     |
		
	Scenario: executing movement action card
		Given Game started
		And a robot at <x> and <y> looking at <dir> movement Action Card
		When executing a card
		Then robot moves accordingly to <newx> and <newy> looking at <dir>
		
		Examples:
		| x | y | dir | newx | newy |
		| 5 | 5 |  1  |  6   |  5   |
		| 5 | 5 |  2  |  5   |  6   |
		| 5 | 5 |  3  |  4   |  5   |
		| 5 | 5 |  0  |  5   |  4   |
		
	Scenario: executing rotation action card
		Given a robot at 5 and 5 looking at <dir> rotation <rot> Action Card
		When executing a card
		Then Robot should look at <ndir> direction
		
		Examples:
		| dir | ndir | rot |
		|  1  |   0  | 111 | #left
		|  1  |   2  | 222 | #right
		|  1  |   3  | 333 | #uTurn
		
	Scenario: player dies
		Given Game started
		When turn starts
		And I chose four cards
		And robot runs out of lives
		And the game executes the moves
		Then player is removed from the game
