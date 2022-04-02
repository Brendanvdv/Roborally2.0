package rebuild;

import java.util.ArrayList;

public class Player {
    private Robot robot;
    private ArrayList<ActionCard> actionCards;
    
    Player() {
	robot = new Robot();
    }
    
    public Robot getRobot() {
	return robot;
    }

    public ArrayList<ActionCard> getActionCards() {
	return actionCards;
    }

    public void makeActionCards() {
	actionCards = new ArrayList<ActionCard>();
	for (int i = 0; i < 9; i++) {
	    actionCards.add(new ActionCard());
	}
    }
}
