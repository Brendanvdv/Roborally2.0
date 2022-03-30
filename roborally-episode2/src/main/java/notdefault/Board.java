package notdefault;

import java.util.ArrayList;

public class Board {
	private int rows;
	private int cols;
	private String[][] board;
	private ArrayList<Robot> robots;
	private ArrayList<int[]> corners = new ArrayList<int[]>();


	public Board(int int1, int int2) {
		this.rows = int1;
		this.cols = int2;
		this.board = new String[cols][rows];
		corners.add(new int[] {0,0});
		corners.add(new int[] {rows-1,cols-1});
		corners.add(new int[] {0,cols-1});
		corners.add(new int[] {rows-1,0});
	}
	
	public int[] getSize() {
		return new int[] {board[0].length, board.length};
	}
	
	public void spawnRobot(int num) {
		for(int i = 0; i<num; i++) {
			robots.add(new Robot());
			robots.get(i).setCoord(corners);
			updateCorners(robots.get(i).getCorners());
		}
	}
	
	public void updateCorners(ArrayList<int[]> c) {
		corners = c;
	}
	
	public ArrayList<Robot> getRobots() {
		return robots;
	}
	
	public boolean inCorner() {
		for(int i = 0; i<robots.size(); i++) {
			if(robots.get(i).getX() == 0 && robots.get(i).getY() == 0) {
				return true;
			} else if(robots.get(i).getX() == rows-1 && robots.get(i).getY() == cols-1) {
				return true;
			} else if(robots.get(i).getX() == 0 && robots.get(i).getY() == cols-1) {
				return true;
			} else if(robots.get(i).getX() == rows-1 && robots.get(i).getY() == 0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean overlap() {
		int temp = 0;
		for(Robot robot:robots) {
			for(int i = 0; i < robots.size(); i++) {
				if(robot.getXY() == robots.get(i).getXY()) {
					temp++;
				}
			}
		}
		if(temp == 1) {
			return true;
		}
		return false;
	}
	
}
