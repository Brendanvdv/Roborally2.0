package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import rebuild.Board;
import rebuild.Tile;

public class BoardView extends JPanel {
    public BoardView(Board board){

	setLayout(new GridLayout(board.getCols(), board.getRows()));

	setMinimumSize(new Dimension(board.getCols() * 64, board.getRows() * 64));
	setMaximumSize(getMinimumSize());
	setPreferredSize(getMinimumSize());
	
	for(Tile[] column : board.getTiles()) {
	    for(Tile row :  column) {
		TileView tile = new TileView(row);
		add(tile);
	    }
	}
    }
}
