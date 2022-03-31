package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import notdefault.Board;

public class BoardRobotSpawnTests{

    private int playerAmount;
    private Board b = new Board(11,11);
    private int corner;
    
    @Given("{int} players")
    public void players(Integer int1) {
	this.playerAmount = int1;
    }

    @When("board spawns robots")
    public void board_spawns_robots() {
	b.spawnRobot(playerAmount);
    }

    @Then("robots are in opposite corners")
    public void robots_are_in_opposite_corners() {
	assertTrue(b.inCorner());
	assertEquals(b.getRobots().size(), 2);
	assertEquals(b.getRobots().get(0).getX(), (b.getSize()[0]-1-b.getRobots().get(1).getX()));
	assertEquals(b.getRobots().get(0).getY(), (b.getSize()[1]-1-b.getRobots().get(1).getY()));
    }

    @Then("one robot per corner")
    public void one_robot_per_corner() {
	assertFalse(b.overlap());
    }

    @Then("robots are in corners")
    public void robots_are_in_corners() {
	assertTrue(b.inCorner());
	assertEquals(b.getRobots().size(), 3);
    }

    @Then("robots are in all corners")
    public void robots_are_in_all_corners() {
	assertEquals(b.getRobots().size(), 4);
	assertTrue(b.inCorner());
	assertFalse(b.overlap());
    }

    @Given("a corner {int}")
    public void a_corner_topleft(Integer int1) {
	this.corner = int1;
    }
    
    @When("{int} robot is spawned")
    public void robot_is_spawned(Integer int1) {
	b.spawnRobot(int1,corner);
    }
    @Then("the directions must point to {int}")
    public void the_directions_must_point_to_down(Integer int1) {
	assertEquals(int1.intValue(),b.getRobots().get(0).getDir());
    }



}
