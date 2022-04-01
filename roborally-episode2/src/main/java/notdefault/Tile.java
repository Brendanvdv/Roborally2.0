package notdefault;

public class Tile {

    private TileType type;
    
    public Tile() {
	init();
    }

    public Tile(int diff) {
	init(diff);
    }
    
    public void init() {
	init(2);
    }
    
    public void init(int diff) {
	double val = Math.random();
	double x = 0.65 - diff*0.1;
	double y = (1 - x)/7;
	
	if(val < x) {
	    this.type = TileType.Floor;
	} else if(val < y) {
	    this.type = TileType.Pit;
	} else if(val < 2*y) {
	    this.type = TileType.Barrel;
	} else if(val < 3*y) {
	    this.type = TileType.Laser;
	} else if(val < 4*y) {
	    this.type = TileType.Acid;
	} else if(val < 5*y) {
	    this.type = TileType.Health;
	} else if(val < 6*y) {
	    this.type = TileType.Conveyor;
	} else {
	    this.type = TileType.Gear;
	}
    }
    
    public TileType getType() {
	return type;
    }
    public void setType(TileType tileType) {
	type = tileType;
    }
 }
