package rebuild;

public class Tile {
    private TyleType type;
    private int diff;

    Tile(int difficulty) {
	diff = difficulty;
	init();
    }
    
    public void init() {
	double val = Math.random();
	double x = 0.65 - diff*0.1;
	double y = (1 - x)/7;
	
	if(val < x) {
	    type = TyleType.Floor;
	} else if(val < y) {
	    type = TyleType.Pit;
	} else if(val < 2*y) {
	    type = TyleType.Barrel;
	} else if(val < 3*y) {
	    type = TyleType.Laser;
	} else if(val < 4*y) {
	    type = TyleType.Acid;
	} else if(val < 5*y) {
	    type = TyleType.Health;
	} else if(val < 6*y) {
	    type = TyleType.Conveyor;
	} else {
	    type = TyleType.Gear;
	}
    }
    
    public TyleType getType() {
	return type;
    }
    public void setType(TyleType tileType) {
	type = tileType;
    }
}
