package appView;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;

import appModel.ActionCard;
import appModel.CardType;


public class CardView extends JPanel {

    private boolean Active = true;
    private int counter = 0;

    private ArrayList<ActionCard> actionCards;
    ArrayList<String> handS = new ArrayList<String>();
    ArrayList<ActionCard> hand = new ArrayList<ActionCard>();;

    JButton b0; JButton b1; JButton b2;
    JButton b3; JButton b4; JButton b5;
    JButton b6; JButton b7; JButton b8;

    JButton[] buttons = new JButton[] {b0,b1,b2,b3,b4,b5,b6,b7,b8};


    CardView() {
	initGUI();	
    }
    
    public void boot(ArrayList<ActionCard> actionCards) {
	this.actionCards = actionCards;
	
	for(int i = 0; i < 9; i++) {
	    buttons[i].setText(actionCards.get(i).getTitle());
	}
    }

    private void initGUI() {
	
	for(int i = 0; i < 9; i++) {
	    buttons[i] = new JButton(new buttonAction());
	    add(buttons[i]);
	}
    }

    class buttonAction extends AbstractAction {



	public void actionPerformed(ActionEvent e) {

	    JButton x = (JButton) e.getSource();
	    if(handS.size() < 4) {
		handS.add(x.getText());
	    }
	   	    

	    counter++;

	    



	    for(String card : handS) {
		if(card.equals("Move 1")) {
		    hand.add(new ActionCard(CardType.Move1));
		} else if(card.equals("Move 2")) {
		    hand.add(new ActionCard(CardType.Move2));
		} else if(card.equals("Move 3")) {
		    hand.add(new ActionCard(CardType.Move3));
		} else if(card.equals("Turn Left")) {
		    hand.add(new ActionCard(CardType.TurnL));
		} else if(card.equals("Turn Right")) {
		    hand.add(new ActionCard(CardType.TurnR));
		} else if(card.equals("U-Turn")) {
		    hand.add(new ActionCard(CardType.UTurn));
		}
	    }
	    
	    if(counter == 4) {
		counter = 0;
		Active = false;

	    }
	}
    }
    
    public boolean isActive() {
	return Active;
    }
    
    public void setActive(boolean bool) {
	Active = bool;
    }
    
    public ArrayList<ActionCard> getHand() {
	
	ArrayList<ActionCard> g = new ArrayList<ActionCard>();
	g.add(hand.get(6)); g.add(hand.get(7));
	g.add(hand.get(8)); g.add(hand.get(9));

        return g;
    }

    public void setHand(ArrayList<ActionCard> hand) {
        this.hand = hand;
    }
}
