package rebuild;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Player {
    private int[] boardDim;
    private Robot robot;
    private ArrayList<ActionCard> actionCards;
    private ArrayList<ActionCard> hand;
    private boolean moved;
    private Board board;

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
	if(validMove(actionCard)) {
	    if(actionCard.isMovement()) {
		move(actionCard);
		
		obstacleInteract();
		
		robot.checkDead();
	    } else {
		rotate(actionCard);
	    }
	}
    }

    public void move(ActionCard actionCard) {
	if(robot.getDir() == 1) {
	    robot.setCoordinate(new int[] {robot.getCoordinate()[0]+actionCard.getMagnitude(),robot.getCoordinate()[1]});
	} else if(robot.getDir() == 2) {
	    robot.setCoordinate(new int[] {robot.getCoordinate()[0],robot.getCoordinate()[1]+actionCard.getMagnitude()});
	} else if(robot.getDir() == 3) {
	    robot.setCoordinate(new int[] {robot.getCoordinate()[0]-actionCard.getMagnitude(),robot.getCoordinate()[1]});
	} else if(robot.getDir() == 0) {
	    robot.setCoordinate(new int[] {robot.getCoordinate()[0],robot.getCoordinate()[1]-actionCard.getMagnitude()});
	}
    }

    public void rotate(ActionCard actionCard) {
	if(actionCard.getCardType().equals(CardType.TurnL)) {
	    robot.setDir((robot.getDir()-1)%4);
	} else if(actionCard.getCardType().equals(CardType.TurnR)) {
	    robot.setDir((robot.getDir()+1)%4);
	} else if(actionCard.getCardType().equals(CardType.UTurn)) {
	    robot.setDir((robot.getDir()+2)%4);
	}
    }
    private void obstacleInteract() {
	Obstacle obstacle;

	obstacle = board.getTile(robot.getCoordinate()).getObstacle();

	robot.takeDamage(obstacle);
	
	if(obstacle.getType().equals("Barrel")) {
	    rotate(new ActionCard(CardType.UTurn));
	    move(new ActionCard(CardType.Move1));
	    rotate(new ActionCard(CardType.UTurn));
	}
	

	
    }

    public boolean validMove(ActionCard actionCard) {
	boolean valid = false;

	if(actionCard.isMovement()) {
	    if(robot.getDir() == 1) {
		if(robot.getCoordinate()[0]+actionCard.getMagnitude() < boardDim[0]-1) {
		    valid = true;
		}
	    } else if(robot.getDir() == 2) {
		if(robot.getCoordinate()[1]+actionCard.getMagnitude() < boardDim[1]-1) {
		    valid = true;
		}
	    } else if(robot.getDir() == 3) {
		if(0 <= robot.getCoordinate()[0]-actionCard.getMagnitude()) {
		    valid = true;
		}
	    } else if(robot.getDir() == 0) {
		if(0 <= robot.getCoordinate()[1]-actionCard.getMagnitude()) {
		    valid = true;
		}
	    }


	} else {
	    valid = true;
	}
	
	return valid;
    }

    public void setBoardDim(int[] boardSize) {
	boardDim = boardSize;
    }

    public void setBoard(Board board2) {
	board = board2;
    }
    
    public Board getBoard() {
	return board;
    }


}
