package makeNew;

import java.util.Objects;

public class Tile {

    private Obstacle obstacle;
    private TyleType type;

    private boolean containsRobot;

    public Tile(TyleType tileType) {
	type = tileType;
	generateObstacle();
    }

    public Tile(int difficulty) {
	init(difficulty);
	generateObstacle();
    }

    private void generateObstacle() {
	obstacle = new Obstacle(type);
    }

    public void setContainsRobot(boolean b) {
	containsRobot = b;
    }

    public void init(int diff) {
	double val = Math.random();
	double x = 0.65 - diff*0.1;
	double y = (1 - x)/11;


	if(val < x) {
	    type = TyleType.Floor;
	} else if(val < x+y) {
	    type = TyleType.Pit;
	} else if(val < x+3*y) {
	    type = TyleType.Barrel;
	} else if(val < x+3.5*y) {
	    type = TyleType.Laser;
	} else if(val < x+5*y) {
	    type = TyleType.Acid;
	} else if(val < x+6*y) {
	    type = TyleType.Health;
	} else if(val < x+7*y) {
	    type = TyleType.Conveyor1;
	} else if(val < x+8*y) {
	    type = TyleType.Conveyor2;
	} else if(val < x+9*y) {
	    type = TyleType.Conveyor3;
	} else if(val < x+10*y) {
	    type = TyleType.GearL;
	} else {
	    type = TyleType.GearR;
	}
    }

    public Obstacle getObstacle() {
	return obstacle;
    }

    public boolean validObstacle() {
	return !Objects.isNull(obstacle);
    }

    public TyleType getType() {
	return type;
    }

}
