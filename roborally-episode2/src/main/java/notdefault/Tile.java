package notdefault;

public class Tile {

    private TileType type;
    public Tile() {
    }
    
    public void init() {
	double val = Math.random();
	
	if(val< 0.65) {
	    this.type = TileType.Floor;
	} else if(val< 0.7) {
	    this.type = TileType.Pit;
	} else if(val< 0.75) {
	    this.type = TileType.Barrel;
	} else if(val< 0.8) {
	    this.type = TileType.Laser;
	} else if(val< 0.85) {
	    this.type = TileType.Acid;
	} else if(val< 0.9) {
	    this.type = TileType.Health;
	} else if(val< 0.95) {
	    this.type = TileType.Conveyor;
	} else {
	    this.type = TileType.Gear;
	}
    }
    
    public TileType getType() {
	return type;
    }
 }
