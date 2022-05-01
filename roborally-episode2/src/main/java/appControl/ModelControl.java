package appControl;

import java.util.ArrayList;

import javax.swing.JLabel;

import appModel.ActionCard;
import appModel.Board;
import appModel.GameMaster;
import appView.CardView;
import appView.ModelView;

public class ModelControl {

	private GameMaster gm;
	private ModelView modelView;

	public ModelControl(GameMaster gameMaster) {
		gm = gameMaster;
	}

	public void setView(ModelView modelView) {
		this.modelView = modelView;
	}

	public void display() {
		modelView.setVisible(true);
	}

	public Board getBoard() {
		return gm.getBoard();
	}

	public CardView getCardView() {
		return modelView.cardView();
	}

	public JLabel getCommand() {
		return modelView.getCommand();
	}

	public void startRunning() {
		gm.startTurn();
	}

	public ArrayList<ActionCard> getCards(int i) {
		return gm.getCards(i);
	}

	public void setHand(ArrayList<ActionCard> hand, int i) {
		gm.setHand(hand, i);
	}

	public int numberOfPlayers() {
		return gm.numberOfPlayers();
	}

	public void nextTurn() {
		gm.execMoves();
	}
}
