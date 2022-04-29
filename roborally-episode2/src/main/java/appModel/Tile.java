package appModel;

import java.util.Objects;

public class Tile {
    
    private Obstacle obstacle;
    private TyleType type;

    private boolean containsRobot;
    private int rbt;
    private int dir;

    public Tile(TyleType tileType) {
	type = tileType;
	generateObstacle();
    }

    public Tile(int difficulty) {
	init(difficulty);
	generateObstacle();
    }

    public Tile(String string) {
	
	if(string.equals("Acid")) {
	    type = TyleType.Acid;
	} else if(string.equals("Barrel")) {
	    type = TyleType.Barrel;
	} else if(string.equals("Pit")) {
	    type = TyleType.Pit;
	} else if(string.equals("Laser")) {
	    type = TyleType.Laser;
	} else if(string.equals("Health")) {
	    type = TyleType.Health;
	} else if(string.equals("GearR")) {
	    type = TyleType.GearR;
	} else if(string.equals("GearL")) {
	    type = TyleType.GearL;
	} else if(string.equals("Conveyor1")) {
	    type = TyleType.Conveyor1;
	} else if(string.equals("Conveyor2")) {
	    type = TyleType.Conveyor2;
	} else if(string.equals("Conveyor3")) {
	    type = TyleType.Conveyor3;
	} else if(string.equals("Checkpoint")) {
	    type = TyleType.Checkpoint;
	} else {
	    type = TyleType.Floor;
	}
	
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

    public void setObstacle(Obstacle obstacle2) {
	obstacle = obstacle2;
    }

    public boolean isContainsRobot() {
        return containsRobot;
    }

    public void setType(TyleType tp) {
	type = tp;
    }

    public int getDir() {
	return dir;
    }

    public void setDir(int dir) {
	this.dir = dir;
    }

    public int getRbt() {
	return rbt;
    }

    public void setRbt(int rbt) {
	this.rbt = rbt;
    }

}