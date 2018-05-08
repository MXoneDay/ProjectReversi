package model;

import view.CellPane;

public class Board {
	private CellPane[][] board;
	
	Board(int hor, int ver){
		board = new CellPane[ver][hor];
	}
	
	public boolean checkFilled(int hor, int ver) {
		return true;
	}
	
	public void setInBoard(Object ocp) {
		CellPane cp = (CellPane) ocp;
		board[cp.ver][cp.hor] = cp;
	}
	
	/*
	public void reset() {
		for(int  i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j].getChildren().clear();
				board[i][j].filled = 0;
			}
		}
	}*/
	
	public CellPane getCell(int hor, int ver) {
		return board[ver][hor];
	}
}