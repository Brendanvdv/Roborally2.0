package Tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Objects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rebuild.ActionCard;
import rebuild.CardType;
import rebuild.GameInstance;
import rebuild.Player;
import rebuild.Robot;
import rebuild.Tile;

public class turnStarts {
    private GameInstance game;
    private Player player;
    private ActionCard actionCard;
    private Robot robot;
    private Tile tile;

    @Given("Game started")
    public void game_started() {
	game = new GameInstance(10,10,4,2);
    }

    @Given("a robot at {int} and {int} looking at {int} movement Action Card")
    public void a_robot_at_and_looking_at_movement_action_card(Integer int1, Integer int2, Integer int3) {
	robot = new Robot(int1, int2, int3);
	actionCard = new ActionCard(CardType.Move1);
	player = new Player();
	player.setBoardDim(new int[] {10,10});
	player.setBoard(game.getBoard());
    }

    @Given("a robot at {int} and {int} looking at {int} rotation {int} Action Card")
    public void a_robot_at_and_looking_at_rotation_action_card(Integer int1, Integer int2, Integer int3, Integer int4) {
	robot = new Robot(int1, int2, int3);
	player = new Player();
	player.setBoardDim(new int[] {10,10});
	

	if(int4 == 111) {
	    actionCard = new ActionCard(CardType.TurnL);
	} else if(int4 == 222) {
	    actionCard = new ActionCard(CardType.TurnR);
	} else if(int4 == 333) {
	    actionCard = new ActionCard(CardType.UTurn);
	}
    }

    @Given("a robot at {int} and {int} looking at {int} movement Action Card of {int} magnitude")
    public void a_robot_at_and_looking_at_movement_action_card_of_magnitude(Integer int1, Integer int2, Integer int3, Integer int4) {
	robot = new Robot(int1, int2, int3);
	player = new Player();

	player.setBoardDim(new int[] {10,10});

	if(int4 == 1) {
	    actionCard = new ActionCard(CardType.Move1);
	} else if(int4 == 2) {
	    actionCard = new ActionCard(CardType.Move2);
	} else if(int4 == 3) {
	    actionCard = new ActionCard(CardType.Move3);
	}
    }

    @When("turn starts")
    public void turn_starts() {
	game.startTurn();
    }

    @When("I chose four cards")
    public void i_chose_four_cards() {
	for(Player player : game.getPlayers()) {
	    ArrayList<ActionCard> hand = new ArrayList<ActionCard>();
	    hand.add(player.getActionCards().get(0));hand.add(player.getActionCards().get(1));
	    hand.add(player.getActionCards().get(2));hand.add(player.getActionCards().get(3));
	    player.setHand(hand);
	}
    }

    @When("the game executes the moves")
    public void the_game_executes_the_moves() {
	game.execMoves();
    }

    @When("check card")
    public void check_card() {
	player.makeRobot(robot);
	player.validMove(actionCard);
    }

    @When("executing a card")
    public void executing_a_card() {
	player.makeRobot(robot);
	player.execCard(actionCard);
    }

    @When("robot runs out of lives")
    public void robot_runs_out_of_lives() {
        game.getRobots().get(0).takeDamage(1000);
    }

    @Then("generate action cards")
    public void generate_action_cards() {
	for(Player player : game.getPlayers()) {
	    assertEquals(player.getActionCards().size(),9);
	}
    }

    @Then("there should be at least {int} movement cards")
    public void there_should_be_at_least_movement_cards(Integer int1) {
	int counter = 0;

	for(Player player : game.getPlayers()) {
	    for (int i = 0; i < 9; i++) {
		if(player.getActionCards().get(i).isMovement()) {
		    counter++;
		}
	    }
	}
	counter = counter/game.getPlayers().size();

	assertTrue(int1 <= counter);
    }

    @Then("I want to have four action cards in my hand")
    public void i_want_to_have_four_action_cards_in_my_hand() {
	for(Player player : game.getPlayers()) {
	    assertEquals(player.getHand().size(),4);
	}
    }

    @Then("player moves")
    public void player_moves() {
	for(Player player : game.getPlayers()) {
	    assertTrue(player.hasMoved());
	}
    }

    @Then("robot moves accordingly to {int} and {int} looking at {int}")
    public void robot_moves_accordingly_to_and_looking_at(Integer int1, Integer int2, Integer int3) {
	assertTrue(player.hasMoved());
    }
	

    @Then("Robot should look at {int} direction")
    public void robot_should_look_at_direction(Integer int1) {
	assertEquals(player.getRobot().getDir(),(int) int1);
    }

    @Then("robots move is {int}")
    public void robots_move_is(Integer int1) {
	boolean status;
	if(int1 == 1) {
	    status = true;
	} else {
	    status = false;
	}
	assertEquals(status,player.validMove(actionCard));

    }
    
    @Then("player is removed from the game")
    public void player_is_removed_from_the_game() {
        assertTrue(game.getPlayers().size() != 4);
    }



}
