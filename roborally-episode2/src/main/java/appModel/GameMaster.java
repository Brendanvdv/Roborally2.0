package appModel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import appModel.Player;
import appModel.Robot;


// This class acts as a facade button for GameInstance
public class GameMaster {
    private GameInstance game;
    private boolean gameEnd = false;

    public GameMaster(int playerAmount, int difficulty) {
	game = new GameInstance(playerAmount, difficulty);
	makePlayers(playerAmount);
	spawnRobots();
    }

    public void makePlayers(int playerAmount) {
	ArrayList<Player> players = new ArrayList<Player>();

	for (int i = 0; i < playerAmount; i++) {
	    players.add(new Player("Player " + (i+1)));
	    players.get(i).getRobot().setNumber(i+1);
	    players.get(i).setBoard(getBoard());
	}

	game.setPlayers(players);
    }

    private void spawnRobots() {
	for(Player player : game.getPlayers()) {

	    if(player.getName().equals("Player 1")) {
		player.getRobot().setCoor(new int[] {0,0});
		player.getRobot().setDir(2);

		game.getBoard().getTile(player.getRobot().getCoor()).setRbt(1);

	    } else if(player.getName().equals("Player 2")) {
		player.getRobot().setCoor(new int[] {game.getBoard().getCols()-1,game.getBoard().getRows()-1});
		player.getRobot().setDir(0);

		game.getBoard().getTile(player.getRobot().getCoor()).setRbt(3);

	    } else if(player.getName().equals("Player 4")) {
		player.getRobot().setCoor(new int[] {game.getBoard().getCols()-1,0});
		player.getRobot().setDir(2);

		game.getBoard().getTile(player.getRobot().getCoor()).setRbt(4);

	    } else if(player.getName().equals("Player 3")) {
		player.getRobot().setCoor(new int[] {0,game.getBoard().getRows()-1});
		player.getRobot().setDir(0);

		game.getBoard().getTile(player.getRobot().getCoor()).setRbt(2);
	    }

	    game.getBoard().getTile(player.getRobot().getCoor()).setContainsRobot(true);
	    game.getBoard().getTile(player.getRobot().getCoor()).setDir(player.getRobot().getDir());
	}
    }

    public void startTurn() {

	for(Player player : game.getPlayers()) {

	    player.makeActionCards();
	    player.noAcid();
	}
    }

    public void execMoves() {

	for (int i = 0; i < 4; i++) {
	    for(Player player : game.getPlayers()) {

		if(player.inGame()) {
		    Board b = game.getBoard();
		    b.getTile(player.getRobot().getCoor()).setContainsRobot(false);

		    player.execHand(i);

		    checkWon(player.getRobot());

		    b.getTile(player.getRobot().getCoor()).setContainsRobot(true);
		    b.getTile(player.getRobot().getCoor()).setRbt(player.getRobot().getNumber());
		    game.setBoard(b);
		    if(player.getRobot().isDead()) {
			player.setGameOver(true);
		    }
		}
	    }
	}
    }

    private void checkWon(Robot robot) {
	for(Player player : game.getPlayers()) {
	    if(player.hasWon()) {
		gameEnd = true;
	    }
	}
    }
    
    public Board getBoard() {
	return game.getBoard();
    }

    public ArrayList<ActionCard> getCards(int i) {
	return game.getPlayers().get(i).getActionCards();
    }

    public void setHand(ArrayList<ActionCard> hand, int i) {
	game.getPlayers().get(i).setHand(hand);
    }
    
    public int numberOfPlayers() {
	return game.getPlayers().size();
    }
    
    public GameInstance getGame() {
	return game;
    }
    
    public boolean hasEnded() {
	return gameEnd;
    }
}