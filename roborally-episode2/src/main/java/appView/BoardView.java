package appView;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import appModel.Board;

public class BoardView extends JPanel {

    public BoardView(Board board){

	setLayout(new GridLayout(board.getCols(), board.getRows()));

	setMinimumSize(new Dimension(board.getCols() * 32, board.getRows() * 32));
	setMaximumSize(getMinimumSize());
	setPreferredSize(getMinimumSize());
	
	for (int i = 0; i < board.getTiles().length; i++) {
	    for (int j = 0; j < board.getTiles().length; j++) {
		TileView tile = new TileView(board.getTiles()[j][i]);
		add(tile);
	    }
	}

    }
}
