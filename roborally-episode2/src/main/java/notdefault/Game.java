package notdefault;

public class Game {
    private int diff;
    private Board board;
    
    public void startGame(int length, int width, int playerAmount) {
	board = new Board(length,width);
	board.spawnRobot(playerAmount);
    }
    
    public void startGame(int length, int width, int playerAmount, int diff) {
	board = new Board(length,width,diff);
	board.spawnRobot(playerAmount);
    }
    
    public void setDiff(int int1) {
	diff = int1;
    }
    
    public Tile[][] getBoardArray(){
	return board.getBoard();
    }
    
    public Board getBoard(){
	return board;
    }
}
