package notdefault;

import java.util.ArrayList;

public class Robot {
    private ArrayList<int[]> corners = new ArrayList<int[]>();
    private boolean inCorner = true;
    private int xCoord;
    private int yCoord;
    private int[] xyCoord;
    private int direction;

    public Robot() {

    }

    public void setCoord(ArrayList<int[]> c) {
	for(int i = 0; i<c.size(); i++ ) {
	    corners.add(c.get(i));
	}
	xCoord = corners.get(0)[0];
	yCoord = corners.get(0)[1];
	xyCoord = new int[] {xCoord, yCoord};
	corners.remove(0);
    }
    
    public void setCoord(ArrayList<int[]> c, int corner) {
	corners = c;
	xCoord = corners.get(corner)[0];
	yCoord = corners.get(corner)[1];
	xyCoord = corners.get(corner);
    }

    public void setDir() {
	if(xCoord == 0 && yCoord == 0) {
	    direction = 2;
	} else if(xCoord != 0 && yCoord == 0) {
	    direction = 3;
	} else if(xCoord == 0 && yCoord != 0) {
	    direction = 0;
	} else {
	    direction = 1;
	}
    }

    public ArrayList<int[]> getCorners() {
	return corners;
    }

    public int getX() {
	return xCoord;
    }

    public int getY() {
	return yCoord;
    }

    public int[] getXY() {
	return xyCoord;
    }

    public int getDir() {
	return direction;
    }

    public boolean isInCorner() {
	return inCorner;
    }

    public void setInCorner(boolean inCorner) {
	this.inCorner = inCorner;
    }

}
