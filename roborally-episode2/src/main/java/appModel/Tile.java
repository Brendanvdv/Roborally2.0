package appModel;

import java.util.Objects;

public class Tile {
    
    private Obstacle obstacle;
    private TyleType type;

    private boolean containsRobot;
    private int rbt;
    private int dir;

    public Tile(String string) {
	
	if(string.equals("Acid")) {
	    type = TyleType.Acid;
	} else if(string.equals("Barrel")) {
	    type = TyleType.Barrel;
	} else if(string.equals("Pit")) {
	    type = TyleType.Pit;
	} else if(string.equals("LaserV")) {
	    type = TyleType.LaserV;
	} else if(string.equals("LaserH")) {
	    type = TyleType.LaserH;
	} else if(string.equals("Health")) {
	    type = TyleType.Health;
	} else if(string.equals("GearR")) {
	    type = TyleType.GearR;
	} else if(string.equals("GearL")) {
	    type = TyleType.GearL;
	} else if(string.equals("ConveyorN")) {
	    type = TyleType.ConveyorN;
	} else if(string.equals("ConveyorS")) {
	    type = TyleType.ConveyorS;
	} else if(string.equals("ConveyorE")) {
	    type = TyleType.ConveyorE;
	} else if(string.equals("ConveyorW")) {
	    type = TyleType.ConveyorW;
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