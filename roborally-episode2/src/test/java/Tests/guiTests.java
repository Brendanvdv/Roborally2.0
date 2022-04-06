//package Tests;
//
//import static org.junit.Assert.assertTrue;
//
//import java.awt.Dimension;
//import java.awt.GridLayout;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import rebuild.Game;
//import rebuild.Robot;
//import rebuild.Tile;
//
//public class guiTests {
//    private Game game;
//    private JFrame f;
//
//    @Given("a game {int} {int} {int} {int}")
//    public void a_game(Integer int1, Integer int2, Integer int3, Integer int4) {
//        game = new Game(int1,int2,int3,int4);
//        f = new JFrame("Roborally 2.0");
//    }
//
//    @When("making a window")
//    public void making_a_window() {
//        game.play(f);
//    }
//
//    @Then("a window is made")
//    public void a_window_is_made() {
//	Dimension x = new Dimension();
//	x.setSize(700,700);
//	assertTrue(f.getSize().equals(x));
//    }
//    
//    @Then("add jpanel tiles to the board")
//    public void add_jpanel_tiles_to_the_board() {
//	for(Tile[] column :game.getBoard().getTiles()) {
//	    for(Tile row : column) {
//		assertTrue(row instanceof JPanel);
//	    }
//	}
//    }
//    
//    @Then("make the board in a grid")
//    public void make_the_board_in_a_grid() {
//	assertTrue(game.getBoard().getLayout() instanceof GridLayout);   
//    }
//    
//    @Then("tiles have images in them")
//    public void tiles_have_images_in_them() {
//	for(Tile[] column :game.getBoard().getTiles()) {
//	    for(Tile row : column) {
//		assertTrue(row.getType().getPictureFile() instanceof String);
//	    }
//	}
//    }
//    
//    @Then("robot should be on the tile")
//    public void robot_should_be_on_the_tile() {
//        for(Robot robot : game.getRobots()) {
//            assertTrue(game.getBoard().getTile(robot.getCoordinate()).hasRobot());
//        }
//    }
//    
//    
//}
