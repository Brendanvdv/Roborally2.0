package appModel;

public class Robot {

    private int xCoor;
    private int yCoor;
    private int dir;
    private int lives = 3;
    private int number;
    
    Robot() {
	setCoor(new int[] {5,5});
	setDir(0);
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

    public int getLives() {
	return lives;
    }

    public int getNumber() {
	return number;
    }

    public void setNumber(int number) {
	this.number = number;
    }



}