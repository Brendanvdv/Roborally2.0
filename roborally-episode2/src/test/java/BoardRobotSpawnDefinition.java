import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import notdefault.Board;

public class BoardRobotSpawnDefinition {
	
	private int playerAmount;
	private Board b = new Board(11,11);
	
	@Given("{int} players")
	public void two_players(Integer int1) {
	    this.playerAmount = int1;
	}
	@When("board spawns robots")
	public void two_board_spawns_robots() {
	    b.spawnRobot(playerAmount);
	}
	@Then("robots are in opposite corners")
	public void two_robots_are_in_opposite_corners() {
	    assertTrue(b.inCorner());
	    assertEquals(b.getRobots().size(), 2);
	    assertEquals(b.getRobots().get(0).getX(), (b.getSize()[0]-b.getRobots().get(1).getX()));
	    assertEquals(b.getRobots().get(0).getY(), (b.getSize()[1]-b.getRobots().get(1).getY()));

	}
	@Then("one robot per corner")
	public void two_one_robot_per_corner() {
	    assertFalse(b.overlap());
	}

	@Given("{int} players")
	public void three_players(Integer int1) {
	    this.playerAmount = int1;
	}
	@When("board spawns robots")
	public void three_board_spawns_robots() {
	    b.spawnRobot(playerAmount);
	}
	@Then("robots are in corners")
	public void three_robots_are_in_corners() {
	    assertTrue(b.inCorner());
	    assertEquals(b.getRobots().size(), 3);

	}
	@Then("one robot per corner")
	public void three_one_robot_per_corner() {
	    assertFalse(b.overlap());
	}

	@Given("{int} players")
	public void four_players(Integer int1) {
	    this.playerAmount = int1;
	}
	@When("board spawns robots")
	public void board_spawns_robots() {
	    b.spawnRobot(playerAmount);
	}
	@Then("robots are in all corners")
	public void four_robots_are_in_all_corners() {
		assertEquals(b.getRobots().size(), 4);
	    assertTrue(b.inCorner());
	    assertFalse(b.overlap());
	}
//	@Then("one robot per corner")
//	public void three_one_robot_per_corner() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("a corner {int}")
//	public void a_corner_topleft(Integer int1) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//	@When("robot is spawned")
//	public void robot_is_spawned_topleft() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//	@Then("the directions must point to {int}")
//	public void the_directions_must_point_to_down(Integer int1) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("a corner {int}")
//	public void a_corner_topright(Integer int1) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//	@When("robot is spawned")
//	public void robot_is_spawned_topright() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//	@Then("the directions must point to {int}")
//	public void the_directions_must_point_to_right(Integer int1) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("a corner {int}")
//	public void a_corner_botleft(Integer int1) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//	@When("robot is spawned")
//	public void robot_is_spawned_botleft() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//	@Then("the directions must point to {int}")
//	public void the_directions_must_point_to_up(Integer int1) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("a corner {int}")
//	public void a_corner_botright(Integer int1) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//	@When("robot is spawned")
//	public void robot_is_spawned_botright() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//	@Then("the directions must point to {int}")
//	public void the_directions_must_point_to_left(Integer int1) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

//	  Scenario: direction of robots
//	  	Given a corner <c>
//	  	When robot is spawned
//	  	Then the directions must point to <dir>
//	  	
//	  Examples:
//	  	| c | dir |
//	  	| 0 |  2  |
//	  	| 1 |  3  |
//	  	| 2 |  0  |
//	  	| 3 |  1  |
	
}
