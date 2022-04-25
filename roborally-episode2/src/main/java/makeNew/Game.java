package makeNew;

import java.util.ArrayList;

public class Game {

    private Board board;

    private ArrayList<Player> players;

    public Game(int length, int width, int playerAmount, int difficulty) {
	makeBoard(length, width, difficulty);
	makePlayers(playerAmount);
	spawnRobots();
    }

    private void makeBoard(int length, int width, int difficulty) {
	board = new Board(length, width, difficulty);
    }

    private void makePlayers(int playerAmount) {
	players = new ArrayList<Player>();

	for (int i = 0; i < playerAmount; i++) {
	    players.add(new Player("Player " + (i+1)));
	}
    }

    private void spawnRobots() {
	for(Player player : players) {
	    board.getTile(player.getRobot().getCoor()).setContainsRobot(true);
	    player.setBoard(board);
	    player.getRobot().setInCorner(true);


	    if(player.getName().equals("Player 1")) {
		player.getRobot().setCoor(new int[] {0,0});
		player.getRobot().setDir(1);

	    } else if(player.getName().equals("Player 2")) {
		player.getRobot().setCoor(new int[] {board.getCols()-1,board.getRows()-1});
		player.getRobot().setDir(2);

	    } else if(player.getName().equals("Player 3")) {
		player.getRobot().setCoor(new int[] {board.getCols()-1,0});
		player.getRobot().setDir(3);

	    } else if(player.getName().equals("Player 4")) {
		player.getRobot().setCoor(new int[] {0,board.getRows()-1});
		player.getRobot().setDir(0);
	    }
	}
    }

    public void startRound() {
	for(Player player : players) {
	    player.makeActionCards();
	    player.noAcid();
	}
    }

    public void execMoves() {
	for (int i = 0; i < 4; i++) {
	    for(Player player : players) {
		if(player.inGame()) {
		    board.getTile(player.getRobot().getCoor()).setContainsRobot(false);

		    player.execHand(i);

		    board.getTile(player.getRobot().getCoor()).setContainsRobot(true);

		    if(player.getRobot().isDead()) {
			player.setGameOver(true);
		    }
		}
	    }
	}
    }

    public Board getBoard() {
	return board;
    }

    public ArrayList<Player> getPlayers() {
	return players;
    }

    public ArrayList<Robot> getRobots() {
	ArrayList<Robot> robots = new ArrayList<Robot>();

	for(Player player : players) {
	    robots.add(player.getRobot());
	}

	return robots;
    }
}
