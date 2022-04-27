package rebuild;

import java.util.ArrayList;


// This class acts as a facade button for GameInstance
public class GameMaster {
    private Board board;
    private int[] boardDim;
    private int playerAmount;
    private ArrayList<Player> players;
    private int diff;

    public GameMaster(int length, int width, int playerCount, int difficulty) {
	this.diff = difficulty;
	setBoardDim(new int[] {length,width});
	setPlayerAmount(playerCount);
    }

    public Board getBoard() {
	return board;
    }

    public void setBoard() {
	board = new Board(boardDim[0], boardDim[1], diff);
    }
    
    public void setBoard(Board brd) {
	board = brd;
    }

    public int getBoardDim(int i) {
	return boardDim[i];
    }

    public int[] getBoardDim() {
	return boardDim;
    }

    public void setBoardDim(int[] boardDim) {
	this.boardDim = boardDim;
    }

    public int getPlayerAmount() {
	return playerAmount;
    }

    public void setPlayerAmount(int playerAmount) {
	this.playerAmount = playerAmount;
    }

    public ArrayList<Player> getPlayers() {
	return players;
    }

    public void setPlayers(ArrayList<Player> players) {
	this.players = players;
    }

    public int getDiff() {
	return diff;
    }

    public void setDiff(int diff) {
	this.diff = diff;
    }


}
