package notdefault;

import java.util.ArrayList;
import java.util.Iterator;

public class Board {
    private Tile[][] board;
    private ArrayList<Robot> robots = new ArrayList<Robot>();;
    private ArrayList<int[]> corners = new ArrayList<int[]>();
    private boolean checkpoint = false;
    private boolean overlap = true;


    public Board(int length, int width) {
	this.board = new Tile[length][width];
	corners.add(new int[] {0,0});
	corners.add(new int[] {board[0].length-1,board.length-1});
	corners.add(new int[] {0,board.length-1});
	corners.add(new int[] {board[0].length-1,0});

	init(2);
    }
    
    public Board(int length, int width, int diff) {

	this.board = new Tile[length][width];
	corners.add(new int[] {0,0});
	corners.add(new int[] {board[0].length-1,board.length-1});
	corners.add(new int[] {0,board.length-1});
	corners.add(new int[] {board[0].length-1,0});

	init(diff);
    }

    public void init() {
	init(2);
    }
    
    public void init(int diff) {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[0].length; j++) {
		board[i][j] = new Tile(diff);
	    }
	}
    }

    public void robotCorners() {
	for (int i = 0; i < robots.size(); i++) {
	    board[robots.get(i).getXY()[0]][robots.get(i).getXY()[1]].setType(TileType.Floor);
	}
    }

    public void spawnRobot(int num) {
	robots = new ArrayList<Robot>();
	for(int i = 0; i<num; i++) {
	    robots.add(new Robot());
	    robots.get(i).setCoord(corners);
	    robots.get(i).setDir();
	    updateCorners(robots.get(i).getCorners());
	}
	robotCorners();
	overlap();
	inCorner();
    }

    public void spawnRobot(int num, int corner) {
	robots = new ArrayList<Robot>();
	for(int i = 0; i<num; i++) {
	    robots.add(new Robot());
	    robots.get(i).setCoord(corners,corner);
	    robots.get(i).setDir();
	    updateCorners(robots.get(i).getCorners());
	}
	overlap();
	inCorner();
    }

    public void updateCorners(ArrayList<int[]> c) {
	corners = c;
    }

    public void inCorner() {
	
	for(int i = 0; i<robots.size(); i++) {
	    if(robots.get(i).getX() != 0 && robots.get(i).getX() != board.length-1) {
		robots.get(i).setInCorner(false);
	    }
	    if(robots.get(i).getY() != 0 && robots.get(i).getY() != board[0].length-1) {
		robots.get(i).setInCorner(false);
	    }
	}
    }

    public void overlap() {
	int temp = robots.size();
	for(Robot robot:robots) {
	    for(int i = 0; i < robots.size(); i++) {
		if(robot.getX() == robots.get(i).getX() && robot.getY() == robots.get(i).getY()) {
		    temp = temp - 1;
		}
	    }
	}
	if(temp == 0) {
	    overlap = false;
	}
    }

    public void spawnCheckpoint() {
	getCenterTile().setType(TileType.Checkpoint);
	checkpoint = true;
    }

    public Tile getCenterTile() {
	int x;
	int y;

	if(board.length%2 == 0) {
	    x = board.length/2;
	} else {
	    x = (int) Math.floor(board.length/2);
	}
	if(board[0].length%2 == 0) {
	    y = board[0].length/2;
	} else {
	    y = (int) Math.floor(board[0].length/2);
	}
	return board[x][y];


    }

    public boolean hasCheckpoint() {
	return checkpoint;
    }

    public ArrayList<Robot> getRobots() {
	return robots;
    }

    public Tile getTile(int int1, int int2) {
	return board[int1][int2];
    }

    public int[] getSize() {
	return new int[] {board.length, board[0].length};
    }
    
    public Tile[][] getBoard() {
	return board;
    }
    
    public boolean getOverlap() {
	return overlap;
    }
}
