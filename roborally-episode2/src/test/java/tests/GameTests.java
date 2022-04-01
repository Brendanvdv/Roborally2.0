package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import notdefault.ActionCard;
import notdefault.Game;
import notdefault.Player;

public class GameTests {
    private int boardLength;
    private int boardWidth;
    private int playerAmount;
    private boolean playerStartTurn;
    private Game game;

    @Given("A board of length {int} and width {int} and {int} players")
    public void a_board_of_length_and_width_and_players(Integer int1, Integer int2, Integer int3) {
       boardLength = int1;
       boardWidth = int2;
       playerAmount = int3;
    }

    @When("Game starts")
    public void game_starts() {
        game = new Game();
        game.startGame(boardLength, boardWidth, playerAmount);
    }

    @Then("make a board of {int} x {int} with {int} robots on it")
    public void make_a_board_of_x_with_robots_on_it(Integer int1, Integer int2, Integer int3) {
       
	assertEquals(game.getBoard().getSize()[0],(int) int1);
	assertEquals(game.getBoard().getSize()[1],(int) int2);
	assertEquals(game.getBoard().getRobots().size(),(int) int3);
    }
    
    @Given("Player turn starts true")
    public void player_turn_starts_true() {
        game = new Game();
    }
    @When("Game starts the player's turn")
    public void game_starts_the_player_s_turn() {
	game.setPlayers(1);
        game.startTurn(game.getPlayers().get(0));
    }
    @Then("Generate {int} Action Cards")
    public void generate_action_cards(Integer int1) {
        assertEquals(game.getPlayers().get(0).getActionCards().size(),9);
        
        for(int i = 0; i < 9; i++) {
            assertTrue(game.getPlayers().get(0).getActionCards().get(i) instanceof ActionCard);
        }
    }
}





























