package rebuild;

import java.util.ArrayList;


// This class acts as a facade button for GameInstance
public class GameMaster {
	private Board board;
    private int[] boardDim;
    private int playerAmount;
    private ArrayList<Player> players;
    private int diff;
    
    GameInstance gi = new GameInstance();

    public GameMaster(int length, int width, int playerCount, int difficulty) {
    	this.diff = difficulty;
    	setBoardDim(new int[] {length,width});
    	setPlayerAmount(playerCount);
    	gi.startGame();
    	gi.makePlayers();
    	gi.spawnRobots();
    }

	public Board getBoard() {
		return board;
	}

	public void setBoard(int bd1, int bd2, int diff) {
		int[] bd = {bd1,bd2};
		setBoardDim(bd);
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
