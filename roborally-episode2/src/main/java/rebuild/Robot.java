package rebuild;

public class Robot {

    private int xCoor;
    private int yCoor;
    private int dir;
    private int lives;
    private boolean inCorner;

    Robot() {}

    public Robot(Integer int1, Integer int2, Integer int3) {
	xCoor = int1; yCoor = int2; dir = int3;
    }

    public void setCoor(int[] coor) {
	xCoor = coor[0]; yCoor = coor[1];
    }

    public int[] getCoor() {
	return new int[] {xCoor,yCoor};
    }

    public int getDir() {
	return dir;
    }

    public void setDir(int dir) {
	this.dir = dir;
    }

    public boolean isDead() {
	boolean valid = false;
	
	if(lives <= 0) {
	    valid = true;
	}
	return valid;
    }

    public void takeDamage(int damage) {
	lives = lives - damage;
    }

    public boolean isInCorner() {
	return inCorner;
    }

    public void setInCorner(boolean inCorner) {
	this.inCorner = inCorner;
    }

    public int getLives() {
	return lives;
    }



}