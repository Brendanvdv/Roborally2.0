package rebuild;

import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JFrame;

public class GameInstance {
    private GameMaster gm;
    
    public GameInstance(int int1, int int2, int int3, int int4) {
	gm = new GameMaster(int1,int2,int3,int4);
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
	}

	gm.setPlayers(players);
    }

    // Make separate class with it's own responsibility

    private void spawnRobots() {
	for(Player player : gm.getPlayers()) {
	    gm.getBoard().getTile(player.getRobot().getCoor()).setContainsRobot(true);
	   
	    player.setBoard(gm.getBoard());
	    player.getRobot().setInCorner(true);


	    if(player.getName().equals("Player 1")) {
		player.getRobot().setCoor(new int[] {0,0});
		player.getRobot().setDir(1);

	    } else if(player.getName().equals("Player 2")) {
		player.getRobot().setCoor(new int[] {gm.getBoard().getCols()-1,gm.getBoard().getRows()-1});
		player.getRobot().setDir(2);

	    } else if(player.getName().equals("Player 3")) {
		player.getRobot().setCoor(new int[] {gm.getBoard().getCols()-1,0});
		player.getRobot().setDir(3);

	    } else if(player.getName().equals("Player 4")) {
		player.getRobot().setCoor(new int[] {0,gm.getBoard().getRows()-1});
		player.getRobot().setDir(0);
	    }
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

		    gm.getBoard().getTile(player.getRobot().getCoor()).setContainsRobot(true);

		    if(player.getRobot().isDead()) {
			player.setGameOver(true);
		    }
		}
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
