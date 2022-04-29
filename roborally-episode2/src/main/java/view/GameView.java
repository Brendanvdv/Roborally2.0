package view;

import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controls.ControlPanel;
import rebuild.ActionCard;
import rebuild.Board;
import rebuild.CardType;

public class GameView extends JFrame {



    ControlPanel cPanel;
    BoardView bView;
    Buttons buttons;
    JLabel command;

    public GameView() {
	cPanel = new ControlPanel();

	init();
    }

    
    public void init() {

	
	bView = new BoardView(cPanel.getGame().askMaster().getBoard());
	buttons = new Buttons(cPanel);
	command = new JLabel();
	add(bView);
	add(buttons);
	add(command);
	validate();
//	System.out.println("fadwad");
    }


    public void loadHand(int index) {
	cPanel.getGame().askMaster().getPlayers().get(index).setHand(buttons.getHand());
	
//	ArrayList<ActionCard> deck = new ArrayList<ActionCard>();
//	deck.add(new ActionCard(CardType.UTurn)); deck.add(new ActionCard(CardType.UTurn));
//	deck.add(new ActionCard(CardType.UTurn)); deck.add(new ActionCard(CardType.UTurn));
//	
////	cPanel.getGame().askMaster().getPlayers().get(0).setHand(deck);
//	cPanel.getGame().askMaster().getPlayers().get(1).setHand(deck);
//	cPanel.getGame().askMaster().getPlayers().get(2).setHand(deck);
//	cPanel.getGame().askMaster().getPlayers().get(3).setHand(deck);
	
//	cPanel.getGame().execMoves();
    }

    public void turn(int index) {
	cPanel.getGame().startTurn();	
	
	buttons.makeButtons(index);
	command.setText("Player " + (index + 1) + " please select your cards");
	buttons.setHand(new ArrayList<ActionCard>());
	buttons.setActive(true);
	
	
	
	
	

	while(true) {
	    
	    System.out.print("");
	    if(!buttons.isActive()) {
		loadHand(index);
		command.setText("");
		break;	
	    } 
	}

    }
    public ControlPanel getcPanel() {
	return cPanel;
    }

    public void setcPanel(ControlPanel cPanel) {
	this.cPanel = cPanel;
    }
    
    public void execM() {
	cPanel.getGame().execMoves();
//	System.out.println("Trying to repaint");
//	this.remove(bView);
//	bView = new BoardView(cPanel.getGame().askMaster().getBoard());
//	bView.validate();
//	bView.repaint();
//	add(bView);
//	System.out.println("Repainred");
    }

}
