package rebuild;

import java.util.ArrayList;
import java.util.Iterator;

public class Player {
    private Robot robot;
    private ArrayList<ActionCard> actionCards;
    private ArrayList<ActionCard> hand;
    private boolean moved;
    
    public Player() {
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

    public void setHand(ArrayList<ActionCard> handSelected) {
	hand = new ArrayList<ActionCard>();
	
	for (int i = 0; i < handSelected.size(); i++) {
	    hand.add(handSelected.get(i));
	}
    }

    public ArrayList<ActionCard> getHand() {
	return hand;
    }

    public boolean hasMoved() {
	return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }
    
    public void makeRobot(Robot r) {
	robot = r;
    }

    public void execHand(int j) {
	execCard(hand.get(j));
    }

    public void execCard(ActionCard actionCard) {
	if(actionCard.isMovement()) {
	    if(robot.getDir() == 1) {
		robot.setCoordinate(new int[] {robot.getCoordinate()[0]+actionCard.getMagnitude(),robot.getCoordinate()[1]});
	    } else if(robot.getDir() == 2) {
		robot.setCoordinate(new int[] {robot.getCoordinate()[0],robot.getCoordinate()[1]+actionCard.getMagnitude()});
	    } else if(robot.getDir() == 3) {
		robot.setCoordinate(new int[] {robot.getCoordinate()[0]-actionCard.getMagnitude(),robot.getCoordinate()[1]});
	    } else if(robot.getDir() == 0) {
		robot.setCoordinate(new int[] {robot.getCoordinate()[0],robot.getCoordinate()[1]-actionCard.getMagnitude()});
	    }
	} else {
	    if(actionCard.getCardType().equals(CardType.TurnL)) {
		robot.setDir((robot.getDir()-1)%4);
	    } else if(actionCard.getCardType().equals(CardType.TurnR)) {
		robot.setDir((robot.getDir()+1)%4);
	    } else if(actionCard.getCardType().equals(CardType.UTurn)) {
		robot.setDir((robot.getDir()+2)%4);
	    }
	}
    }
  
}
