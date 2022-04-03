package rebuild;

import java.util.Objects;

public class Tile {
    private TyleType type;
    private int diff;
    private Obstacle obstacle;

    public Tile(int difficulty) {
	diff = difficulty;
	init();
    }
    
    public void init() {
	double val = Math.random();
	double x = 0.65 - diff*0.1;
	double y = (1 - x)/7;


	if(val < x) {
	    type = TyleType.Floor;
	    obstacle = new Obstacle();
	} else if(val < x+y) {
	    type = TyleType.Pit;
	    obstacle = new Pit();
	} else if(val < x+2*y) {
	    type = TyleType.Barrel;
	    obstacle = new Barrel();
	} else if(val < x+3*y) {
	    type = TyleType.Laser;
	    obstacle = new Laser();
	} else if(val < x+4*y) {
	    type = TyleType.Acid;
	    obstacle = new Acid();
	} else if(val < x+5*y) {
	    type = TyleType.Health;
	    obstacle = new Health();
	} else if(val < x+6*y) {
	    type = TyleType.Conveyor;
	    obstacle = new Conveyor();
	} else {
	    type = TyleType.Gear;
	    obstacle = new Gear();
	}
    }

    public TyleType getType() {
	return type;
    }
    
    public void setType(TyleType tileType) {
	type = tileType;
    }
    
    public boolean validObstacle() {
	if(!Objects.isNull(obstacle)) {
	    return true;
	}
	
	return false;
    }

    public Obstacle getObstacle() {
	return obstacle;
    }
}
