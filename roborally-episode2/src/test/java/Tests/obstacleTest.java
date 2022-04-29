//package Tests;
//
//import static org.junit.Assert.assertArrayEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//import java.util.Objects;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import rebuild.ActionCard;
//import rebuild.Board;
//import rebuild.CardType;
//import rebuild.GameInstance;
//import rebuild.Player;
//import rebuild.Robot;
//import rebuild.Tile;
//import rebuild.TyleType;
//import rebuild.Obstacle;
//
//public class obstacleTest {
//    private int length;
//    private int width;
//    private int playerAmount;
//    private int difficulty;
//    private GameInstance game;
//    private Robot robot;
//
//
//    @Given("len {int} wid {int} playerAmount {int} and diff {int}")
//    public void len_wid_player_amount_and_diff(Integer int1, Integer int2, Integer int3, Integer int4) {
//	length = int1; width = int2; playerAmount = int3; difficulty = int4;
//    }
//
//    @When("game started")
//    public void game_starts() {
//	game = new GameInstance(length,width,playerAmount,difficulty);
//    }
//
//    @When("turn started")
//    public void turn_started() {
//	game.startTurn();
//    }
//
//    @When("players chose their cards")
//    public void players_chose_their_cards() {
//	for(Player player : game.askMaster().getPlayers()) {
//	    ArrayList<ActionCard> hand = new ArrayList<ActionCard>();
//
//	    hand.add(new ActionCard(CardType.Move1));hand.add(new ActionCard(CardType.Move1));
//	    hand.add(new ActionCard(CardType.Move1));hand.add(new ActionCard(CardType.Move1));
//
//	    player.setHand(hand);
//	}
//    }
//    
//    @When("player chose his cards")
//    public void player_chose_his_cards() {
//	for(Player player : game.askMaster().getPlayers()) {
//	    ArrayList<ActionCard> hand = new ArrayList<ActionCard>();
//
//	    hand.add(new ActionCard(CardType.Move1));
//	    hand.add(new ActionCard(CardType.TurnR));
//	    hand.add(new ActionCard(CardType.TurnR));
//	    hand.add(new ActionCard(CardType.TurnR));
//
//	    player.setHand(hand);
//	}
//    }
//
//    @When("cards are being executed")
//    public void cards_are_being_executed() {
//	game.execMoves();
//    }
//
//    @When("a barrel tile")
//    public void a_barrel_tile() {
//	Board brd = game.askMaster().getBoard();
//	Tile tile = new Tile(2);
//	Obstacle obstacle = new Obstacle(TyleType.Barrel);
//
//	tile.setObstacle(obstacle); tile.setType(TyleType.Barrel);
//	brd.setTile(1,0,tile);
//	game.askMaster().setBoard(brd);
//
//	robot = game.getRobots().get(0);
//    }
//
//    @When("a pit tile")
//    public void a_pit_tile() {
//	Board brd = game.askMaster().getBoard();
//	Tile tile = new Tile(2);
//	Obstacle obstacle = new Obstacle(TyleType.Pit);
//
//	tile.setObstacle(obstacle); tile.setType(TyleType.Pit);
//	brd.setTile(1,0,tile);
//	game.askMaster().setBoard(brd);
//
//	robot = game.getRobots().get(0);
//    }
//
//    @When("a health tile")
//    public void a_health_tile() {
//	Board brd = game.askMaster().getBoard();
//	Tile tile = new Tile(2);
//	Obstacle obstacle = new Obstacle(TyleType.Health);
//
//	tile.setObstacle(obstacle); tile.setType(TyleType.Health);
//	brd.setTile(1,0,tile); brd.setTile(2,0,tile);
//	brd.setTile(3,0,tile); brd.setTile(4,0,tile);
//	game.askMaster().setBoard(brd);
//    }
//
//
//
//    @When("a gear right tile")
//    public void a_gear_right_tile() {
//	Board brd = game.askMaster().getBoard();
//	Tile tile = new Tile(2);
//	Obstacle obstacle = new Obstacle(TyleType.GearR);
//
//	tile.setObstacle(obstacle); tile.setType(TyleType.GearR);
//	brd.setTile(1,0,tile);
//	game.askMaster().setBoard(brd);
//    }
//
//    @When("a gear left tile")
//    public void a_gear_left_tile() {
//	Board brd = game.askMaster().getBoard();
//	Tile tile = new Tile(2);
//	Obstacle obstacle = new Obstacle(TyleType.GearL);
//
//	tile.setObstacle(obstacle); tile.setType(TyleType.GearL);
//	brd.setTile(8,0,tile);
//	game.askMaster().setBoard(brd);
//    }
//    
//    @When("a conveyor1 tile")
//    public void a_conveyor1_tile() {
//	Board brd = game.askMaster().getBoard();
//	Tile tile = new Tile(2);
//	Obstacle obstacle = new Obstacle(TyleType.Conveyor1);
//
//	tile.setObstacle(obstacle); tile.setType(TyleType.Conveyor1);
//	brd.setTile(1,0,tile);
//	game.askMaster().setBoard(brd);
//    }
//
//    @When("a conveyor2 tile")
//    public void a_conveyor2_tile() {
//	Board brd = game.askMaster().getBoard();
//	Tile tile = new Tile(2);
//	Obstacle obstacle = new Obstacle(TyleType.Conveyor2);
//
//	tile.setObstacle(obstacle); tile.setType(TyleType.Conveyor2);
//	brd.setTile(1,0,tile);
//	game.askMaster().setBoard(brd);
//    }
//    
//    @When("a conveyor3 tile")
//    public void a_conveyor3_tile() {
//	Board brd = game.askMaster().getBoard();
//	Tile tile = new Tile(2);
//	Obstacle obstacle = new Obstacle(TyleType.Conveyor3);
//
//	tile.setObstacle(obstacle); tile.setType(TyleType.Conveyor3);
//	brd.setTile(1,0,tile);
//	game.askMaster().setBoard(brd);
//    }
//
//
//    @When("an acid tile")
//    public void an_acid_tile() {
//	Board brd = game.askMaster().getBoard();
//	Tile tile = new Tile(2);
//	Obstacle obstacle = new Obstacle(TyleType.Acid);
//
//	tile.setObstacle(obstacle); tile.setType(TyleType.Acid);
//	brd.setTile(1,0,tile);
//	game.askMaster().setBoard(brd);
//    }
//
//    @Then("obstacles are generated on tiles")
//    public void obstacles_are_generated_on_tiles() {
//	for(Tile[] column : game.askMaster().getBoard().getTiles()) {
//	    for(Tile row : column) {
//		assertFalse(Objects.isNull(row.getObstacle()));
//	    }
//	}
//    }
//
//    @Then("robot should not move into the barrel")
//    public void robot_should_not_move_into_the_barrel() {
//	assertArrayEquals(game.getRobots().get(0).getCoor(),new int[] {0,0});
//    }
//
//    @Then("robot should die")
//    public void robot_should_die() {
//	assertTrue(robot.equals(game.getRobots().get(0)));
//    }
//
//    @Then("robots life should go up")
//    public void robots_life_should_go_up() {
//	assertFalse(3 < game.getRobots().get(0).getLives());
//    }
//
//    @Then("robot turns right")
//    public void robot_turns_right() {
//	assertTrue(game.getRobots().get(0).getDir() == 1);
//    }
//    @Then("robot turns left")
//    public void robot_turns_left() {
//	assertTrue(true);
//    }
//
//    @Then("robot moves1")
//    public void robot_moves1() {
//	assertTrue(0 <= game.getRobots().get(0).getCoor()[0]);
//    }
//    
//    @Then("robot moves2")
//    public void robot_moves2() {
//	assertTrue(0 <= game.getRobots().get(0).getCoor()[0]);
//    }
//
//    @Then("robot moves3")
//    public void robot_moves3() {
//	assertTrue(0 <= game.getRobots().get(0).getCoor()[0]);
//    }
//
//    @Then("robot stops moving")
//    public void robot_stops_moving() {
//	assertArrayEquals(game.getRobots().get(0).getCoor(), new int[] {0,0});
//    }
//}
