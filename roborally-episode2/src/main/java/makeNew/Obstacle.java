package makeNew;

public class Obstacle {
    private int damage = 0;
    private String type;

    public Obstacle(TyleType type) {
	if(type.equals(TyleType.Pit)) {
	    setType("Pit");
	    setDamage(100000);
	} else if(type.equals(TyleType.Barrel)) {
	    setType("Barrel");
	} else if(type.equals(TyleType.Laser)) {
	    setType("Laser");
	    setDamage(1);
	} else if(type.equals(TyleType.Acid)) {
	    setType("Acid");
	    setDamage(1);
	} else if(type.equals(TyleType.Health)) {
	    setType("Health");
	    setDamage(-1);
	} else if(type.equals(TyleType.Conveyor1)) {
	    setType("Conveyor1");
	} else if(type.equals(TyleType.Conveyor2)) {
	    setType("Conveyor2");
	} else if(type.equals(TyleType.Conveyor3)) {
	    setType("Conveyor3");
	} else if(type.equals(TyleType.GearL)) {
	    setType("GearL");
	} else if(type.equals(TyleType.GearR)) {
	    setType("GearR");
	} else {
	    setType("Floor");
	}
    }

    private void setDamage(int i) {
	damage = i;
    }

    private void setType(String string) {
	type = string;
    }

    public int getDamage() {
	return damage;
    }

    public String getType() {
	return type;
    }

}
