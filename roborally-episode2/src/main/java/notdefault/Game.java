package notdefault;

public class Game {
    private Board board;
    
    public void startGame(int int1, int int2, int int3) {
	board = new Board(int1,int2);
	board.spawnRobot(int3);
    }
    
    public Board getBoard(){
	return board;
    }
}
