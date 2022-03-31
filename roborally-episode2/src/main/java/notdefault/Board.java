package notdefault;

import java.util.ArrayList;
import java.util.Iterator;

public class Board {
    private Tile[][] board;
    private ArrayList<Robot> robots;
    private ArrayList<int[]> corners = new ArrayList<int[]>();


    public Board(int int1, int int2) {

	this.board = new Tile[int1][int2];
	corners.add(new int[] {0,0});
	corners.add(new int[] {board[0].length-1,board.length-1});
	corners.add(new int[] {0,board.length-1});
	corners.add(new int[] {board[0].length-1,0});

	init();
    }

    public void init() {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[0].length; j++) {
		board[i][j] = new Tile();
	    }
	}
    }

    public int[] getSize() {
	return new int[] {board.length, board[0].length};
    }

    public void spawnRobot(int num) {
	robots = new ArrayList<Robot>();
	for(int i = 0; i<num; i++) {
	    robots.add(new Robot());
	    robots.get(i).setCoord(corners);
	    robots.get(i).setDir();
	    updateCorners(robots.get(i).getCorners());
	}
    }

    public void spawnRobot(int num, int corner) {
	robots = new ArrayList<Robot>();
	for(int i = 0; i<num; i++) {
	    robots.add(new Robot());
	    robots.get(i).setCoord(corners,corner);
	    robots.get(i).setDir();
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
	    } else if(robots.get(i).getX() == board[0].length-1 && robots.get(i).getY() == board.length-1) {
		return true;
	    } else if(robots.get(i).getX() == 0 && robots.get(i).getY() == board.length-1) {
		return true;
	    } else if(robots.get(i).getX() == board[0].length-1 && robots.get(i).getY() == 0) {
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

    public Tile getTile(int int1, int int2) {
	return board[int1][int2];
    }

    public void spawnCheckpoint() {
	getCenterTile().setType(TileType.Checkpoint);
	System.out.println(getCenterTile().getType());
    }

    public Tile getCenterTile() {
	double val = Math.random();
	int x = 0;
	if(val<0.5) {
	    x = 1;
	}

	if(board.length-1%2 == 0 && board[0].length-1%2 == 0) {
	    return board[board.length/2 - x][board[0].length/2 - x];
	} else if(board.length-1%2 != 0 && board[0].length-1%2 == 0) {
	    return board[(int) Math.floor(board.length/2)][board[0].length/2 - x];
	} else if(board.length-1%2 == 0 && board[0].length-1%2 != 0) {
	    return board[board.length/2 - x][(int) Math.floor(board[0].length/2)];
	} else {
	    return board[(int) Math.floor(board.length/2)][(int) Math.floor(board[0].length/2)];
	}
    }

    public boolean hasCheckpoint() {
	for(Tile[] column : board) {
	    for(Tile row : column) {
		if(row.getType().equals(TileType.Checkpoint)) {
		    return true;
		    //		}
		}
	    }
	}
	return false;
    }
}
