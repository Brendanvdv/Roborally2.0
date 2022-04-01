package notdefault;

import java.util.ArrayList;

public class Game {
    private int diff;
    private Board board;
    private ArrayList<Player> players;
    
    public void startGame(int length, int width, int playerAmount) {
	board = new Board(length,width);
	setPlayers(playerAmount);
	board.spawnRobot(players.size());
    }
    
    public void startGame(int length, int width, int playerAmount, int diff) {
	board = new Board(length,width,diff);
	setPlayers(playerAmount);
	board.spawnRobot(players.size());
    }
    
    public void startTurn(Player player) {
	player.make9Cards();
    }
    
    public void setDiff(int int1) {
	diff = int1;
    }
    
    public Tile[][] getBoardArray(){
	return board.getBoard();
    }
    
    public Board getBoard(){
	return board;
    }

    public ArrayList<Player> getPlayers() {
	return players;
    }
    
    public void setPlayers(int playerAmount) {
	players = new ArrayList<Player>();
	
	for (int i = 0; i < playerAmount; i++) {
	    players.add(new Player());
	}
    }
}
