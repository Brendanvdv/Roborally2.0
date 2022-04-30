package appModel;


import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JFrame;

import org.json.simple.parser.ParseException;

import appModel.Board;
import rebuild.Player;

public class GameInstance {
    private Board board;
    private ArrayList<Player> players;


    public GameInstance(int playerAmount, int difficulty) {
	board = new Board(difficulty);
    }

    public ArrayList<Player> getPlayers() {
	return players;
    }
    
    public void setPlayers(ArrayList<Player> players) {
	this.players = players;
    }
    
    public Board getBoard() {
	return board;
    }
}
