#@obstacle
#Feature: everything obstacle related
#
#	Scenario: checking if tiles have obstacles
#		Given len 10 wid 10 playerAmount 4 and diff 2
#		When game started
#		And turn started
#		And players chose their cards
#		And cards are being executed
#		Then obstacles are generated on tiles
#		
#	Scenario: barrel
#		Given len 10 wid 10 playerAmount 4 and diff 2
#		When game started
#		And a barrel tile
#		And turn started
#		And players chose their cards
#		And cards are being executed
#		Then robot should not move into the barrel
#		
#	Scenario: pit
#		Given len 10 wid 10 playerAmount 4 and diff 2
#		When game started
#		And a pit tile
#		And turn started
#		And player chose his cards
#		And cards are being executed
#		Then robot should die
#	
#	Scenario: health
#		Given len 10 wid 10 playerAmount 4 and diff 2
#		When game started
#		And a health tile
#		And turn started
#		And player chose his cards
#		And cards are being executed
#		Then robots life should go up
#		
#	Scenario: gearR
#		Given len 10 wid 10 playerAmount 4 and diff 2
#		When game started
#		And a gear right tile
#		And turn started
#		And player chose his cards
#		And cards are being executed
#		Then robot turns right
#		
#	Scenario: gearL
#		Given len 10 wid 10 playerAmount 4 and diff 2
#		When game started
#		And a gear left tile
#		And turn started
#		And player chose his cards
#		And cards are being executed
#		Then robot turns left
#		
#	Scenario: conveyor1
#		Given len 10 wid 10 playerAmount 4 and diff 2
#		When game started
#		And a conveyor1 tile
#		And turn started
#		And player chose his cards
#		And cards are being executed
#		Then robot moves1
#		
#	Scenario: conveyor2
#		Given len 10 wid 10 playerAmount 4 and diff 2
#		When game started
#		And a conveyor2 tile
#		And turn started
#		And player chose his cards
#		And cards are being executed
#		Then robot moves2
#		
#	Scenario: conveyor3
#		Given len 10 wid 10 playerAmount 4 and diff 2
#		When game started
#		And a conveyor3 tile
#		And turn started
#		And player chose his cards
#		And cards are being executed
#		Then robot moves3
#
#	Scenario: acid
#		Given len 10 wid 10 playerAmount 4 and diff 2
#		When game started
#		And an acid tile
#		And turn started
#		And player chose his cards
#		And cards are being executed
#		Then robot stops moving
