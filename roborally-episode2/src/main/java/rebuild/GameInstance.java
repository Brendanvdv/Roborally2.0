package rebuild;


import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JFrame;

import org.json.simple.parser.ParseException;

public class GameInstance {
    private GameMaster gm;
    private boolean gameEnd = false;
    
    public GameInstance(int int1, int int2) {
	gm = new GameMaster(int1, int2);
	startGame();
	makePlayers();
	spawnRobots();
    }
    

    public void startGame() {
	gm.setBoard();
    }
    
    // Make separate class with it's own responsibility

    public void makePlayers() {
	ArrayList<Player> players = new ArrayList<Player>();

	for (int i = 0; i < gm.getPlayerAmount(); i++) {
	    players.add(new Player("Player " + (i+1)));
	    players.get(i).getRobot().setNumber(i+1);
	}

	gm.setPlayers(players);
    }

    // Make separate class with it's own responsibility

    private void spawnRobots() {
	for(Player player : gm.getPlayers()) {
	   
	    player.setBoard(gm.getBoard());
	    player.getRobot().setInCorner(true);


	    if(player.getName().equals("Player 1")) {
		player.getRobot().setCoor(new int[] {0,0});
		player.getRobot().setDir(2);
		
		gm.getBoard().getTile(player.getRobot().getCoor()).setRbt(1);

	    } else if(player.getName().equals("Player 2")) {
		player.getRobot().setCoor(new int[] {gm.getBoard().getCols()-1,gm.getBoard().getRows()-1});
		player.getRobot().setDir(0);
		
		gm.getBoard().getTile(player.getRobot().getCoor()).setRbt(3);

	    } else if(player.getName().equals("Player 4")) {
		player.getRobot().setCoor(new int[] {gm.getBoard().getCols()-1,0});
		player.getRobot().setDir(2);
		
		gm.getBoard().getTile(player.getRobot().getCoor()).setRbt(4);

	    } else if(player.getName().equals("Player 3")) {
		player.getRobot().setCoor(new int[] {0,gm.getBoard().getRows()-1});
		player.getRobot().setDir(0);
		
		gm.getBoard().getTile(player.getRobot().getCoor()).setRbt(2);
	    }
	    
	    gm.getBoard().getTile(player.getRobot().getCoor()).setContainsRobot(true);
	    gm.getBoard().getTile(player.getRobot().getCoor()).setDir(player.getRobot().getDir());
	}
    }

   

    // Make separate class with it's own responsibility

    public void startTurn() {

	for(Player player : gm.getPlayers()) {

	    player.makeActionCards();
	    player.noAcid();

	}
    }

    // Make separate class with it's own responsibility

    public void execMoves() {
	
	for (int i = 0; i < 4; i++) {

	    
	    for(Player player : gm.getPlayers()) {
		
		if(player.inGame()) {
		    gm.getBoard().getTile(player.getRobot().getCoor()).setContainsRobot(false);

		    player.execHand(i);
		    
		    checkWon(player.getRobot());

		    gm.getBoard().getTile(player.getRobot().getCoor()).setContainsRobot(true);
		    gm.getBoard().getTile(player.getRobot().getCoor()).setRbt(player.getRobot().getNumber());

		    if(player.getRobot().isDead()) {
			player.setGameOver(true);
		    }
		}
	    }
	}
    }
    

    private void checkWon(Robot robot) {
	int diff = askMaster().getDiff();
	
	if(diff == 1) {
	    if(robot.getCoor().equals(new int[] {6,6})) {
		gameEnd = true;
	    }
	} else if(diff == 2) {
	    if(robot.getCoor().equals(new int[] {9,9})) {
		gameEnd = true;
	    }
	} else if(diff == 2) {
	    if(robot.getCoor().equals(new int[] {12,12})) {
		gameEnd = true;
	    }
	}
    }


    public ArrayList<Robot> getRobots() {
	ArrayList<Robot> robots = new ArrayList<Robot>();

	for (int i = 0; i < gm.getPlayers().size(); i++) {
	    robots.add(gm.getPlayers().get(i).getRobot());
	}
	return robots;
    }

    public GameMaster askMaster() {
	return gm;
    }
}
