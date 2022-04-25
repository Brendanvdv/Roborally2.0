package rebuild;

public class Robot {
    private int lives = 3;
    private int[] coordinate;
    private boolean inCorner = false;
    private int dir;
    private boolean dead = false;
    
    public Robot(int xCoor, int yCoor, int direction) {
	coordinate = new int[] {xCoor,yCoor};
	dir = direction;
    }
    
    Robot(){}

    public boolean isInCorner() {
	return inCorner;
    }

    public void setInCorner(boolean inCorner) {
        this.inCorner = inCorner;
    }
    
    public int getDir() {
	return dir;
    }

    public void setDir(int dir) {
	this.dir = dir;
    }

    public int[] getCoordinate() {
	return coordinate;
    }

    public void setCoordinate(int[] coordinate) {
	this.coordinate = coordinate;
    }

    public void takeDamage(Obstacle obstacle) {
	lives = lives - obstacle.getDamage();
    }
    
    public int getLives() {
	return lives;
    }

    public boolean isDead() {
	return dead;
    }

    public void checkDead() {
	if(lives <= 0) {
	    dead = true;
	}
    }

}
