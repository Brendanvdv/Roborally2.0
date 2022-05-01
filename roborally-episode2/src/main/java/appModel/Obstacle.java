package appModel;

public class Obstacle {
	private int damage = 0;
	private String type;
	private String sound;

	public Obstacle(TyleType type) {
		if (type.equals(TyleType.Pit)) {
			setType("Pit");
			setSound("Pit");
			setDamage(100000);
		} else if (type.equals(TyleType.Barrel)) {
			setType("Barrel");
			setSound("Barrel");
		} else if (type.equals(TyleType.LaserV)) {
			setType("LaserV");
			setSound("Laser");
			setDamage(1);
		} else if (type.equals(TyleType.LaserH)) {
			setType("LaserH");
			setSound("Laser");
			setDamage(1);
		} else if (type.equals(TyleType.Acid)) {
			setType("Acid");
			setSound("Acid");
			setDamage(1);
		} else if (type.equals(TyleType.Health)) {
			setType("Health");
			setSound("Health");
			setDamage(-1);
		} else if (type.equals(TyleType.ConveyorN)) {
			setType("ConveyorN");
			setSound("Conveyor");
		} else if (type.equals(TyleType.ConveyorS)) {
			setType("ConveyorS");
			setSound("Conveyor");
		} else if (type.equals(TyleType.ConveyorW)) {
			setType("ConveyorW");
			setSound("Conveyor");
		} else if (type.equals(TyleType.ConveyorE)) {
			setType("ConveyorE");
			setSound("Conveyor");
		} else if (type.equals(TyleType.GearL)) {
			setType("GearL");
			setSound("Gear");
		} else if (type.equals(TyleType.GearR)) {
			setType("GearR");
			setSound("Gear");
		} else if (type.equals(TyleType.Checkpoint)) {
			setType("Checkpoint");
			setSound("Checkpoint");
		} else {
			setType("Floor");
			setSound("Floor");
		}
	}

	private void setDamage(int i) {
		damage = i;
	}

	private void setType(String string) {
		type = string;
	}

	private void setSound(String string) {sound = string;}

	public int getDamage() {
		return damage;
	}

	public String getType() {
		return type;
	}

	public String getSound() {
		return sound;
	}

}