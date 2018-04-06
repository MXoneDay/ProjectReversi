package model;

public class Tictactoe implements Game {
	private final int hor = 3, ver = 3;
	private int board[][] = new int[hor][ver];
	private boolean turn = true;

	@Override
	public int getHor() {
		return hor;
	}

	@Override
	public int getVer() {
		return ver;
	}
	
	public void createAI() {
		new TictactoeAI(this);
	}
	
	@Override
	public void move(int hor, int ver) {
		System.out.println("tictactoe: " + hor + ver);
		// check if the move is valid
		if(turn) {
			if(hor <= this.hor) {// check if move is within board
				if(ver <= this.ver) {// check if move is within board
					if(board[hor][ver] == 0) {// controleren of de plek leeg is
						System.out.println(board[hor][ver]);
						// zet in board
						board[hor][ver] = 1;
						//turn = false;
					}
				}
			}
		}
		//versturen
	}
}
