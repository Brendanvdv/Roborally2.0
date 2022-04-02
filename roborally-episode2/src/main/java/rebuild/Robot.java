package rebuild;

public class Robot {
    
    private int[] coordinate;
    private boolean inCorner = false;
    private int dir;

    public boolean isInCorner() {
	return inCorner;
    }

    public void setInCorner(boolean inCorner) {
        this.inCorner = inCorner;
    }
    
    public void setCoor(int[] coor) {
	setCoordinate(coor);
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

}
