package notdefault;

public class Board {
	private int rows;
	private int cols;
	private String[][] board;
	
	public Board(int int1, int int2) {
		this.rows = int1;
		this.cols = int2;
		this.board = new String[cols][rows];
	}
	
	public int[] getSize() {
		return new int[] {board[0].length, board.length};
	}
	
	
}
