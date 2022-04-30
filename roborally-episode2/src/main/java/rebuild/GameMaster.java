package rebuild;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;


// This class acts as a facade button for GameInstance
public class GameMaster {
    private Board board;
    private int[] boardDim;
    private int playerAmount;
    private ArrayList<Player> players;
    private int diff;

    public GameMaster(int playerCount, int difficulty) {
	this.diff = difficulty;
	
	if(diff == 1) {
	    setBoardDim(new int[] {11,11});
	} else if(diff == 2) {
	    setBoardDim(new int[] {17,17});
	} else if(diff == 3) {
	    setBoardDim(new int[] {25,25});
	}
	
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
