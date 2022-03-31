package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import notdefault.Board;
import notdefault.Tile;
import notdefault.TileType;


public class TileTests {
    private Tile tile;
    private Board board;

    @Given("a tile is created")
    public void a_tile_is_created() {
	tile = new Tile();
    }

    @When("tile is initialized into a random tile")
    public void tiled_is_initialized() {
	tile.init();
    }

    @Then("the tile should one of the tile kinds")
    public void the_tile_should_one_of_the_tile_kinds() {
	assertEquals(tile.getType().getClass(), TileType.class); 
    }  

    @Given("a board of lenght and width {int} and {int}")
    public void a_board_of_lenght_and_width_and(Integer int1, Integer int2) {
	board = new Board(int1,int2);
    }

    @When("center tile is generated")
    public void center_tile_is_generated() {
	board.spawnCheckpoint();
    }

    @Then("it is a checkpoint tile")
    public void it_is_a_checkpoint_tile() {
	assertTrue(board.hasCheckpoint());
    }

}
