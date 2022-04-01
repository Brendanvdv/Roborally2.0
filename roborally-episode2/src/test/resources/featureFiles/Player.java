package notdefault;

import java.util.ArrayList;

public class Player {
    private ArrayList<ActionCard> actionCards;
    
    public void make9Cards() {
	actionCards = new ArrayList<ActionCard>();
	
	for (int i = 0; i < 9; i++) {
	    actionCards.add(new ActionCard());
	}
    }

    public ArrayList<ActionCard> getActionCards() {
	return actionCards;
    }

}
