package tests;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import notdefault.Board;
import notdefault.Tile;
import notdefault.TileType;


public class BoardTests {

    private int width;
    private int length;
    private Board b;

    @Given("length and width {int}")
    public void length_and_width(Integer int1) {
	this.width = int1;
	this.length = int1;
    }
    @When("square board is generated")
    public void square_board_is_generated() {
	b = new Board(width, length);
    }

    @Then("make board with size {int}")
    public void make_board_with_size_x(Integer int1) {
	assertArrayEquals(b.getSize(), new int[] {int1, int1});
    }

    @Given("length {int} and width {int}")
    public void length_and_width(Integer int1, Integer int2) {
	this.width = int1;
	this.length = int2;
    }
    @When("rectangular board is generated")
    public void rectangular_board_is_generated() {
	b = new Board(width, length);
    }

    @Then("make board with size {int} x {int}")
    public void make_board_with_size_x(Integer int1, Integer int2) {
	assertArrayEquals(b.getSize(), new int[] {int1,int2});
    }

    @Given("a board with length and width {int} and {int}")
    public void a_board_with_length_and_width_and(Integer int1, Integer int2) {
	b = new Board(int1, int2);
    }

    @When("board is initialized")
    public void board_is_initialized() {
	b.init();
    }

    @Then("fill the board with tiles")
    public void fill_the_board_with_tiles() {
	for (int i = 0; i < b.getSize()[0]; i++) {
	    for (int j = 0; j < b.getSize()[1]; j++) {
		assertTrue(b.getTile(i,j) instanceof Tile);
	    }
	}
    }
    
    @Given("a board {int} by {int} is created and {int} robots are spawned")
    public void a_board_by_is_created_and_robots_are_spawned(Integer int1, Integer int2, Integer int3) {
        b = new Board(int1,int2);
        b.spawnRobot(int3);
    }

    @When("the tiles are generated")
    public void the_tiles_are_generated() {
        b.robotCorners();
    }

    @Then("i want robots to stand on floor")
    public void i_want_robots_to_stand_on_floor() {
	for (int i = 0; i < b.getRobots().size(); i++) {
	    assertEquals(b.getTile(b.getRobots().get(i).getXY()[0],b.getRobots().get(i).getXY()[1]).getType(),TileType.Floor);
	}
    }
}
