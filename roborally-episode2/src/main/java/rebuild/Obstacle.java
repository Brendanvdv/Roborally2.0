package rebuild;

public class Obstacle {
    private int damage = 0;
    private String type;
    
    public Obstacle(String s) {
	if(s.equals("Pit")) {
	    setType("Pit");
	    setDamage(100000);
	} else if(s.equals("Barrel")) {
	    setType("Barrel");
	} else if(s.equals("Laser")) {
	    setType("Laser");
	    setDamage(1);
	} else if(s.equals("Acid")) {
	    setType("Acid");
	    setDamage(1);
	} else if(s.equals("Health")) {
	    setType("Health");
	    setDamage(-1);
	} else if(s.equals("Conveyor1")) {
	    setType("Conveyor1");
	} else if(s.equals("Conveyor2")) {
	    setType("Conveyor2");
	} else if(s.equals("Conveyor3")) {
	    setType("Conveyor3");
	} else if(s.equals("GearL")) {
	    setType("GearL");
	} else if(s.equals("GearR")) {
	    setType("GearR");
	} else {
	    setType("Floor");
	}
    }
    public String getType() {
	return type;
    }
    public void setType(String type) {
	this.type = type;
    }
    
    public int getDamage() {
	return damage;
    }
    
    public void setDamage(int damage) {
        this.damage = damage;
    }

}
