package appModel;

public class Obstacle {
    private int damage = 0;
    private String type;

    public Obstacle(TyleType type) {
	if(type.equals(TyleType.Pit)) {
	    setType("Pit");
	    setDamage(100000);
	} else if(type.equals(TyleType.Barrel)) {
	    setType("Barrel");
	} else if(type.equals(TyleType.LaserV)) {
	    setType("LaserV");
	    setDamage(1);
	} else if(type.equals(TyleType.LaserH)) {
	    setType("LaserH");
	    setDamage(1);
	} else if(type.equals(TyleType.Acid)) {
	    setType("Acid");
	    setDamage(1);
	} else if(type.equals(TyleType.Health)) {
	    setType("Health");
	    setDamage(-1);
	} else if(type.equals(TyleType.ConveyorN)) {
	    setType("ConveyorN");
	} else if(type.equals(TyleType.ConveyorS)) {
	    setType("ConveyorS");
	} else if(type.equals(TyleType.ConveyorW)) {
	    setType("ConveyorW");
	} else if(type.equals(TyleType.ConveyorE)) {
	    setType("ConveyorE");
	} else if(type.equals(TyleType.GearL)) {
	    setType("GearL");
	} else if(type.equals(TyleType.GearR)) {
	    setType("GearR");
	} else if(type.equals(TyleType.Checkpoint)){
	    setType("Checkpoint");
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