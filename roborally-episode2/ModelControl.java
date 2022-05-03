package appControl;


import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import appModel.ActionCard;
import appModel.Board;
import appModel.GameMaster;
import appModel.Player;
import appView.CardView;
import appView.ModelView;
import appView.VictoryView;

public class ModelControl {

	private GameMaster gm;
	private ModelView modelView;
	private VictoryView victoryView;

	public ModelControl(GameMaster gameMaster) {
		gm = gameMaster;
	}



	public void setView(ModelView modelView) {
		this.modelView = modelView;
	}

	public void display() {
		modelView.validate();
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
		gm.setHand(hand,i);
	}

	public int numberOfPlayers() {
		return gm.numberOfPlayers();
	}

	public void nextTurn() {
		gm.execMoves();
		modelView.update(getBoard());

		if(gm.hasEnded()) {
			modelView.dispose();
			String s = "no one";
			for(Player player : gm.getGame().getPlayers()) {
				
				if(!player.getRobot().isDead()) {
					s = player.getName();
				}
				
				if(player.hasWon()) {
					s = player.getName();
					break;
				}
			}
			victoryView = new VictoryView(s);
		}
		
	}

	public ModelView getView() {
		return modelView;
	}

	public int getNumberOfPlayers() {
		return gm.getGame().getPlayers().size();
	}

	public void play() {
		startRunning();
		for(int i = 0; i < getNumberOfPlayers(); i++) {
			if(gm.getGame().getPlayers().get(getView().getNumber()).getRobot().isDead()) {
				getView().setNumber((getView().getNumber()+1)%getNumberOfPlayers());
			}
		}
		getCommand().setText("Player " + (getView().getNumber()+1) + " select your cards:");
		getCardView().boot(getCards(getView().getNumber()));
		getCardView().setModel(this);
		getCardView().setActive(true);
	}



	public int getPlayersAlive() {
		return gm.playersAlive();
	}
}
