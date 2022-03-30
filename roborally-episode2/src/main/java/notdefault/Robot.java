package notdefault;

import java.util.ArrayList;

public class Robot {
	private ArrayList<int[]> corners = new ArrayList<int[]>();
	private int xCoord;
	private int yCoord;
	private int[] xyCoord;
	
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
	
}
