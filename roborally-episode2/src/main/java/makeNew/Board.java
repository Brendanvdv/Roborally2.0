package makeNew;

public class Board {

    private Tile[][] gameBoard;

    private int cols;
    private int rows;

    public Board(int length, int width, int difficulty) {
	cols = length; rows = width;

	init(difficulty);
    }

    private void init(int difficulty) {
	gameBoard = new Tile[cols][rows];

	for(int i = 0; i < cols; i++) {
	    for(int j = 0; j < rows; j++) {

		if(i == 0 && j == 0 || i == cols-1 && j == 0 || i == 0 && j == rows-1 || i == cols-1 && j == rows-1) {
		    gameBoard[i][j] = new Tile(TyleType.Floor);
		} else if( i == findCenter()[0] && j == findCenter()[1]) {
		    gameBoard[i][j] = new Tile(TyleType.Checkpoint);
		} else {
		    gameBoard[i][j] = new Tile(difficulty);
		}
	    }
	}

    }

    public int[] findCenter() {
	int x; int y;

	if(gameBoard.length%2 == 0) {
	    x = gameBoard.length/2;
	} else {
	    x = (gameBoard.length-1)/2;
	}

	if(gameBoard[0].length%2 == 0) {
	    y = gameBoard[0].length/2;
	} else {
	    y = (gameBoard[0].length-1)/2;
	}
	
	return new int[] {x,y};
    }

    public Tile getTile(int[] coor) {
	return gameBoard[coor[0]][coor[1]];
    }

    public int getCols() {
	return cols;
    }

    public int getRows() {
	return rows;
    }

    public Tile[][] getTiles() {
	return gameBoard;
    }
}
