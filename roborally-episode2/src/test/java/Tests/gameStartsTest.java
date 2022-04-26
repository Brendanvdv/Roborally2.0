package Tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rebuild.Board;
import rebuild.GameInstance;
import rebuild.Robot;
import rebuild.Tile;
import rebuild.TyleType;

public class gameStartsTest {
    private GameInstance game;
    private Board board;
    private int length;
    private int width;
    private int playerAmount;
    private int diff;

    @Given("A board of length {int} and width {int} and {int} players and difficulty {int}")
    public void a_board_of_length_and_width_and_players_and_difficulty(Integer int1, Integer int2, Integer int3, Integer int4) {
	length = int1; width = int2; playerAmount = int3; diff = int4;
    }
    @When("Game starts")
    public void game_starts() {
	game = new GameInstance(length,width,playerAmount,diff);
    }
    @Then("make a board of {int} x {int} with {int} robots on it")
    public void make_a_board_of_x_with_robots_on_it(Integer int1, Integer int2, Integer int3) {
	assertArrayEquals(game.getBoardDim(), new int[] {int1,int2});
	assertEquals(game.getRobots().size(), (int) int3);
    }

    @Then("robots are spawned in the corners")
    public void robots_are_spawned_in_the_corners() {
	for (Robot robot : game.getRobots()) {
	    assertTrue(robot.isInCorner());
	}
    }

    @Then("robot {int} direction is set to {int}")
    public void robot_direction_is_set_to(Integer int1, Integer int2) {
	assertEquals(game.getRobots().get(int1 - 1).getDir(),(int) int2);
    }

    @Then("I want the board to be random tiles")
    public void i_want_the_board_to_be_random_tiles() {
	for (Tile[] column : game.getBoard().getTiles()) {
	    for(Tile row : column) {
		assertTrue(row instanceof Tile);
	    }
	}
    }
    
    @Then("spawn obstacles on the board")
    public void spawn_obstacles_on_the_board() {
	for(Tile[] column : game.getBoard().getTiles()) {
	    for(Tile row : column) {
		assertTrue(row.validObstacle());
	    }
	}
    }

    @Then("there should be between {int} and {int} Floor tiles")
    public void there_should_be_between_and_floor_tiles_at_difficulty(Integer int1, Integer int2) {
	
	int average = 0;

	for (int i = 0; i < 100; i++) {
	    board = new Board(length,width,diff);
	    int counter = 0;

	    for (Tile[] column : board.getTiles()) {
		for(Tile row : column) {
		    if(row.getType().equals(TyleType.Floor)) {
			counter++;
		    }
		}
	    }
	    average = average + counter;
	}
	average = average/100;
	
	assertTrue(int1 <= average && average <= int2);
    }

    @Then("there should be a checkpoint in the center")
    public void there_should_be_a_checkpoint_in_the_center() {
	boolean hasCheckpoint = false;
	
	for (Tile[] column : game.getBoard().getTiles()) {
	    for(Tile row : column) {
		if(row.getType().equals(TyleType.Checkpoint)) {
		    hasCheckpoint = true;
		}
	    }
	}
	
	assertTrue(hasCheckpoint);
    }
    
    @Then("that there are no obstacles where the robots are at")
    public void that_there_are_no_obstacles_where_the_robots_are_at() {
	for (int i = 0; i < game.getRobots().size(); i++) {
	    assertTrue(game.getBoard().getTile(game.getRobots().get(i).getCoordinate()).getType().equals(TyleType.Floor));
	}
    }





















}
