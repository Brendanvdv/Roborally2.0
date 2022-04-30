package appModel;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Board {

    private Tile[][] gameBoard;

    private int cols;
    private int rows;
    MapsReader mr;

    public Board(int difficulty) {
	mr = new MapsReader(difficulty);
	init(difficulty);
    }
    
    private void init(int difficulty) {
	gameBoard = new Tile[mr.getMap().length][mr.getMap().length];
	
	cols = mr.getMap().length;
	rows = mr.getMap().length;

	for (int i = 0; i < gameBoard.length; i++) {
	    for (int j = 0; j < gameBoard.length; j++) {
		gameBoard[i][j] = new Tile(mr.getMap()[i][j]);
	    }
	}

    }

    public Tile getTile(int[] coor) {
	return gameBoard[coor[0]][coor[1]];
    }

    public int getCols() {
	return cols;
    }

    public int getRows() {
	return rows;
    }

    public Tile[][] getTiles() {
	return gameBoard;
    }

    public void setTile(int i, int j, Tile tile) {
	gameBoard[i][j] = tile;
    }
}