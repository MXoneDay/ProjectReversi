package games;

public class Tictactoe implements Game {
	private final int hor = 3, ver = 3;
	private int board[][] = new int[hor][ver];
	private boolean turn = true;
	//private boolean win = false;

	@Override
	public int getHor() {
		return hor;
	}

	@Override
	public int getVer() {
		return ver;
	}
	
	@Override
	public void check(int hor, int ver) {
		System.out.println("tictactoe: " + hor + ver);
		// check if the move is valid
		if(turn) {
			if(hor <= this.hor) {// check if move is within board
				if(ver <= this.ver) {// check if move is within board
					if(board[hor][ver] == 0) {// controleren of de plek leeg is
						System.out.println(board[hor][ver]);
						// zet in board
						board[hor][ver] = 1;
						turn = false;
					}
				}
			}
		}
		//versturen
	}
	/*
	private void winCheck() {
		win = true;
		for(int i = 0; i < hor; i++) {
			for(int j = 0; j < ver; j++) {
				if(board[i][j] == 0) {
					win = false;
					return;
				}
			}
		}
		
		if(win) {
			return;
		}
		
		for(int i = 0; i < hor; i++) {
			for(int j = 0; j < ver; j++) {
				if(board[j][i] == 0) {
					win = false;
					return;
				}
			}
		}
		if(win) {
			return;
		}
		
		if(board[0][0] != 0) {
			if(board[1][1] != 0) {
				if(board [2][2] != 0) {
					return;
				}
			}
		}
		
		if(win) {
			return;
		}
		
		if(board[2][0] != 0) {
			if(board[1][1] != 0) {
				if(board[0][2] != 0) {
					return;
				}
			}
		}
	}*/

}
