@obstacle
Feature: everything obstacle related

	Scenario: checking if tiles have obstacles
		Given len 10 wid 10 playerAmount 4 and diff 2
		When game started
		And turn started
		And players chose their cards
		And cards are being executed
		Then obstacles are generated on tiles
		
	Scenario: barrel
		Given len 10 wid 10 playerAmount 4 and diff 2
		When game started
		And a barrel tile
		And turn started
		And players chose their cards
		And cards are being executed
		Then robot should not move into the barrel
		
	Scenario: pit
		Given len 10 wid 10 playerAmount 4 and diff 2
		When game started
		And a pit tile
		And turn started
		And players chose their cards
		And cards are being executed
		Then robot should die
	
	Scenario: health
		Given len 10 wid 10 playerAmount 4 and diff 2
		When game started
		And a health tile
		And turn started
		And players chose their cards
		And cards are being executed
		Then robots life should go up
		
	Scenario: gear
		Given len 10 wid 10 playerAmount 4 and diff 2
		When game started
		And a gear tile
		And turn started
		And players chose their cards
		And cards are being executed
		Then robot turns
		
	Scenario: conveyor
		Given len 10 wid 10 playerAmount 4 and diff 2
		When game started
		And a conveyor tile
		And turn started
		And players chose their cards
		And cards are being executed
		Then robot moves

	Scenario: acid
		Given len 10 wid 10 playerAmount 4 and diff 2
		When game started
		And an acid tile
		And turn started
		And players chose their cards
		And cards are being executed
		Then robot stops moving
