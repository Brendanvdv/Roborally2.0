package rebuild;

import java.util.ArrayList;

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
	
	int[] directions = new int[] {1,2,3,0};
	
	for (int i = 0; i < players.size(); i++) {
	    players.get(i).getRobot().setCoor(corners.get(i));
	    players.get(i).getRobot().setInCorner(true);
	    
	    players.get(i).getRobot().setDir(directions[i]);
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

    public void startTurn(Player player) {
	player.makeActionCards();
    }
}
