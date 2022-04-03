package rebuild;

import java.util.ArrayList;
import java.util.Objects;

public class Game {
    private Board board;
    private int[] boardDim;
    private int playerAmount;
    private ArrayList<Player> players;
    private int diff;

    public Game(int length, int width, int playerCount, int difficulty) {
	diff = difficulty;
	boardDim = new int[] {length,width};
	playerAmount = playerCount;
	startGame();
    }

    public void startGame() {
	board = new Board(boardDim[0],boardDim[1],diff);
	makePlayers();
	spawnRobots();
    }

    private void spawnRobots() {
	ArrayList<int[]> corners = new ArrayList<int[]>();
	corners.add(new int[] {0,0});
	corners.add(new int[] {boardDim[0]-1,boardDim[1]-1});
	corners.add(new int[] {0,boardDim[1]-1});
	corners.add(new int[] {boardDim[0]-1,0});

	ArrayList<Integer> directions = new ArrayList<Integer>();
	directions.add(1); directions.add(2); directions.add(3); directions.add(0);

	for (Robot robot : getRobots()) {
	    robot.setCoordinate(corners.get(0));
	    corners.remove(0);
	    robot.setInCorner(true);
	    robot.setDir(directions.get(0));
	    directions.remove(0);
	}

	for (int i = 0; i < players.size(); i++) {
	    board.putRobotOn(getRobots().get(i).getCoordinate());
	}


    }

    private void makePlayers() {
	players = new ArrayList<Player>();

	for (int i = 0; i < playerAmount; i++) {
	    players.add(new Player());
	}

	for(Player player : players) {
	    player.setBoardDim(boardDim);
	    player.setBoard(board);
	}
    }

    public ArrayList<Robot> getRobots() {
	ArrayList<Robot> robots = new ArrayList<Robot>();

	for (int i = 0; i < players.size(); i++) {
	    robots.add(players.get(i).getRobot());
	}

	return robots;
    }


    public Board getBoard() {
	return board;
    }

    public int[] getBoardDim() {
	return boardDim;
    }

    public ArrayList<Player> getPlayers() {
	return players;
    }

    public void startTurn() {
	for(Player player : players) {
	    player.makeActionCards();
	    player.setMoved(false);	}
    }

    public void execMoves() {
	
	for(int i = 0; i < 4; i++) {
	    for(Player player : players) {
		player.setBoard(board);
		player.execHand(i);
	    }
	    players.get(i).setMoved(true);
	}
    }

    public void setBoard(Board brd) {
	board = brd;
    }
}
