package Tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Objects;

import appModel.ActionCard;
import appModel.CardType;
import appModel.GameInstance;
import appModel.GameMaster;
import appModel.Obstacle;
import appModel.Player;
import appModel.Robot;
import appModel.Tile;
import appModel.TyleType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FeaturesTest {
    private int playerAmount;
    private int difficulty;
    private GameMaster gm;
    private GameInstance game;
    private Obstacle obstacle;
    private Player p;

    @Given("{int} players and difficulty of {int}")
    public void players_and_difficulty_of(Integer int1, Integer int2) {
        playerAmount = int1; difficulty = int2;
    }
    
    @Given("An Obstacle tile Pit")
    public void an_obstacle_tile_pit() {
        obstacle = new Obstacle(TyleType.Pit);
    }
    
    @Given("An Obstacle tile GearL")
    public void an_obstacle_tile_gear_l() {
	obstacle = new Obstacle(TyleType.GearL);
    }
    
    @Given("An Obstacle tile GearR")
    public void an_obstacle_tile_gear_r() {
	obstacle = new Obstacle(TyleType.GearR);
    }
    
    @Given("An Obstacle tile ConveyorN")
    public void an_obstacle_tile_conveyor_n() {
	obstacle = new Obstacle(TyleType.ConveyorN);
    }
    
    @Given("An Obstacle tile ConveyorS")
    public void an_obstacle_tile_conveyor_s() {
	obstacle = new Obstacle(TyleType.ConveyorS);
    }

    @Given("An Obstacle tile ConveyorW")
    public void an_obstacle_tile_conveyor_w() {
	obstacle = new Obstacle(TyleType.ConveyorW);
    }
    
    @Given("An Obstacle tile ConveyorE")
    public void an_obstacle_tile_conveyor_e() {
	obstacle = new Obstacle(TyleType.ConveyorE);
    }
    
    @Given("An Obstacle tile Barrel")
    public void an_obstacle_tile_barrel() {
	obstacle = new Obstacle(TyleType.Barrel);
    }
    
    @Given("An Obstacle tile Acid")
    public void an_obstacle_tile_acid() {
	obstacle = new Obstacle(TyleType.Acid);
    }
    
    @Given("An Obstacle tile Checkpoint")
    public void an_obstacle_tile_checkpoint() {
	obstacle = new Obstacle(TyleType.Checkpoint);
    }
    
    @When("Game starts")
    public void game_starts() {
	gm = new GameMaster(playerAmount, difficulty);
        game = gm.getGame();
    }
    
    @When("Turn starts")
    public void turn_starts() {
        gm.startTurn();
    }
    
    @When("Players selected their cards")
    public void players_selected_their_cards() {
	for(Player player : gm.getGame().getPlayers()) {
	    ArrayList<ActionCard> hand = new ArrayList<ActionCard>();
	    hand.add(new ActionCard(CardType.Move1)); hand.add(new ActionCard(CardType.TurnR));
	    hand.add(new ActionCard(CardType.TurnL)); hand.add(new ActionCard(CardType.UTurn));
	    player.setHand(hand);
	}
    }
    
    @When("Another set")
    public void another_set() {
	for(Player player : gm.getGame().getPlayers()) {
	    ArrayList<ActionCard> hand = new ArrayList<ActionCard>();
	    hand.add(new ActionCard(CardType.Move1)); hand.add(new ActionCard(CardType.Move3));
	    hand.add(new ActionCard(CardType.Move2)); hand.add(new ActionCard(CardType.UTurn));
	    player.setHand(hand);
	}
    }

    @When("Moves are executed")
    public void moves_are_executed() {
        gm.execMoves();
    }
    
    @When("Robot steps on an obstacle tile")
    public void robot_steps_on_an_obstacle_tile() {
        p = new Player("Player 1");
        p.obstacleInteract(obstacle);
    }

    @Then("A game is created")
    public void a_game_is_created() {
        assertFalse(Objects.isNull(gm.getGame()));
    }

    @Then("A board is generated")
    public void a_board_is_generated() {
        assertFalse(Objects.isNull(gm.getBoard()));
        assertFalse(Objects.isNull(gm.getBoard().getDifficulty()));
    }

    @Then("The board has right dimensions")
    public void the_board_has_right_dimensions() {
        if(difficulty == 1) {
            assertEquals(gm.getBoard().getCols(),gm.getBoard().getRows());
            assertEquals(gm.getBoard().getCols(),11);
        } else if(difficulty == 2) {
            assertEquals(gm.getBoard().getCols(),gm.getBoard().getRows());
            assertEquals(gm.getBoard().getCols(),17);
        } else if(difficulty == 3) {
            assertEquals(gm.getBoard().getCols(),gm.getBoard().getRows());
            assertEquals(gm.getBoard().getCols(),25);
        }
    }

    @Then("Is made up of tiles")
    public void is_made_up_of_tiles() {
	for(Tile[] column : gm.getBoard().getTiles()) {
	    for(Tile row : column) {
		assertFalse(Objects.isNull(row));
	    }
	}
    }

    @Then("Tiles have types")
    public void tiles_have_types() {
	for(Tile[] column : gm.getBoard().getTiles()) {
	    for(Tile row : column) {
		assertFalse(Objects.isNull(row.getType()));
		assertFalse(Objects.isNull(row.getType().getPictureFile()));
	    }
	}
    }

    @Then("Tiles have obstacles on them")
    public void tiles_have_obstacles_on_them() {
	for(Tile[] column : gm.getBoard().getTiles()) {
	    for(Tile row : column) {
		assertFalse(Objects.isNull(row.getObstacle()));
	    }
	}
    }

    @Then("Obstacles have types")
    public void obstacles_have_types() {
	for(Tile[] column : gm.getBoard().getTiles()) {
	    for(Tile row : column) {
		assertFalse(Objects.isNull(row.getObstacle().getType()));
		assertFalse(Objects.isNull(row.getObstacle().getDamage()));
	    }
	}
    }

    @Then("Players are made")
    public void players_are_made() {
        for(Player player : gm.getGame().getPlayers()) {
            assertFalse(Objects.isNull(player));
        }
    }

    @Then("Robots are spawned")
    public void robots_are_spawned() {
	for(Player player : gm.getGame().getPlayers()) {
            assertTrue(player.getName().contains("Player"));    
            assertFalse(Objects.isNull(player.getRobot()));
            assertFalse(Objects.isNull(player.getRobot().getCoor()[0]));
            assertFalse(Objects.isNull(player.getRobot().getNumber()));
            assertFalse(Objects.isNull(player.getRobot().getDir()));
            assertFalse(Objects.isNull(player.getRobot().getLives()));
            assertFalse(player.getRobot().isDead());
            
            assertTrue(gm.getBoard().getTile(new int[] {0,0}).isContainsRobot());
            assertFalse(Objects.isNull(gm.getBoard().getTile(new int[] {0,0}).getDir()));
            assertFalse(Objects.isNull(gm.getBoard().getTile(new int[] {0,0}).getRbt()));
        }
    }
    
    @Then("Players have action cards")
    public void players_have_action_cards() {
	for(Player player : gm.getGame().getPlayers()) {
	    assertFalse(Objects.isNull(player.getActionCards()));
	    assertEquals(player.getActionCards().size(),9);
	    
	    for(ActionCard card : player.getActionCards()) {
		assertFalse(Objects.isNull(card));
		assertFalse(Objects.isNull(card.getCardType()));
		assertFalse(Objects.isNull(card.getMagnitude()));
		assertFalse(Objects.isNull(card.getTitle()));
	    }
	}
	
    }

    @Then("No player is affected by acid")
    public void no_player_is_affected_by_acid() {
	for(Player player : gm.getGame().getPlayers()) {
	    assertFalse(player.onAcid());
	}
    }
    
    @Then("The tile where robot was is unset")
    public void the_tile_where_robot_was_is_unset() {
	assertFalse(gm.getBoard().getTile(new int[] {0,0}).isContainsRobot());
    }

    @Then("Check whether a player won")
    public void check_whether_a_player_won() {
        assertFalse(gm.getGame().getPlayers().get(0).hasWon());
    }

    @Then("A new tile is set")
    public void a_new_tile_is_set() {
        assertTrue(gm.getBoard().getTile(gm.getGame().getPlayers().get(0).getRobot().getCoor()).isContainsRobot());
    }

    @Then("If a players robot is dead he is eliminated")
    public void if_a_players_robot_is_dead_he_is_eliminated() {
        assertTrue(gm.getGame().getPlayers().get(0).inGame());
    }
    
    @Then("Robot interacts with the Pit")
    public void robot_interacts_with_the_pit() {
	assertTrue(p.getRobot().isDead());
    }
    
    @Then("Robot interacts with the GearL")
    public void robot_interacts_with_the_gear_l() {
	assertEquals(p.getRobot().getDir(),3);
    }
    
    @Then("Robot interacts with the GearR")
    public void robot_interacts_with_the_gear_r() {
        assertEquals(p.getRobot().getDir(),1);
    }
    
    @Then("Robot interacts with the ConveyorN")
    public void robot_interacts_with_the_conveyor_n() {
	assertEquals(p.getRobot().getDir(),0);
    }
    
    @Then("Robot interacts with the ConveyorS")
    public void robot_interacts_with_the_conveyor_s() {
	assertEquals(p.getRobot().getDir(),2);
    }
    
    @Then("Robot interacts with the ConveyorW")
    public void robot_interacts_with_the_conveyor_w() {
	assertEquals(p.getRobot().getDir(),3);
    }
    
    @Then("Robot interacts with the ConveyorE")
    public void robot_interacts_with_the_conveyor_e() {
	assertEquals(p.getRobot().getDir(),1);
    }
    
    @Then("Robot interacts with the Barrel")
    public void robot_interacts_with_the_barrel() {
        assertEquals(p.getRobot().getDir(),0);
        assertArrayEquals(p.getRobot().getCoor(),new int[] {5,6});
    }
    
    @Then("Robot interacts with the Acid")
    public void robot_interacts_with_the_acid() {
        assertTrue(p.onAcid());
    }
    
    @Then("Robot interacts with the Checkpoint")
    public void robot_interacts_with_the_checkpoint() {
        assertTrue(p.hasWon());
    }
}
